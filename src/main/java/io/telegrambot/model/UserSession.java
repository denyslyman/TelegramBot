package io.telegrambot.model;

import io.telegrambot.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "telegrambot")
public class UserSession {

    @Id
    Long id;
    @Column(name = "feedback")
    private String feedback;

    @Column(name = "chat_id")
    private Long chatId;

    private State state;

    public UserSession() {

    }
}
