The most common and valuable composition is taking:

`PromptTemplate` / `ChatPromptTemplate` -> `LLM` / `ChatModel` -> `OutputParser`

```python
from langchain.chat_models import ChatOpenAI
from langchain.prompts import ChatPromptTemplate

prompt = ChatPromptTemplate.from_template("tell me a joke about {foo}")
model = ChatOpenAI()
chain = prompt | model

chain.invoke({"foo": "bears"})

output : 
AIMessage(content="Why don't bears wear shoes?\n\nBecause they have bear feet!", additional_kwargs={}, example=False)
```

### Attaching Stop Sequences

```python
chain = prompt | model.bind(stop=["\n"])

chain.invoke({'foo':'bears'})

output:
AIMessage(content='Why did the bear never wear shoes?', additional_kwargs={}, example=False)
```

### Attaching Function Call information

```python
functions = [
    {
        "name": "joke",
        "description": "A joke",
        "parameters": {
            "type": "object",
            "properties": {
                "setup": {"type": "string", "description": "The setup for the joke"},
                "punchline": {
                    "type": "string",
                    "description": "The punchline for the joke",
                },
            },
            "required": ["setup", "punchline"],
        },
    }
]
chain = prompt | model.bind(function_call={"name": "joke"}, functions=functions)

chain.invoke({"foo": "bears"}, config={})

output:
____________
AIMessage(content='', additional_kwargs={'function_call': {'name': 'joke', 'arguments': '{\n  "setup": "Why don\'t bears wear shoes?",\n  "punchline": "Because they have bear feet!"\n}'}}, example=False)
```


