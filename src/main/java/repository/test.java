package repository;

import repository.user.SQL_Server_UserDAO;
import repository.user.UserDAO;
import service.utilites.MD5PasswordEncoder;
import service.utilites.PasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MD5PasswordEncoder md5PasswordEncoder = new MD5PasswordEncoder();
        String[] xx = md5PasswordEncoder.provideEncryptedPasswordAndSalt("qweqwe", "aa0f1010bae66809");
        System.out.println(xx[0]);
    }
}
