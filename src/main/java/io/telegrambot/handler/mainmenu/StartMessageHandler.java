package io.telegrambot.handler.mainmenu;

import io.telegrambot.enums.State;
import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.model.UserSession;
import io.telegrambot.service.TelegramService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class StartMessageHandler extends UserRequestHandler {

    private static String commandStart = "/start";

    private final TelegramService telegramService;
    private final KeyboardsBuilder keyboardsBuilder;

    public StartMessageHandler(TelegramService telegramService, KeyboardsBuilder keyboardsBuilder) {
        this.telegramService = telegramService;
        this.keyboardsBuilder = keyboardsBuilder;
    }

    @Override
    public boolean isApplicable(User user) {
        return isCommand(user.getUpdate(), commandStart);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = keyboardsBuilder.startMenu();
        telegramService.sendMessage(user.getChatId(), "\uD83D\uDC4BHi, nice to meet you", replyKeyboard);

        UserSession userSession = user.getUserSession();
        userSession.setState(State.START_MESSAGE);
    }
}
