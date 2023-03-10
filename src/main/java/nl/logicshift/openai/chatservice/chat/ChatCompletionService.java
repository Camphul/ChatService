package nl.logicshift.openai.chatservice.chat;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return CompletionRequest.builder().maxTokens(70).model(requestDto.model()).prompt(requestDto.prompt()).echo(true).user("testing").n(1).build();
    }

    public CompletionResult complete(CompletionRequest completionRequest) {
        log.info("Creating a completion: {}", completionRequest.toString());
        return this.openAiService.createCompletion(completionRequest);
    }
}
