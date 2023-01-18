package io.telegrambot.handler.chooseTraining;

import io.telegrambot.enums.State;
import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.inlinekeyboards.InlineKeyboardBuilder;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class PartOfBodyHandler extends UserRequestHandler {
    private static String PART_OF_BODY = "Part of body\uD83D\uDCAA";

    private final InlineKeyboardBuilder inlineKeyboardBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public PartOfBodyHandler(InlineKeyboardBuilder inlineKeyboardBuilder, TelegramService telegramService,
                             UserSessionService userSessionService) {
        this.inlineKeyboardBuilder = inlineKeyboardBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }


    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = inlineKeyboardBuilder.partsOfBodyMenu();
        telegramService.sendMessage(user.getChatId(),"Choose your body part⬇️",
                replyKeyboard);
    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(),PART_OF_BODY);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
