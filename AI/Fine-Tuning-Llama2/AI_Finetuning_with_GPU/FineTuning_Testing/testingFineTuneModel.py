import os
import torch
from datasets import load_dataset
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig, TrainingArguments, pipeline, logging
from peft import LoraConfig
from trl import SFTTrainer
from huggingface_hub import login

login()

token = "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"
# output_dir="./results"
# base_model = "khwaja2708/Luca_GPT_1.0"
base_model = "C:\Luca_Model\llama-2-7b-chat-luca"


# 4-bit Quantization Configuration
compute_dtype = getattr(torch, "float16")
quant_config = BitsAndBytesConfig(load_in_4bit=True, 
                                  bnb_4bit_quant_type="nf4", 
                                  bnb_4bit_compute_dtype=compute_dtype, 
                                  bnb_4bit_use_double_quant=False)

# Load model with 4-bit precision
model = AutoModelForCausalLM.from_pretrained(base_model, quantization_config=quant_config, device_map={"": 0},use_auth_token=token)
model.config.use_cache = False
model.config.pretraining_tp = 1

# print(model)

tokenizer = AutoTokenizer.from_pretrained(base_model, trust_remote_code=True)
tokenizer.pad_token = tokenizer.eos_token
tokenizer.padding_side = "right"



question = ""
while question != 'exit':
    question = input('Ask > ')
    if question != 'exit':
        prompt = question
        pipe = pipeline(task="text-generation", model=model, tokenizer=tokenizer, max_length=80)
        result = pipe(f"<s>[INST] {prompt} [/INST]")
        # print(result)
        print(result[0]['generated_text'])
