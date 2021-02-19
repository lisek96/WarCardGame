package repository;

import repository.user.SQL_Server_UserDAO;
import repository.user.UserDAO;
import service.utilites.MD5PasswordEncoder;
import service.utilites.PasswordEncoder;

import javax.ejb.Local;
import javax.swing.text.DateFormatter;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        LocalDate localDate = LocalDate.now().plusDays(7);
        System.out.println(localDate);
    }
}
