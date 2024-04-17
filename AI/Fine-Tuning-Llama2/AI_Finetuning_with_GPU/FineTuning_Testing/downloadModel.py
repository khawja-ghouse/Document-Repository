import os
import torch
from transformers import AutoModelForCausalLM, AutoTokenizer
from peft import  PeftModel

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

# Reload tokenizer to save it
tokenizer = AutoTokenizer.from_pretrained(model_name, trust_remote_code=True)
tokenizer.pad_token = tokenizer.eos_token
tokenizer.padding_side = "right"



model.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca\merged")
tokenizer.save_pretrained("C:\Luca_Model\llama-2-7b-chat-luca\merged")