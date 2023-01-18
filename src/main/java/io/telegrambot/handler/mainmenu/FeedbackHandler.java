package io.telegrambot.handler.mainmenu;

import io.telegrambot.enums.State;
import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.model.UserSession;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;

@Component
public class FeedbackHandler extends UserRequestHandler {

    private static String FEEDBACK = "Feedback✍️";
    private final KeyboardsBuilder keyboardsBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public FeedbackHandler(KeyboardsBuilder keyboardsBuilder, TelegramService telegramService, UserSessionService userSessionService) {
        this.keyboardsBuilder = keyboardsBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {
        telegramService.sendMessage(user.getChatId(), "Leave your feedback");

        UserSession userSession = user.getUserSession();
        userSession.setState(State.WAITING_FOR_FEEDBACK);
        userSessionService.saveSession(userSession.getChatId(),userSession);

    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(), FEEDBACK);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
