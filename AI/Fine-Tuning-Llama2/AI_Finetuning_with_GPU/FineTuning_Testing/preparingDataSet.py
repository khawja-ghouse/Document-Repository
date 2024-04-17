from datasets import load_dataset,Dataset

# Define your custom dataset
data = {
    "question": ["What is the capital of France?", "Who wrote 'Romeo and Juliet'?"],
    "answer": ["Paris", "William Shakespeare"]
}

# Create a dataset
custom_dataset = Dataset.from_dict(data)

print(custom_dataset)

# Save the dataset (optional)
# custom_dataset.save_to_disk("my_custom_dataset")