package io.telegrambot;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.model.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Dispatcher {

    private final List<UserRequestHandler> handlers;


    public Dispatcher(List<UserRequestHandler> handlers) {
        this.handlers = handlers
                .stream()
                .sorted(Comparator.comparing(UserRequestHandler::isGlobal)
                        .reversed())
                .collect(Collectors.toList());
    }
    public boolean dispatch(User user) {
        for (UserRequestHandler userRequestHandler : handlers) {
            if (userRequestHandler.isApplicable(user)) {
                userRequestHandler.enter(user);
                return true;
            }

        }
        return false;
    }
}
