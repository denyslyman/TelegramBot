package io.telegrambot.keyboards.replykeyboards;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeyboardsBuilder {


    public ReplyKeyboardMarkup startMenu(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Training\uD83C\uDFCB️\u200D♂️");
        row.add("Feedback✍️");

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("Information❗️");
        row.add("Chat of participants\uD83D\uDCAC");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;


    }


    public ReplyKeyboardMarkup chooseTrainingMenu(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add("Part of body\uD83D\uDCAA");
        row.add("Split\uD83D\uDD00");

        keyboardRows.add(row);

        row = new KeyboardRow();

        row.add("Cardio\uD83C\uDFC3");
        row.add("Main menu\uD83D\uDD19");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;


    }

    public ReplyKeyboardMarkup splitMenu(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add("Chest&Biceps\uD83C\uDFCB️");
        row.add("Back&Triceps\uD83C\uDFCB️");

        keyboardRows.add(row);

        row = new KeyboardRow();

        row.add("Legs&Abs\uD83C\uDFCB️");
        row.add("Shoulders&Glutes\uD83C\uDFCB️");

        keyboardRows.add(row);

        row = new KeyboardRow();

        row.add("Main menu\uD83D\uDD19");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;

    }



}
