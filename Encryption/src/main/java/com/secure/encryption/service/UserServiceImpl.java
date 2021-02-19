package com.secure.encryption.service;


import com.secure.encryption.model.EncryptData;
import com.secure.encryption.model.user;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public user userLogin(String username, String Password) {

        String secretKey = "LOL123";
        String originalData =Password;

        String encryptedString = EncryptData.encrypt(Password, secretKey);
        String decryptedString = EncryptData.decrypt(encryptedString, secretKey);


        return new user(encryptedString,decryptedString,originalData) ;
    }
}
