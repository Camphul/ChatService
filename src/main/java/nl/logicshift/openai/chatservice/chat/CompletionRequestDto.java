package nl.logicshift.openai.chatservice.chat;

/**
 * Completion request dto.
 * @param model the model to use (ada/
 * @param prompt
 */
public record CompletionRequestDto(String model, String prompt) {
}
