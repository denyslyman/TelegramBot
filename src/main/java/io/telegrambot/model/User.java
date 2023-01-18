package io.telegrambot.model;

import lombok.Builder;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.Update;
@Data
@Builder
public class User {

   private Long chatId;
    private UserSession userSession;
    private Update update;


}
