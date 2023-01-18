package io.telegrambot.handler.mainmenu;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class InformationHandler extends UserRequestHandler {

    private static String INFO = "Information❗️";

    private final KeyboardsBuilder keyboardsBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public InformationHandler(KeyboardsBuilder keyboardsBuilder, TelegramService telegramService, UserSessionService userSessionService) {
        this.keyboardsBuilder = keyboardsBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = keyboardsBuilder.startMenu();
        telegramService.sendMessage(user.getChatId(), "OUR INFORMATION", replyKeyboard);
    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(), INFO);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
