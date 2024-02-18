package org.example.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.modul.User;
import org.example.service.FileService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private  List<User> users = new ArrayList<>();
//    private final String fileName = "users.txt";
//    private FileServiceImpl fileService = new FileServiceImpl();

    @Override
    public User create(User user) {
        if (getUser(user.getChatId()) == null) {
            users.add(user);
        }
        return user;
    }

    @Override
    public User getUser(long chatId) {
        for (User user : users) {
            if (chatId == user.getChatId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public User update(long chatId, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (user.getChatId() == chatId){
                users.get(i).setState(user.getState());
                users.get(i).setPhoneNumber(user.getPhoneNumber());
                users.get(i).setLang(user.getLang());
                users.get(i).setRegion(user.getRegion());
                return users.get(i);
            }
        }
        return null;//agar null qaytarsa update bo'lmagan
    }
}
