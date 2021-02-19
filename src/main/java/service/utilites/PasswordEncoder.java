package service.utilites;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public interface PasswordEncoder extends Serializable {
    byte[] provideSalt();

    byte[] convertHexadecimalStringToBytes(String s);

    String convertbyteToHexadecimal(byte[] arr);

    String[] provideEncryptedPasswordAndSalt(String password, String salt) throws NoSuchAlgorithmException;

}
