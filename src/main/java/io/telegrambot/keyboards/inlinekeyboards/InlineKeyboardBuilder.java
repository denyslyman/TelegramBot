package io.telegrambot.keyboards.inlinekeyboards;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class InlineKeyboardBuilder {
    public InlineKeyboardMarkup chatButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> row = new ArrayList<>();
        List<InlineKeyboardButton> buttons = new ArrayList<>();
        InlineKeyboardButton chat = new InlineKeyboardButton();
        chat.setText("Chat of participants\uD83D\uDCAC");
        chat.setUrl("https://t.me/chat_trainingapp");

        buttons.add(chat);
        row.add(buttons);

        inlineKeyboardMarkup.setKeyboard(row);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup partsOfBodyMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton chest = new InlineKeyboardButton();
        chest.setText("Chest");
        chest.setUrl("https://drive.google.com/drive/folders/13kREJjFiLElEivsfsZZByxIv5J4bHsMw?usp=sharing");
        row1.add(chest);
        InlineKeyboardButton biceps = new InlineKeyboardButton();
        biceps.setText("Biceps");
        biceps.setUrl("https://drive.google.com/drive/folders/1oyzWZRDrvMvK7BJujxqYf3gdL0ZG9L2O?usp=sharing");
        row1.add(biceps);
        rowList.add(row1);


        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Back");
        back.setUrl("https://drive.google.com/drive/folders/1_hFeJIiYfa12WXhRQVQbUcYk5bLHhu6X?usp=sharing");
        row2.add(back);

        InlineKeyboardButton triceps = new InlineKeyboardButton();
        triceps.setText("Triceps");
        triceps.setUrl("https://drive.google.com/drive/folders/1BTrXzJx4dKiy-y6s4Ovem8ffACoj6BYy?usp=sharing");
        row2.add(triceps);
        rowList.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton legs = new InlineKeyboardButton();
        legs.setText("Legs");
        legs.setUrl("https://drive.google.com/drive/folders/1guH-q6Jf2bVPiuayHH_D_J5E8txkEVcS?usp=sharing");
        row3.add(legs);

        InlineKeyboardButton abs = new InlineKeyboardButton();
        abs.setText("Abs");
        abs.setUrl("https://drive.google.com/drive/folders/1stdeD6OtSUp7LY1I1D7_Z9rawlfJoSTf?usp=sharing");
        row3.add(abs);
        rowList.add(row3);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup cardioMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton cardio = new InlineKeyboardButton();
        cardio.setText("Cardio");
        cardio.setUrl("https://drive.google.com/drive/folders/1v2XgxHSYsR3WYsdCQIaKoJ1Xq-2KXlgX?usp=sharing");
        row1.add(cardio);
        rowList.add(row1);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }


}


