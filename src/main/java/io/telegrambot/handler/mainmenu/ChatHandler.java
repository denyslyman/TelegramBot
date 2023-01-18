package io.telegrambot.handler.mainmenu;

import io.telegrambot.handler.UserRequestHandler;
import io.telegrambot.keyboards.inlinekeyboards.InlineKeyboardBuilder;
import io.telegrambot.keyboards.replykeyboards.KeyboardsBuilder;
import io.telegrambot.model.User;
import io.telegrambot.service.TelegramService;
import io.telegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class ChatHandler extends UserRequestHandler {
    private static String CHAT = "Chat of participants\uD83D\uDCAC";
    private final InlineKeyboardBuilder inlineKeyboardBuilder;
    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public ChatHandler(InlineKeyboardBuilder inlineKeyboardBuilder, TelegramService telegramService, UserSessionService userSessionService) {
        this.inlineKeyboardBuilder = inlineKeyboardBuilder;
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public void enter(User user) {
        ReplyKeyboard replyKeyboard = inlineKeyboardBuilder.chatButtons();
        telegramService.sendMessage(user.getChatId(),CHAT, replyKeyboard);
    }

    @Override
    public boolean isApplicable(User user) {
        return isTextMessage(user.getUpdate(), CHAT);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
