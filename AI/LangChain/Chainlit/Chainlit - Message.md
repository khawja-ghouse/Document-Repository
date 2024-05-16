# Message

A Message is a piece of information that is sent from the user to an assistant and vice versa. Coupled with life cycle hooks, they are the building blocks of a chat.

A message has a content, a timestamp and cannot be nested.

Lets create a simple assistant that replies to a user message with a greeting.

```python
import chainlit as cl

@cl.on_message
async def on_message(message: cl.Message):
    response = f"Hello, you just sent: {message.content}!"
    await cl.Message(response).send()
```

## Display a loader while waiting for a response

If a task is running and the latest message content is empty, Chainlit will display a loader while the content remains empty.

```python
import chainlit as cl


@cl.on_message
async def on_message(message: cl.Message):
    msg = cl.Message(content="")
    await msg.send()

    # do some work
    await cl.sleep(2)

    msg.content = f"Processed message {message.content}"

    await msg.update()
```

# Step

LLM powered Assistants take a series of steps to process a user’s request. Unlike a [Message](https://docs.chainlit.io/concepts/concepts/message), a Step has an input/output, a start/end and can be nested.

Together, Steps form a Chain of Thought. Displaying the steps of a Chain of Thought is useful both for the end user (to understand what the Assistant is doing) and for the developer (to debug the Assistant).

## A Simple Chain of Thought

Lets take a simple example of a Chain of Thought that takes a user’s message, process it and sends a response.

```python
import chainlit as cl


@cl.step
async def tool():
    # Simulate a running task
    await cl.sleep(2)

    return "Response from the tool!"


@cl.on_message
async def main(message: cl.Message):
    # Call the tool
    tool_res = await tool()

    # Send the final answer.
    await cl.Message(content="This is the final answer").send()

```

