package repository.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<List<String>> getAllRowsFromResultSetIntoStringList(ResultSet resultSet, int numberOfColumns) throws SQLException {
        List<List<String>> list = new ArrayList<>();
        while(resultSet.next()){
            List<String> row = new ArrayList<>();
            for(int i=1; i<numberOfColumns+1; i++) {
                row.add(resultSet.getString(i));
            }
            list.add(row);
        }
        return list;
    }
}
