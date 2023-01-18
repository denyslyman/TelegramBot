package io.telegrambot.handler.chooseTraining;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.inlinekeyboards.InlineKeyboardBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class CardioHandler extends UserRequestHandler {
    private static String CARDIO = "Cardio\uD83C\uDFC3";

    private final InlineKeyboardBuilder inlineKeyboardBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public CardioHandler(InlineKeyboardBuilder inlineKeyboardBuilder,
                         TelegramService telegramService, UserSessionService userSessionService) {
        this.inlineKeyboardBuilder = inlineKeyboardBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = inlineKeyboardBuilder.cardioMenu();
        telegramService.sendMessage(user.getChatId(), "Cardio", replyKeyboard);
    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(),CARDIO);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
