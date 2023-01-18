package io.telegrambot.handler.mainmenu;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class MainMenuHandler extends UserRequestHandler {
    private static String MAIN_MENU = "Main menu\uD83D\uDD19";
    private final KeyboardsBuilder keyboardsBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public MainMenuHandler(KeyboardsBuilder keyboardsBuilder, TelegramService telegramService, UserSessionService userSessionService) {
        this.keyboardsBuilder = keyboardsBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = keyboardsBuilder.startMenu();
        telegramService.sendMessage(user.getChatId(), " \uD83D\uDD19",replyKeyboard);


    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(),MAIN_MENU);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
