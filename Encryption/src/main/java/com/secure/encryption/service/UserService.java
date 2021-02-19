package com.secure.encryption.service;

import com.secure.encryption.model.user;

public interface UserService {

    user userLogin(String username, String Password);
}
