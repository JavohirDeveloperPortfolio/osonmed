package org.example.service;

import org.example.modul.User;

public interface UserService {
    User create(User user);
    User getUser(long chatId);

    User update(long chatId, User user);
}
