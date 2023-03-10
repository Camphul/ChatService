package nl.logicshift.openai.chatservice.chat;

import jakarta.validation.constraints.NotEmpty;

/**
 * Completion request dto.
 *
 * @param model  the model to use (ada/
 * @param prompt the text prompt to generate a completion for.
 * @author Camphul
 */
public record CompletionRequestDto(@NotEmpty String model, @NotEmpty String prompt) {
}
