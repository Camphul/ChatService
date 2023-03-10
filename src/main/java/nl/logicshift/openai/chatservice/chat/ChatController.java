package nl.logicshift.openai.chatservice.chat;

import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for chat conversations.
 *
 * @aythor Camphul
 */
@Controller
@Slf4j
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private final ChatCompletionService chatCompletionService;

    @PostMapping
    public @ResponseBody CompletionResult chat(@RequestBody CompletionRequestDto requestDto) {
        log.info("Generating response for  request {}", requestDto.toString());
        CompletionResult result = this.chatCompletionService.complete(requestDto);
        result.getChoices().forEach(choice -> log.info("Result choice: {}", choice.toString()));
        return result;
    }

    @PostMapping("/conversation")
    public @ResponseBody ChatCompletionResult chatConversation(@RequestBody CompletionRequestDto requestDto) {
        log.info("Generating response for  request {}", requestDto.toString());
        ChatCompletionResult result = this.chatCompletionService.complete(this.chatCompletionService.toChatRequest(requestDto));
        result.getChoices().forEach(choice -> log.info("Result choice: {}", choice.toString()));
        return result;
    }
}
