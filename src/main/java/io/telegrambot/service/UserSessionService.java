package io.telegrambot.service;

import io.telegrambot.model.UserSession;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserSessionService {

    private Map<Long, UserSession> userSessionMap = new HashMap<>();

    public UserSession saveSession(Long chatId, UserSession userSession){
        return userSessionMap.put(chatId, userSession);
    }
    public UserSession getSession(Long chatId){
        return userSessionMap.getOrDefault(chatId, UserSession
                .builder()
                .chatId(chatId)
                .build());
    }
}
