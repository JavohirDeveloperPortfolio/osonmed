package org.example;

import org.example.modul.BotState;
import org.example.modul.Language;
import org.example.modul.User;
import org.example.service.impl.ButtonServiceImpl;
import org.example.service.impl.UserServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    private UserServiceImpl userService = new UserServiceImpl();
    private ButtonServiceImpl buttonService = new ButtonServiceImpl();
    public MyBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (text.equals("/start")){
                User user = new User();
                user.setChatId(update.getMessage().getChatId());
                user.setState(BotState.LANG);
                userService.create(user);

                SendMessage message = new SendMessage();
                message.setText("Tilni tanlang");
                message.setChatId(chatId);
                message.setReplyMarkup(buttonService.menuLanguageButtun());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else {
                User user = userService.getUser(chatId);
                if (user.getLang() == Language.uz) {
                    switch (user.getState()){
                        case MAIN -> {
                            if (text.equals("Shifoxonalar\uD83C\uDFE5")){
                                user.setState(BotState.CLINIC);
                                SendMessage message = new SendMessage();
                                message.setText("Quyidagilardan birinini tanlang");
                                message.setChatId(chatId);
                                message.setReplyMarkup(buttonService.regionMenuUz());

                                try {
                                    execute(message);
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (text.equals("Savol yuborish ❓")){
                                user.setState(BotState.QUESTION);
                            } else if (text.equals("Sozlamalar⚙️\uFE0F")) {
                                user.setState(BotState.SETTINGS);
                            }
                            userService.update(chatId, user);
                        }
                    }
                } else if (user.getLang() == Language.ru) {

                }
            }
        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            SendMessage message = new SendMessage();

            if (data.equals("uz")){
                User user = userService.getUser(chatId);
                user.setState(BotState.MAIN);
                user.setLang(Language.uz);
                userService.update(chatId, user);

                message.setText("Asosiy sahifa");
                message.setChatId(chatId);
                message.setReplyMarkup(buttonService.mainMenuUz());
            } else if (data.equals("ru")) {
                User user = userService.getUser(chatId);
                user.setState(BotState.MAIN);
                user.setLang(Language.ru);
                userService.update(chatId, user);

                message.setText("Glavniy menu");
                message.setChatId(chatId);
                message.setReplyMarkup(buttonService.mainMenuRu());
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Oson_med_BOT";
    }
}
