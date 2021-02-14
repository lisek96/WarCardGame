package service.utilites;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;


public class MD5PasswordEncoder implements PasswordEncoder {
    @Override
    public byte[] provideSalt() {
        Random rd = new Random();
        byte[] salt = new byte[8];
        rd.nextBytes(salt);
        return salt;
    }

    @Override
    public String convertbyteToHexadecimal(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : arr) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public byte[] convertHexadecimalStringToBytes(String s) {
        byte[] result = new byte[s.length() / 2];
        int i = 0;
        while (s.length() != 0) {
            result[i] = (byte) Integer.parseInt(s.substring(0, 2), 16);
            i++;
            s = s.substring(2);
        }
        return result;
    }

    @Override
    public String[] provideEncryptedPasswordAndSalt(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] input = password.getBytes(StandardCharsets.UTF_8);
        messageDigest.update(input);
        if (salt == null) {
            byte[] newSalt = provideSalt();
            messageDigest.update(newSalt);
            salt = convertbyteToHexadecimal(newSalt);
        } else {
            byte[] oldSalt = convertHexadecimalStringToBytes(salt);
            messageDigest.update(oldSalt);
        }
        byte[] output = messageDigest.digest(input);
        System.out.println(Arrays.toString(output));
        String encryptedPassword = convertbyteToHexadecimal(output);
        return new String[]{encryptedPassword, salt};
    }


}
