import os
import torch
from datasets import load_dataset
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig, TrainingArguments, pipeline, logging, AutoConfig
from peft import LoraConfig
from trl import SFTTrainer
import sys
from peft import LoraConfig, PeftModel


token = "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"
output_dir="./results"
base_model = "NousResearch/Llama-2-7b-chat-hf"
config = AutoConfig.from_pretrained(base_model)

new_model = "llama-2-7b-chat-luca"

dataset_cli = "khwaja2708/luca-cli"
dataset = load_dataset(dataset_cli, split="train",token=token)
print("Data sample : ",dataset[0])
print(sys.getsizeof(dataset))
print(dataset.features)

# 4-bit Quantization Configuration
compute_dtype = getattr(torch, "float16")
quant_config = BitsAndBytesConfig(load_in_4bit=True, 
                                  bnb_4bit_quant_type="nf4", 
                                  bnb_4bit_compute_dtype=compute_dtype, 
                                  bnb_4bit_use_double_quant=False)

# Load model with 4-bit precision
model = AutoModelForCausalLM.from_pretrained(
                                base_model, 
                                quantization_config=quant_config, 
                                device_map={"": 0},
                                token=token)
model.config.use_cache = False
model.config.pretraining_tp = 1




tokenizer = AutoTokenizer.from_pretrained(base_model, trust_remote_code=True,token=token)
tokenizer.pad_token = tokenizer.eos_token
tokenizer.padding_side = "right"

peft_params = LoraConfig(lora_alpha=16, 
                         lora_dropout=0.1, 
                         r=64, 
                         bias="none",
                         task_type="CAUSAL_LM")

training_params = TrainingArguments(output_dir="./results", 
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

trainer = SFTTrainer(model=model, 
                     train_dataset=dataset, 
                     peft_config=peft_params, 
                     max_seq_length=None, 
                     tokenizer=tokenizer, 
                     args=training_params,
                     packing=False,
                      dataset_text_field="text"
                     )

import gc
torch.cuda.empty_cache()
gc.collect()

trainer.train()

# model.config.to_json_file("config.json")


# trainer.model.merge_and_unload()

trainer.model.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca")
trainer.tokenizer.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca")
torch.save(trainer.model.state_dict(), 'C:\Luca_Model\llama-2-7b-chat-luca\pytorch_model.bin'.format(1))
trainer.model.config.to_json_file("config.json")
config.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca")

# trainer.model.merge_and_unload()

# # model.merge_and_unload()
question = ""
while question != 'exit':
    question = input('Ask > ')
    if question != 'exit':
        prompt = question
        pipe = pipeline(task="text-generation", model=model, tokenizer=tokenizer, max_length=80)
        result = pipe(f"<s>[INST] {prompt} [/INST]")
        # print(result)
        print(result[0]['generated_text'])

# Reload model in FP16 and merge it with LoRA weights




