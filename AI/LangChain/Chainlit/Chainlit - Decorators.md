# Chat Life Cycle

Whenever a user connects to your **Chainlit** app, a new chat session is created. A chat session goes through a life cycle of events, which you can respond to by defining hooks.
## On Chat Start
The **@cl.on_chat_start** decorator is used to define a hook that is called when a new chat session is created.
```python
@cl.on_chat_start
def on_chat_start():
    print("A new chat session has started!")
```
## On Message

The  **@cl.on_message** decorator is used to define a hook that is called when a new message is received from the user.
```python
@cl.on_message
def on_message(msg: cl.Message):
    print("The user sent: ", msg.content)
```
## On Stop

The `on_stop` decorator is used to define a hook that is called when the user clicks the stop button while a task was running.
```python
@cl.on_stop
def on_stop():
    print("The user wants to stop the task!")
```

## On Chat End

The **on_chat_end** decorator is used to define a hook that is called when the chat session ends either because the user disconnected or started a new chat session.
```python
@cl.on_chat_end
def on_chat_end():
    print("The user disconnected!")
```

## On Chat Resume

The **on_chat_resume** decorator is used to define a hook that is called when a user resumes a chat session that was previously disconnected. This can only happen if authentication data persistence are enabled.
```python
from chainlit.types import ThreadDict

@cl.on_chat_resume
async def on_chat_resume(thread: ThreadDict):
    print("The user resumed a previous chat session!")

```