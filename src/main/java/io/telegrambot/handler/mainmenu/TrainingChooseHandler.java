package io.telegrambot.handler.mainmenu;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class TrainingChooseHandler extends UserRequestHandler {

    public static String TRAINING = "Training\uD83C\uDFCB️\u200D♂️";

    private final KeyboardsBuilder keyboardsBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public TrainingChooseHandler(KeyboardsBuilder keyboardsBuilder, TelegramService telegramService, UserSessionService userSessionService) {
        this.keyboardsBuilder = keyboardsBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }
    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(), TRAINING);

    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = keyboardsBuilder.chooseTrainingMenu();
        telegramService.sendMessage(user.getChatId(), "Choose your type\uD83D\uDC47", replyKeyboard);
    }




    @Override
    public boolean isGlobal() {
        return true;
    }
}
