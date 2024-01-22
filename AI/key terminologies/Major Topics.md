### Training vs Fine Tuning
   Training and fine-tuning are both processes involved in the development and improvement of machine learning and AI models, but they serve different purposes and occur at different stages:
   
  **Training:**
- **Purpose:** Training is the initial process where an AI model learns patterns and features from a dataset to understand relationships and make predictions or perform tasks. It involves adjusting the model's parameters (weights and biases) based on input data to minimize a predefined loss function.
- **Data:** During training, the model learns from a dataset that typically includes labeled examples, where the input data is associated with corresponding correct outputs or labels. This process helps the model learn to generalize and make accurate predictions on new, unseen data.
- **Initialization:** In the training phase, model parameters are often initialized randomly or with specific techniques before being optimized through iterations.
- **Outcome:** The goal of training is to create an initial model that performs reasonably well on a specific task or dataset. It results in a model with learned representations based on the initial training data.

 **Fine-Tuning:**

- **Purpose:** Fine-tuning, on the other hand, occurs after the initial training of a pre-existing model. It involves further training the already trained model, often on new or additional data, to adapt it to a different task, domain, or improve its performance on specific aspects.
- **Data:** Fine-tuning typically uses a smaller, task-specific dataset or additional data related to a specific domain. This process allows the model to adjust its learned representations to better fit the new data or task requirements.
- **Initialization:** The model being fine-tuned already has learned parameters from its initial training. Fine-tuning involves updating these existing parameters rather than starting from scratch.
- **Outcome:** The objective of fine-tuning is to make incremental adjustments to an existing model so that it becomes more proficient in a different task or domain without losing the previously learned knowledge.

### When to use Fine Tuning?

Fine-tuning refers to the process of taking a pre-trained machine learning model and further training it on a specific dataset or task of interest. It involves adjusting the parameters of an already trained model to better suit a particular domain or to improve performance on a specific task.

Here are situations when fine-tuning can be beneficial:

1. **Transfer Learning:** Fine-tuning is commonly used in transfer learning. Pre-trained models, like those in natural language processing (NLP) or computer vision, trained on large and diverse datasets, have learned useful features and patterns. Fine-tuning allows you to take advantage of this pre-existing knowledge and adapt the model to a new, smaller dataset or a different task.
    
2. **Task-specific Performance Improvement:** When you have a pre-trained model that performs reasonably well but needs optimization for a specific task or dataset, fine-tuning can enhance its performance. For instance, in NLP, a pre-trained language model like GPT (Generative Pre-trained Transformer) might be fine-tuned on a smaller dataset for sentiment analysis or text classification tasks.
    
3. **Domain Adaptation:** Fine-tuning helps adapt a model to a particular domain. For instance, if you have a computer vision model trained on general images and want it to perform well on medical images, fine-tuning on a dataset of medical images can help the model adapt to this specialized domain.
    
4. **Limited Data Availability:** In scenarios where you have limited labeled data for a specific task, fine-tuning a pre-trained model can be beneficial. The pre-trained model has already learned general patterns from a large dataset, and fine-tuning requires less labeled data compared to training a model from scratch.
    
5. **Time and Resource Efficiency:** Fine-tuning can be computationally more efficient than training a model from scratch. Training a model from scratch on a large dataset can be resource-intensive, whereas fine-tuning usually requires fewer computational resources and less time.
    
6. **Customization for Specific Requirements:** Fine-tuning allows you to customize a model to address specific requirements or constraints of your problem domain. By adjusting the parameters of the pre-trained model, you can tailor it to suit your needs better.

### When to use text embedding?

Text embedding is a technique used to represent words or phrases as numerical vectors in a continuous space. These embeddings capture semantic relationships between words, enabling machine learning models to understand and work with textual data more effectively. Here are some scenarios where text embeddings are commonly used:

1. **Natural Language Processing (NLP) Tasks:** Text embeddings are widely used in various NLP tasks such as sentiment analysis, text classification, machine translation, question answering, and named entity recognition. Embeddings help convert text into numerical representations that machine learning models can process and learn from.
    
2. **Semantic Similarity and Information Retrieval:** Text embeddings encode semantic information, allowing for the measurement of similarity between words, sentences, or documents. They are beneficial in information retrieval systems, recommendation engines, and search algorithms to find semantically similar or related content.
    
3. **Word Embeddings for Word Representations:** Word embeddings like Word2Vec, GloVe, and FastText are used to represent words as dense vectors. These embeddings capture semantic relationships and contextual information of words in a continuous space, enabling models to understand similarities and differences between words.
    
4. **Document Embeddings for Document Representations:** Doc2Vec and other document embedding techniques represent entire documents as vectors. These embeddings capture the overall semantic meaning and context of documents, facilitating document classification, clustering, or retrieval tasks.
    
5. **Reducing Dimensionality in Text Data:** Text embeddings often have lower-dimensional representations compared to traditional one-hot encoded vectors. This reduction in dimensionality can be beneficial in reducing computational complexity while retaining essential semantic information.
    
6. **Transfer Learning and Fine-tuning:** Pre-trained text embeddings are used in transfer learning approaches, where models trained on large corpora are fine-tuned for specific tasks or domains with smaller datasets. These pre-trained embeddings capture general language patterns and can be adapted to new tasks with limited labeled data.


## What is prompt engineering?

Prompt engineering is the process where you guide generative artificial intelligence (generative AI) solutions to generate desired outputs. Even though generative AI attempts to mimic humans, it requires detailed instructions to create high-quality and relevant output. In prompt engineering, you choose the most appropriate formats, phrases, words, and symbols that guide the AI to interact with your users more meaningfully. Prompt engineers use creativity plus trial and error to create a collection of input texts, so an application's generative AI works as expected.


Libraries for LLM development [Lanchain](https://python.langchain.com/docs)
