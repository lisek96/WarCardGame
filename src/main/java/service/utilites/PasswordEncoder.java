package service.utilites;

import java.security.NoSuchAlgorithmException;

public interface PasswordEncoder {
    byte[] provideSalt();

    byte[] convertHexadecimalStringToBytes(String s);

    String convertbyteToHexadecimal(byte[] arr);

    String[] provideEncryptedPasswordAndSalt(String password, String salt) throws NoSuchAlgorithmException;

}
