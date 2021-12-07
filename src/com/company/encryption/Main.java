package com.company.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Main {

    public static SecretKey generateKey(int n, String algorithm) throws NoSuchAlgorithmException, NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public static IvParameterSpec generateIv(int size) {
        byte[] iv = new byte[size];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, IOException {
        IvParameterSpec iv = generateIv(8);
        SecretKey key = generateKey(112, "Blowfish");
        EncryptionMethods.encryptBlowfish("text_files\\file10.txt", "output.txt", key);
        DecryptionMethods.decryptBlowfish("output.txt", "decrypted.txt", key);
    }
}
