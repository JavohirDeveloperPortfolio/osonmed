package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new MyBot("6947285331:AAEi4Z3wjghp2Cw0QkChVM5dFNvrLk8j1_0"));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}