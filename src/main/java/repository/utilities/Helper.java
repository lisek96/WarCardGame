package repository.utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<Integer> getAllColumnsFromResultSetIntoIntList(ResultSet resultSet) throws SQLException {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(resultSet.next()){
            list.add(resultSet.getInt(i));
            i++;
        }
        return list;
    }

    public static List<String> getAllColumnsFromResultSetIntoStringList(ResultSet resultSet) throws SQLException {
        List<String> list = new ArrayList<>();
        int i=0;
        while(resultSet.next()){
            list.add(resultSet.getString(i));
            i++;
        }
        return list;
    }
}
