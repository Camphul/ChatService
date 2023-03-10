# ChatService

Spring Boot integration with [TheoKanning/openai-java](https://github.com/TheoKanning/openai-java).

This project serves as an example integration with OpenAi API service.

Please add the environment variable `OPENAI_API_TOKEN` with your api token.

Send a post to `http://localhost:8080/chat` with the json body as follows:

```json
{
    "model": "davinci",
    "prompt": "Somebody once told me the world is gonna roll me"
}
```

To use the chatgpt-3.5 turbo model post to `http://localhost:8080/chat/conversation` with the body:

```json
{
    "model": "gpt-3.5-turbo",
    "prompt": "Only give me the answer. What is 8+8?"
}
```

## OpenAIService bean

The `ChatServiceConfiguration` Spring configuration created a singleton scoped bean of the `OpenAiService` class. This can be used to communicate with the OpenAI API.