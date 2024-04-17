We have a clear explanation for integration of custom hugging face model with Ollama in this video [Ollama:Hugging face model]([https://youtu.be/TFwYvHZV6j0?si=rOmQlIQGnNcOd25M](https://youtu.be/TFwYvHZV6j0?si=rOmQlIQGnNcOd25M "https://youtu.be/tfwyvhzv6j0?si=romqliqgnncod25m"))  .

In order to integrate a hugging face model we will be needing **GPT-Generated Unified Format** GGFU file. GGUF is **a file format for storing models for inference with GGML and executors based on GGML**. GGUF is a binary format that is designed for fast loading and saving of models, and for ease of reading. Models are traditionally developed using PyTorch or another framework, and then converted to GGUF for use in GGML
GGUF, introduced by the llama.cpp team, is a replacement for GGML, which is no longer supported. It offers several advantages over GGML, including improved tokenization, support for special tokens, and extensibility. GGUF stores more information about the model as metadata, making it a future-proof format. It enhances performance, especially with models using new special tokens and custom prompt templates.

In order to convert the hugging face model to GGUF we will be needing Pytorch-model.bin files with base model weights added to new model created weights.

![[Pasted image 20240408152131.png]]

Add this files to the Hugging face repo as shown below. In the below image we have ggfu file but as of now you will not be having that file please skip this file.
![[Pasted image 20240408161401.png]]

If we just use the above files to generate GGFU file it throws error of **unknow weight layer.0** as we have not merge the LoRA weights with the base model. In order to merge LoRA weights with base model we need to fallow this steps:
1. Reload the base model.
2. Merge the LoRA weights with base model.
3. Save the new weights or new weights model.

```python
import os
import torch
from transformers import AutoModelForCausalLM, AutoTokenizer
from peft import  PeftModel
from huggingface_hub import login
  
login()

model_name = "NousResearch/Llama-2-7b-chat-hf"
  
base_model = AutoModelForCausalLM.from_pretrained(
    model_name,
    low_cpu_mem_usage=True,
    return_dict=True,
    torch_dtype=torch.float16,
    device_map="cpu",
)

model = PeftModel.from_pretrained(base_model, "khwaja2708/Luca_GPT_1.0")
model = model.merge_and_unload()

# This method merges the LoRa layers into the base model. This is needed if someone wants to use the base model as a standalone model.

  
tokenizer = AutoTokenizer.from_pretrained(model_name, trust_remote_code=True)
tokenizer.pad_token = tokenizer.eos_token
tokenizer.padding_side = "right"

model.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca\merged")
tokenizer.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca\merged")
```

Once this is executed successfully then your base model is merged with LoRA weights and generates more **Pytorch-mode.bin** files with **generation_config.json** file as shown below:

![[Pasted image 20240408162044.png]]



Now that we have completed with merging the LoRA weights to finetuned model we are ready to generate GGFU file of are model.

In order to generate GGFU file please have a look at [Github link]([Tutorial: How to convert HuggingFace model to GGUF format · ggerganov/llama.cpp · Discussion #2948 (github.com)](https://github.com/ggerganov/llama.cpp/discussions/2948)).

Once you have cloned the llama.cpp & ready with folder structure as shown in above link

![[Pasted image 20240408164253.png]]



```
On the final command > python llama.cpp/convert.py llama-2-7b-chat-luca 
  --outfile lucaGPT_1.0.1.gguf \
  --outtype f16
```

Once this is successfully completed without any error we will be ready with GUFF file.

![[Pasted image 20240408164809.png]]

So, the final step to integrate the gguf with ollama environment. If you can go through the youtube video shown at start [Ollama:Hugging face model]([https://youtu.be/TFwYvHZV6j0?si=rOmQlIQGnNcOd25M](https://youtu.be/TFwYvHZV6j0?si=rOmQlIQGnNcOd25M "https://youtu.be/tfwyvhzv6j0?si=romqliqgnncod25m")). Its just two easy steps to integrate. 
1. Create a  Modelfile with GGUF.
2. Use Ollama create command to transfer new model data to ollama.
![[Pasted image 20240408170013.png]]
Once successfully completed, Ollama environment is now available with  lucaGPT is ready with  
![[Pasted image 20240408174110.png]]

Final interaction: 
![[Pasted image 20240408174430.png]]
