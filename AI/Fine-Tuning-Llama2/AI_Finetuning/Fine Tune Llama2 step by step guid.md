Let’s dive into the fascinating world of **Llama 2**, a remarkable language model. Llama 2 is a collection of second-generation open-source LLMs from Meta that comes with a commercial license .Imagine Llama 2 as a super-smart chatbot that can understand and generate human language. Its brain is like a vast library—it read billions of books (well, not literally, but you get the idea). Now, our goal is to fine-tune Llama 2, making it even more useful and friendly.

Llama-2-Chat, which is optimized for dialogue, has shown similar performance to popular closed-source models like **ChatGPT** and **PaLM**. We can even improve the performance of the model by fine-tuning it on a high-quality conversational dataset.

**Fine-tuning in machine learning** is the process of adjusting the weights and parameters of a pre-trained model on new data to improve its performance on a specific task. It involves training the model on a new dataset that is specific to the task at hand while updating the model's weights to adapt to the new data.

**Note:** As we will be needing GPU environment and if you are going with Google Co Lab go with memory more than 20GB which needs a pro version, for free it provides you only 16GB with which you always get some memory issues indirectly.

## How to Fine-Tune Llama 2: A Step-By-Step Guide.

### 1. Getting started 
   We will get started by installing required libraries in the python environment (I have been using pipenv [pipenv]([pipenv · PyPI](https://pypi.org/project/pipenv/)) ).   
   
   ` pipenv install datasets peft trl torch transformers(version 4.31)`
   Install torch from this web site based on the CUDA version. [Pytorch]([PyTorch](https://pytorch.org/))
   ![[Pasted image 20240408121225.png]]
   In **pipenv** the command is 
   `pipenv install torch torchvision torchaudio -i https://download.pytorch.org/whl/cu118`
   
   Once installed validate all the installations in **PipFile** (where all the installed dependencies can be seen)
   After that local all the necessary modules from this libraries.
```python
import os
import torch
from datasets import load_dataset
from transformers import (
    AutoModelForCausalLM,
    AutoTokenizer,
    BitsAndBytesConfig,
    TrainingArguments,
    pipeline,
    logging,
)
from peft import LoraConfig
from trl import SFTTrainer
```

### 2. Model configuration 
You can access the Meta’s official Llama-2 model from Hugging Face, but you have to apply for a request to get access token. Me after getting read access token from hugging face started accessing model **"NousResearch/Llama-2-7b-chat-hf"** which will be are base model.

```python
# Model from Hugging Face hub
base_model = "NousResearch/Llama-2-7b-chat-hf"

# New instruction dataset
luca_dataset = "khwaja2708/luca-cli"

# Fine-tuned model
new_model = "llama-2-7b-chat-luca""
```
If you to know dataset mentioned above, you can find here [khawja2708/Luca-cli]([leap-cli-1.0.1.jsonl · khwaja2708/luca-cli at main (huggingface.co)](https://huggingface.co/datasets/khwaja2708/luca-cli/blob/main/leap-cli-1.0.1.jsonl)).
![[Pasted image 20240408123226.png]]

The prompt template we are using is 
```
<s>[INST] <<SYS>>
System prompt
<</SYS>> 
User prompt [/INST] Model Answer </s>
```

### 3. Loading dataset, model, and tokenizer

```python
dataset = load_dataset(dataset_cli, split="train",token=token)
# To validate your data set  
print("Data sample : ",dataset[0])
```

### 4. 4-bit quantization configuration

4-bit quantization via QLoRA allows efficient finetuning of huge LLM models on consumer hardware while retaining high performance. This dramatically improves accessibility and usability for real-world applications.

QLoRA quantizes a pre-trained language model to 4 bits and freezes the parameters. A small number of trainable Low-Rank Adapter layers are then added to the model.

During fine-tuning, gradients are backpropagated through the frozen 4-bit quantized model into only the Low-Rank Adapter layers. So, the entire pretrained model remains fixed at 4 bits while only the adapters are updated. Also, the 4-bit quantization does not hurt model performance.

![[Pasted image 20240408124438.png]]

In our case, we create 4-bit quantization with NF4 type configuration using BitsAndBytes.

```python
# 4-bit Quantization Configuration

compute_dtype = getattr(torch, "float16")
quant_config = BitsAndBytesConfig(load_in_4bit=True,
                                  bnb_4bit_quant_type="nf4",
                                  bnb_4bit_compute_dtype=compute_dtype,
                                  bnb_4bit_use_double_quant=False)
```

### 5. Loading Llama 2 model

We will now load a model using 4-bit precision with the compute dtype "float16" from Hugging Face for faster training.

```python
# Load model with 4-bit precision

model = AutoModelForCausalLM.from_pretrained(
                                base_model,
                                quantization_config=quant_config,
                                device_map={"": 0},
                                token=token)
model.config.use_cache = False
model.config.pretraining_tp = 1
```

### 6. Loading tokenizer

Next, we will load the tokenizer from Hugginface and set `padding_side` to “right” to fix the issue with fp16.

```python
tokenizer = AutoTokenizer.from_pretrained(base_model, trust_remote_code=True)
tokenizer.pad_token = tokenizer.eos_token
tokenizer.padding_side = "right"
```

### 7. PEFT parameters

Traditional fine-tuning of pre-trained language models (PLMs) requires updating all of the model's parameters, which is computationally expensive and requires massive amounts of data.

Parameter-Efficient Fine-Tuning (PEFT) works by only updating a small subset of the model's most influential parameters, making it much more efficient.

```python
peft_params = LoraConfig(
    lora_alpha=16,
    lora_dropout=0.1,
    r=64,
    bias="none",
    task_type="CAUSAL_LM",
)
```

### 8. Training Parameter

Below is a list of hyperparameters that can be used to optimize the training process:

- **num_train_epochs:** One training epoch.
- **fp16/bf16:** Disable fp16/bf16 training.
- **per_device_train_batch_size:** Batch size per GPU for training.
- **per_device_eval_batch_size:** Batch size per GPU for evaluation.
- **gradient_accumulation_steps:** This refers to the number of steps required to accumulate the gradients during the update process.
- **gradient_checkpointing:** Enabling gradient checkpointing.
- **max_grad_norm:** Gradient clipping.
- **learning_rate:** Initial learning rate.
- **weight_decay:** Weight decay is applied to all layers except bias/LayerNorm weights.
- **Optim:** Model optimizer (AdamW optimizer).
- **lr_scheduler_type:** Learning rate schedule.
- **max_steps:** Number of training steps.
- **warmup_ratio:** Ratio of steps for a linear warmup.
- **group_by_length:** This can significantly improve performance and accelerate the training process.
- **save_steps:** Save checkpoint every 25 update steps.
- **logging_steps:** Log every 25 update steps.

```python
training_params = TrainingArguments(
                                    num_train_epochs=1,
                                    per_device_train_batch_size=4,
                                    per_device_eval_batch_size=4,
                                    gradient_accumulation_steps=1,
                                    optim="paged_adamw_32bit",
                                    save_steps=25,
                                    logging_steps=25,
                                    learning_rate=2e-4,
                                    weight_decay=0.001,
                                    fp16=True,
                                    bf16=False,
                                    max_grad_norm=0.3,
                                    max_steps=-1,
                                    warmup_ratio=0.03,
                                    group_by_length=True,
                                    lr_scheduler_type="constant",
                                    report_to="tensorboard")
                                    
```

### 9. Model Fine-tuning
**Supervised fine-tuning** (SFT) is a key step in reinforcement learning from human feedback (RLHF). The TRL library from HuggingFace provides an easy-to-use API to create SFT models and train them on your dataset with just a few lines of code. It comes with tools to train language models using reinforcement learning, starting with supervised fine-tuning, then reward modeling, and finally, proximal policy optimization (PPO).

We will provide SFT Trainer the model, dataset, Lora configuration, tokenizer, and training parameters.

```python
trainer = SFTTrainer(
    model=model,
    train_dataset=dataset,
    peft_config=peft_params,
    dataset_text_field="text",
    max_seq_length=None,
    tokenizer=tokenizer,
    args=training_params,
    packing=False,
)
```

We will use `.train()` to fine-tune the Llama 2 model on a new dataset. It took one and a half hours for the model to complete 1 epoch.

After training the model, we will save the model adopter and tokenizers. You can also upload the model to Hugging Face using a similar API.

```python
# This will generate a set of file with a name stored in new_model folder and generate only adapter_model.safetensors along with adabter config files.
trainer.model.save_pretrained(new_model)
trainer.tokenizer.save_pretrained(new_model)
# OR you can specify the folder location where the file needs to be saved
trainer.model.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca")
trainer.tokenizer.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca")

# we will be needing pytorch_model.bin which will be use to generating GGFU files
torch.save(trainer.model.state_dict(), 'C:\Luca_Model\llama-2-7b-chat-luca\pytorch_model.bin'.format(1))
```


You can actually generate and test the result from the fine-tuned model as shown below
``` python
question = ""

while question != 'exit':

    question = input('Ask > ')

    if question != 'exit':

        prompt = question

        pipe = pipeline(task="text-generation", model=model, tokenizer=tokenizer, max_length=20)

        result = pipe(f"<s>[INST] {prompt} [/INST]")

        print(result[0]['generated_text'])
```

A successful train will have logs as shown below: 
![[Pasted image 20240408142514.png]]

![[Pasted image 20240408151847.png]]

![[Pasted image 20240408151913.png]]

This are the file that would be generated on successful training the model under the folder **llama-2-7b-chat-luca** (New Model name)
![[Pasted image 20240408152131.png]]