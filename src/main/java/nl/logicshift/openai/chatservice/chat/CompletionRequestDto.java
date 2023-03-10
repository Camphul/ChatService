package nl.logicshift.openai.chatservice.chat;

/**
 * Completion request dto.
 *
 * @param model  the model to use (ada/
 * @param prompt the text prompt to generate a completion for.
 * @author Camphul
 */
public record CompletionRequestDto(String model, String prompt) {
}
