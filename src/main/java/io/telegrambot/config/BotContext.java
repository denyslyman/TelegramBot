package io.telegrambot.config;

import io.telegrambot.model.User;

public class BotContext {

    private TelegramBot bot;
    private User user;
    private String input;

    private BotContext(TelegramBot bot, User user, String input) {
        this.bot = bot;
        this.user = user;
        this.input = input;
    }
    public static BotContext of(TelegramBot bot, User user, String input){
        return new BotContext(bot, user, input);
    }

    public TelegramBot getBot() {
        return bot;
    }

    public User getUser() {
        return user;
    }

    public String getInput() {
        return input;
    }
}
