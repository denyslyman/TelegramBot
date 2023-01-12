package io.telegrambot.config;

import io.telegrambot.keyboards.KeyboardsBuilder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private String start = "/start";

    final KeyboardsBuilder keyboardsBuilder;

    final BotConfig config;

    public TelegramBot(KeyboardsBuilder keyboardsBuilder, BotConfig config) {
        this.keyboardsBuilder = keyboardsBuilder;
        this.config = config;
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();
            String messageText = update.getMessage().getText();

            Long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                startMessage(chatId, update.getMessage().getChat().getFirstName());
            } else {
                wrongMessageText(chatId, "Sorry, I'm just a bot \uD83E\uDD16 and sometimes" +
                        "I don't understand what you write to me \uD83D\uDE1E\n" +
                        "\n" +
                        "To display the keyboard with answer options, please press the button \uD83D\uDC47");
            }
        }

    }

    private void startMessage(Long chatId, String name) {

        SendMessage sendMessage = new SendMessage();
        String startAnswer = "Hi, " + name + ", nice to meet you";
        sendMessage.setText(startAnswer);
        sendMessage.setChatId(String.valueOf(chatId));
        keyboardsBuilder.startMenuBuilder(sendMessage);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }



    }
    private void wrongMessageText(Long chatId,String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
