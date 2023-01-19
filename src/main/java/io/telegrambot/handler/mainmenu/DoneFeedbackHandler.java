package io.telegrambot.handler.mainmenu;

import io.telegrambot.enums.State;
import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.model.UserSession;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class DoneFeedbackHandler extends UserRequestHandler {
    private final StartMessageHandler startMessageHandler;
    private final TelegramService telegramService;
    private final KeyboardsBuilder keyboardsBuilder;
    private final UserSessionService userSessionService;


    public DoneFeedbackHandler(StartMessageHandler startMessageHandler, TelegramService telegramService,
                               KeyboardsBuilder keyboardsBuilder, UserSessionService userSessionService) {

        this.startMessageHandler = startMessageHandler;
        this.telegramService = telegramService;
        this.keyboardsBuilder = keyboardsBuilder;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {


        ReplyKeyboard replyKeyboard = keyboardsBuilder.startMenu();
        telegramService.sendMessage(user.getChatId(), "Thanks for feedback✅", replyKeyboard);

        String feedback = user.getUpdate().getMessage().getText();

        UserSession userSession = user.getUserSession();
        userSession.setFeedback(feedback);
        userSession.setState(State.START_MESSAGE);
        userSessionService.saveSession(userSession.getChatId(), userSession);


    }


    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate())
                && State.WAITING_FOR_FEEDBACK.equals(user.getUserSession().getState());

    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
