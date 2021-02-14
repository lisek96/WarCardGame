package repository;

import repository.user.SQL_Server_UserDAO;
import repository.user.UserDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class test {
    public static void main(String[] args) {
        UserDAO userDAO = new SQL_Server_UserDAO();
        Integer i = userDAO.getIDByLogin("xxxp");
        System.out.println(i);
    }
}
