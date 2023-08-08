package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserHandler {
    @Autowired
    private UserRepository userRepo;


    public int checkEmailAndPassword(String email, String password) throws Exception {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty())
            return -1;
        else {
            String key = generateValidAESKey(email);
            String encryptedPassword = encryptPassword(password, key);
            if(user.get().getPassword().equals(encryptedPassword))
                return 0;
            else
                return -1;
        }
    }

    public String generateValidAESKey(String originalKey) throws Exception {
        byte[] keyBytes = originalKey.getBytes(StandardCharsets.UTF_8);

        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        keyBytes = sha256.digest(keyBytes);

        keyBytes = Arrays.copyOf(keyBytes, 16);

        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        return Base64.getEncoder().encodeToString(secretKeySpec.getEncoded());
    }

    public String encryptPassword(String password, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decryptPassword(String encryptedPassword, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}