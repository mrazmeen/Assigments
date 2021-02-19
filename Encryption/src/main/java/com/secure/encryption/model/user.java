package com.secure.encryption.model;

import com.sun.net.httpserver.Authenticator;
import lombok.Data;

@Data
public class user {
    private String encryptedData;
    private String decryptedData;
    private String originalData;

    public user(String encryptedData, String decryptedData, String originalData) {
        this.encryptedData = encryptedData;
        this.decryptedData = decryptedData;
        this.originalData = originalData;
    }
}
