package com.company.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DecryptionMethods {

    public static void decryptAES(String inputFile, String outputFile, SecretKey key,
                                    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, IOException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[64];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }

        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }

        inputStream.close();
        outputStream.close();
    }

    public static void decrypt3DES(String inputFile, String outputFile, SecretKey key,
                                     IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException,
            InvalidAlgorithmParameterException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[64];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }

        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }

        inputStream.close();
        outputStream.close();
    }

    public static void decryptBlowfish(String inputFile, String outputFile, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[64];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }

        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }

        inputStream.close();
        outputStream.close();
    }

}
