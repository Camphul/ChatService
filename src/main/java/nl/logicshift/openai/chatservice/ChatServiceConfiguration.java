package nl.logicshift.openai.chatservice;

import com.theokanning.openai.service.OpenAiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Configuration for ChatService
 * @author Camphul
 */
@Slf4j
@Configuration
public class ChatServiceConfiguration {
    /**
     * OpenAI api token bean. Scoped as singleton.
     * @return openai api token
     */
    @Bean(name = "openAiApiToken")
    @ConditionalOnMissingBean(name = "openAiApiToken")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public String openAiApiToken() {
        return System.getenv("OPENAI_API_TOKEN");
    }

    /**
     * OpenAI Service bean. Scoped as SINGLETON
     * @return openai service bean.
     */
    @Bean(name = "openAiService")
    @ConditionalOnBean(name = "openAiApiToken")
    @ConditionalOnMissingBean(name = "openAiService")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public OpenAiService openAiService() {
        log.debug("Creating openAiService bean");
        return new OpenAiService(openAiApiToken());
    }
}
