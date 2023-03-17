package nl.logicshift.openai.chatservice.chat;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for generating completions.
 *
 * @author Camphul
 */
@Slf4j
@Service
@AllArgsConstructor
public class ChatCompletionService {

    private final OpenAiService openAiService;

    public CompletionResult complete(CompletionRequestDto requestDto) {
        return complete(toRequest(requestDto));
    }

    public CompletionRequest toRequest(CompletionRequestDto requestDto) {
        return CompletionRequest.builder().maxTokens(1000).model(requestDto.model()).prompt(requestDto.prompt())
                .echo(true).user("testing").n(1).build();
    }

    public CompletionResult complete(CompletionRequest completionRequest) {
        log.info("Creating a completion: {}", completionRequest.toString());
        return this.openAiService.createCompletion(completionRequest);
    }

    public ChatCompletionResult complete(ChatCompletionRequest request) {
        log.info("Creating chat completion: {}", request);
        return this.openAiService.createChatCompletion(request);
    }

    public ChatCompletionRequest toChatRequest(CompletionRequestDto requestDto) {
        return ChatCompletionRequest.builder().model(requestDto.model()).n(1).maxTokens(1000).user("assistant")
                .messages(List.of(new ChatMessage("user", requestDto.prompt()))).build();
    }
}
