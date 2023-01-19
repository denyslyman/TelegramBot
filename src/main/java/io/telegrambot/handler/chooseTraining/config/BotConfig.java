package io.telegrambot.handler.chooseTraining.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class BotConfig {

    @Value("${bot.name}")
    String botName;

    @Value("${bot.token}")
    String botToken;


    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.url}")
    private String url;
}
