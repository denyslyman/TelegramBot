package io.telegrambot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramService {

    private final BotSender sender;


    public TelegramService(BotSender sender) {
        this.sender = sender;
    }

    private void execute(BotApiMethod botApiMethod) {
        try {
            sender.execute(botApiMethod);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(Long chatId, String text){
        sendMessage(chatId,text, null);
    }
    public void sendMessage(Long chatId, ReplyKeyboard replyKeyboard){
        SendMessage sendMessage = SendMessage
                .builder()
                .parseMode(ParseMode.MARKDOWN)
                .chatId(String.valueOf(chatId))
                .replyMarkup(replyKeyboard)
                .build();
        execute(sendMessage);
    }
    public void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard){
        SendMessage sendMessage = SendMessage
                .builder()
                .parseMode(ParseMode.MARKDOWN)
                .text(text)
                .chatId(String.valueOf(chatId))
                .replyMarkup(replyKeyboard)
                .build();
        execute(sendMessage);
    }
}

