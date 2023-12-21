A prompt is a set of instructions or inputs to guide the model’s response. The output from a prompt can be answers, sentence completions, or conversation responses. A well-constructed prompt template has the following sections:

- **Instructions**: Define the model’s response/behaviour.
- **Context**: Provides additional information, sometimes with examples.
- **User Input**: The actual question or input from the user.
- **Output Indicator**: Marks the beginning of the model’s response.

### What is a Prompt Template?

Generating, sharing, and reusing prompts in a reproducible manner can be achieved using a few key components.

These include a text string or template that takes inputs and produces a prompt for the LLM, instructions to train the LLM, few-shot examples to enhance the model’s response, and a question to guide the language model.

These pre-defined recipes can contain instructions, context, few-shot examples, and questions that are appropriate for a particular task.

LangChain offers a set of tools for creating and working with prompt templates. These templates are designed to be model-agnostic, making them easier to reuse across different language models. Language models generally require prompts to be in the form of a string or a list of chat messages.

Why Use Prompt Templates? Prompt templates are useful when multiple inputs are needed, making code cleaner and more manageable.

### Prompt templates in LangChain

LangChain provides **`PromptTemplate`** to help create parametrized prompts for language models.

A **`PromptTemplate`** allows creating a template string with placeholders, like **`{adjective}`** or **`{content}`** that can be formatted with input values to create the final prompt string.

Some key features:

- Validation of input variables against the template
- Flexible input values — can pass dictionaries, data classes, etc
- Support for different templating engines like Python’s `str.format` or Jinja2
- Easy to extend and create custom templates

Well large language models receive as input something which is called a prompt.
What is a prompt is simply text input that we give the LM and the processes it and returns us an output.

So for each different prompt I will get different output because the input was different. So this is the first abstraction that langchain is introducing us its prompt template. And it's simply a wrapper class around a prompt. So it adds functionality to prompt to receive an input. For example, we can run this prompt now many times with different inputs.


## Agent

The core idea of agents is to use a language model to choose a sequence of actions to take. In **chains, a sequence of actions is hardcoded (in code)**. **In agents, a language model is used as a reasoning engine to determine which actions to take and in which order.**

This is the chain responsible for deciding what step to take next. This is powered by a language model and a prompt. The inputs to this chain are:

1. Tools: Descriptions of available tools
2. User input: The high level objective
3. Intermediate steps: Any (action, tool output) pairs previously executed in order to achieve the user input.

Different agents have different prompting styles for reasoning, different ways of encoding inputs, and different ways of parsing the output. For a full list of built-in agents see [agent types](https://python.langchain.com/docs/modules/agents/agent_types/). You can also **easily build custom agents**, which we show how to do in the Get started section below.

## Tools
Tools are functions that an agent can invoke. There are two important design considerations around tools:

1. Giving the agent **access to the right tools**.
2. **Describing** the tools in a way that is **most helpful to the agent**.

Without thinking through both, you won't be able to build a working agent. If you don't give the agent access to a correct set of tools, it will never be able to accomplish the objectives you give it. If you don't describe the tools well, the agent won't know how to use them properly.

LangChain provides a wide set of built-in tools, but also makes it easy to define your own (including custom descriptions).
For a full list of built-in tools, see the [tools integrations section](https://python.langchain.com/docs/integrations/tools/)


### Toolkits[​](https://python.langchain.com/docs/modules/agents/#toolkits "Direct link to Toolkits")

For many common tasks, an agent will need a set of related tools. For this LangChain provides the concept of toolkits - groups of around 3-5 tools needed to accomplish specific objectives. For example, the GitHub toolkit has a tool for searching through GitHub issues, a tool for reading a file, a tool for commenting, etc.

LangChain provides a wide set of toolkits to get started. For a full list of built-in toolkits, see the [toolkits integrations section](https://python.langchain.com/docs/integrations/toolkits/)

### AgentExecutor[​](https://python.langchain.com/docs/modules/agents/#agentexecutor "Direct link to AgentExecutor")

The agent executor is the runtime for an agent. This is what actually calls the agent, executes the actions it chooses, passes the action outputs back to the agent, and repeats. In pseudocode, this looks roughly like:
