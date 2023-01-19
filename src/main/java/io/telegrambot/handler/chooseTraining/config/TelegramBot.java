package io.telegrambot.handler.chooseTraining.config;


import io.telegrambot.Dispatcher;
import io.telegrambot.model.User;
import io.telegrambot.model.UserSession;
import io.telegrambot.service.UserSessionService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("telegram.properties")
public class TelegramBot extends TelegramLongPollingBot {

    private final Dispatcher dispatcher;
    private final UserSessionService userSessionService;
    private final BotConfig config;

    public TelegramBot(Dispatcher dispatcher, UserSessionService userSessionService, BotConfig config) {
        this.dispatcher = dispatcher;
        this.userSessionService = userSessionService;
        this.config = config;

    }

    @Override
    public String getBotUsername() {
        return config.botName;
    }

    @Override
    public String getBotToken() {
        return config.botToken;
    }


    //----------------------------------------//

    @Override
        public void onUpdateReceived(Update update) {
          if (update.hasMessage() && update.getMessage().hasText()) {
              String textFromUser = update.getMessage().getText();
              String userName = update.getMessage().getFrom().getFirstName();
              Long chatId = update.getMessage().getChatId();
              UserSession userSession = userSessionService.getSession(chatId);

                User user = User
                        .builder()
                        .update(update)
                        .chatId(chatId)
                        .userSession(userSession)
                        .build();

                boolean dispatched = dispatcher.dispatch(user);
          }
    }

        }




