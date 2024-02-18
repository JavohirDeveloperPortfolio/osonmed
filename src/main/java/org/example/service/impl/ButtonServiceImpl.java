package org.example.service.impl;

import org.example.modul.Region;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ButtonServiceImpl {
    private RegionServiceIml regionService = new RegionServiceIml();

    public InlineKeyboardMarkup menuLanguageButtun() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("\uD83D\uDC49O'zbek tili\uD83C\uDDFA\uD83C\uDDFF");
        button1.setCallbackData("uz");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("\uD83D\uDC49rus tili\uD83C\uDDF7\uD83C\uDDFA");
        button2.setCallbackData("ru");
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(button2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);

        markup.setKeyboard(rowList);

        return markup;
    }

    public ReplyKeyboardMarkup mainMenuUz() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Shifoxonalar\uD83C\uDFE5");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Savol yuborish ❓");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Sozlamalar⚙️\uFE0F");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;

    }

    public ReplyKeyboardMarkup mainMenuRu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Больницы \uD83C\uDFE5");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Задать вопрос ❓");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Настройки ⚙️\uFE0F");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button3);


        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup regionMenuUz() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Joylashuni yuborish"); // "Joylashuni yuborish"
        button1.setRequestLocation(true);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Butun shahar"); // "Butun shahar"

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);


        rowList.add(row1);
        rowList.add(row2);

        List<Region> regions = regionService.getAll();
        System.out.println(regions);
        if (regions.size() % 2 == 1) {
            for (int i = 0; i < regions.size() - 1; i += 2) {
                System.out.println(regions.get(i));
                KeyboardRow row = new KeyboardRow();

                KeyboardButton buttonOne = new KeyboardButton();

                buttonOne.setText(regions.get(i).getNameUz());

                KeyboardButton buttonTwo = new KeyboardButton();
                buttonTwo.setText(regions.get(i + 1).getNameUz());

                row.add(buttonOne);
                row.add(buttonTwo);

                rowList.add(row);
            }
            KeyboardRow row = new KeyboardRow();
            KeyboardButton buttonOne = new KeyboardButton();
            buttonOne.setText(regions.get(regions.size() - 1).getNameUz());
            row.add(buttonOne);
            rowList.add(row);
        } else {
            for (int i = 0; i < regions.size() - 2; i += 2) {
                KeyboardRow row = new KeyboardRow();

                KeyboardButton buttonOne = new KeyboardButton();
                System.out.println(regions.get(i).getNameUz());
                buttonOne.setText(regions.get(i).getNameUz());

                KeyboardButton buttonTwo = new KeyboardButton();
                buttonTwo.setText(regions.get(i + 1).getNameUz());

                row.add(buttonOne);
                row.add(buttonTwo);

                rowList.add(row);
            }
        }

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Ortga"); //  "Ortga"

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button4);

        rowList.add(row1);

        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        return markup;
    }

    public ReplyKeyboardMarkup regionMenuRu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("отправить свою геопозицию"); // "Joylashuni yuborish"
        button1.setRequestLocation(true);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Весь город"); // "Butun shahar"

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);


        rowList.add(row1);
        rowList.add(row2);

        List<Region> regions = regionService.getAll();
        if (regions.size() % 2 == 1) {
            for (int i = 0; i < regions.size() - 1; i += 2) {
                KeyboardRow row = new KeyboardRow();

                KeyboardButton buttonOne = new KeyboardButton();
                buttonOne.setText(regions.get(i).getNameRu());

                KeyboardButton buttonTwo = new KeyboardButton();
                buttonTwo.setText(regions.get(i + 1).getNameRu());

                row.add(buttonOne);
                row.add(buttonTwo);

                rowList.add(row);
            }
        } else {
            for (int i = 0; i < regions.size() - 2; i += 2) {
                KeyboardRow row = new KeyboardRow();

                KeyboardButton buttonOne = new KeyboardButton();
                buttonOne.setText(regions.get(i).getNameRu());

                KeyboardButton buttonTwo = new KeyboardButton();
                buttonTwo.setText(regions.get(i + 1).getNameRu());

                row.add(buttonOne);
                row.add(buttonTwo);

                rowList.add(row);
            }
        }

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Назад"); //  "Ortga"

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button4);

        rowList.add(row1);

        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        return markup;
    }
}
