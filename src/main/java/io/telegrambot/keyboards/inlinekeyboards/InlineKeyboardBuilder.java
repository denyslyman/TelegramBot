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
        chest.setUrl("https://t.me/chat_trainingapp");
        row1.add(chest);
        InlineKeyboardButton biceps = new InlineKeyboardButton();
        biceps.setText("Biceps");
        biceps.setUrl("https://t.me/chat_trainingapp");
        row1.add(biceps);
        rowList.add(row1);


        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Back");
        back.setUrl("https://t.me/chat_trainingapp");
        row2.add(back);

        InlineKeyboardButton triceps = new InlineKeyboardButton();
        triceps.setText("Triceps");
        triceps.setUrl("https://t.me/chat_trainingapp");
        row2.add(triceps);
        rowList.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton legs = new InlineKeyboardButton();
        legs.setText("Legs");
        legs.setUrl("https://youtu.be/G5nxGTFBauM");
        row3.add(legs);

        InlineKeyboardButton abs = new InlineKeyboardButton();
        abs.setText("Abs");
        abs.setUrl("https://t.me/chat_trainingapp");
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
        cardio.setUrl("https://t.me/chat_trainingapp");
        row1.add(cardio);
        rowList.add(row1);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup splitMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton chestBiceps = new InlineKeyboardButton();
        chestBiceps.setText("Chest&Biceps");
        chestBiceps.setUrl("https://t.me/chat_trainingapp");
        row1.add(chestBiceps);
        InlineKeyboardButton backTriceps = new InlineKeyboardButton();
        backTriceps.setText("Back&Triceps");
        backTriceps.setUrl("https://t.me/chat_trainingapp");
        row1.add(backTriceps);
        rowList.add(row1);


        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton legsShoulders = new InlineKeyboardButton();
        legsShoulders.setText("Legs&Shoulders");
        legsShoulders.setUrl("https://t.me/chat_trainingapp");
        row2.add(legsShoulders);

        InlineKeyboardButton absGlutes = new InlineKeyboardButton();
        absGlutes.setText("Abs&Glutes");
        absGlutes.setUrl("https://t.me/chat_trainingapp");
        row2.add(absGlutes);
        rowList.add(row2);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }


}


