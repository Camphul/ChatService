# ChatService

Spring Boot integration with [TheoKanning/openai-java](https://github.com/TheoKanning/openai-java).

This project serves as an example integration with OpenAi API service.

Please add the environment variable `OPENAI_API_TOKEN` with your api token.

Send a post to `http://localhost:8080/chat` with the json body as follows:

```json
{
    "model": "ada",
    "prompt": "Somebody once told me the world is gonna roll me"
}
```

## OpenAIService bean

The `ChatServiceConfiguration` Spring configuration created a singleton scoped bean of the `OpenAiService` class. This can be used to communicate with the OpenAI API.