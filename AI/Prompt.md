A prompt for a language model is a set of instructions or input provided by a user to guide the model's response, helping it understand the context and generate relevant and coherent language-based output, such as answering questions, completing sentences, or engaging in a conversation.

LangChain provides several classes and functions to help construct and work with prompts.

# Prompt templates

Prompt templates are pre-defined recipes for generating prompts for language models.

A template may include instructions, few-shot examples, and specific context and questions appropriate for a given task.

LangChain provides tooling to create and work with prompt templates.

LangChain strives to create model agnostic templates to make it easy to reuse existing templates across different language models.

Typically, language models expect the prompt to either be a string or else a list of chat messages.

## `PromptTemplate`[​](https://python.langchain.com/docs/modules/model_io/prompts/prompt_templates/#prompttemplate "Direct link to prompttemplate")

Use `PromptTemplate` to create a template for a string prompt.

By default, `PromptTemplate` uses [Python’s str.format](https://docs.python.org/3/library/stdtypes.html#str.format) syntax for templating.

```
from langchain.prompts import PromptTemplateprompt_template = PromptTemplate.from_template(    "Tell me a {adjective} joke about {content}.")prompt_template.format(adjective="funny", content="chickens")
```

```
'Tell me a funny joke about chickens.'
```

The template supports any number of variables, including no variables:

```
from langchain.prompts import PromptTemplateprompt_template = PromptTemplate.from_template("Tell me a joke")prompt_template.format()
```

```
'Tell me a joke'
```

For additional validation, specify `input_variables` explicitly. These variables will be compared against the variables present in the template string during instantiation, **raising an exception if there is a mismatch**. For example:

```
from langchain.prompts import PromptTemplateinvalid_prompt = PromptTemplate(    input_variables=["adjective"],    template="Tell me a {adjective} joke about {content}.",)
```

```
ValidationError: 1 validation error for PromptTemplate__root__  Invalid prompt schema; check for mismatched or missing input parameters. 'content' (type=value_error)
```

You can create custom prompt templates that format the prompt in any way you want. For more information, see [Custom Prompt Templates](https://python.langchain.com/docs/modules/model_io/prompts/prompt_templates/custom_prompt_template.html).

## `ChatPromptTemplate`[​](https://python.langchain.com/docs/modules/model_io/prompts/prompt_templates/#chatprompttemplate "Direct link to chatprompttemplate")

The prompt to [chat models](https://python.langchain.com/docs/modules/model_io/prompts/models/chat) is a list of chat messages.

Each chat message is associated with content, and an additional parameter called `role`. For example, in the OpenAI [Chat Completions API](https://platform.openai.com/docs/guides/chat/introduction), a chat message can be associated with an AI assistant, a human or a system role.

Create a chat prompt template like this:

```
from langchain.prompts import ChatPromptTemplatechat_template = ChatPromptTemplate.from_messages(    [        ("system", "You are a helpful AI bot. Your name is {name}."),        ("human", "Hello, how are you doing?"),        ("ai", "I'm doing well, thanks!"),        ("human", "{user_input}"),    ])messages = chat_template.format_messages(name="Bob", user_input="What is your name?")
```

`ChatPromptTemplate.from_messages` accepts a variety of message representations.

For example, in addition to using the 2-tuple representation of (type, content) used above, you could pass in an instance of `MessagePromptTemplate` or `BaseMessage`.

```python
from langchain.chat_models import ChatOpenAI
from langchain.prompts import HumanMessagePromptTemplate,ChatPromptTemplate
from langchain.schema.messages import SystemMessage

chat_template = ChatPromptTemplate.from_messages(
    [
        SystemMessage(
            content=(
                "You are a helpful assistant that re-writes the user's text to "
                "sound more upbeat."
            )
        ),
        HumanMessagePromptTemplate.from_template("{text}"),
    ]
)
llm = ChatOpenAI()

print(llm(chat_template.format_messages(text="i dont like eating tasty things.")))
```

```python
AIMessage(content='I absolutely love indulging in delicious treats!')
```

This provides you with a lot of flexibility in how you construct your chat prompts.