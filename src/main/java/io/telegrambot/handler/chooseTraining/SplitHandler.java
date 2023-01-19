package io.telegrambot.handler.chooseTraining;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.inlinekeyboards.InlineKeyboardBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class SplitHandler extends UserRequestHandler {
    private static String SPLIT = "Split\uD83D\uDD00";

    private final TelegramService telegramService;
    private final InlineKeyboardBuilder inlineKeyboardBuilder;
    private final UserSessionService userSessionService;

    public SplitHandler(TelegramService telegramService,
                        InlineKeyboardBuilder inlineKeyboardBuilder, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.inlineKeyboardBuilder = inlineKeyboardBuilder;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = inlineKeyboardBuilder.splitMenu();
        telegramService.sendMessage(user.getChatId(), "Choose your split⬇️", replyKeyboard);
    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(),SPLIT);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
