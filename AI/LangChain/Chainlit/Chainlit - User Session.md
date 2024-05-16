# User Session

The user session is designed to persist data in memory through the [life cycle](https://docs.chainlit.io/concepts/chat-lifecycle) of a chat session. Each user session is unique to a user and a given chat session.

## Why use the user session?

Let’s say you want to keep track of each chat session message count.

A naive implementation might look like this: