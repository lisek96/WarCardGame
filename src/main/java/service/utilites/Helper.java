package service.utilites;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<List<String>> getAllRowsFromResultSetIntoStringList(ResultSet resultSet, int numberOfColumns) throws SQLException {
        List<List<String>> list = new ArrayList<>();
        while(resultSet.next()){
            for(int i=0; i<numberOfColumns; i++) {
                List<String> row = new ArrayList<>();
                list.add(row);
            }
        }
        return list;
    }
}
