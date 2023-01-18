package io.telegrambot.keyboards.inlinekeyboards;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class InlineKeyboardBuilder {
    public InlineKeyboardMarkup chatButtons(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> row = new ArrayList<>();
        List<InlineKeyboardButton> buttons = new ArrayList<>();
        InlineKeyboardButton keyboardButton1 = new InlineKeyboardButton();
        keyboardButton1.setText("Chat of participants\uD83D\uDCAC");
        keyboardButton1.setUrl("https://t.me/chat_trainingapp");

        buttons.add(keyboardButton1);
        row.add(buttons);

        inlineKeyboardMarkup.setKeyboard(row);

        return inlineKeyboardMarkup;
    }

}
