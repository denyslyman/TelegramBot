package io.telegrambot.model;

import io.telegrambot.enums.State;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSession {
    private String text;
    private Long chatId;
    private State state;

}
