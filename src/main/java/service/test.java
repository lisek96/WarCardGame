package service;

import model.user.Stats;
import service.user.UserService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        UserService userService = new UserService();
        List<Stats> listOfStats = new ArrayList<>();
        listOfStats.add(new Stats("zz", 22, 23, 24, 25, 26));
        listOfStats.add(new Stats("zz", 22, 23, 24, 25, 50));
        listOfStats.add(new Stats("zz", 22, 23, 24, 25, 55));
        listOfStats.add(new Stats("zz", 22, 23, 24, 25, 60));
        listOfStats.add(new Stats("zz", 22, 23, 24, 25, 100));
        List<Stats> listOfStatsSorted = userService.sortListOfStatsByStatsAttribute("Ranking", listOfStats);
        System.out.println(listOfStatsSorted);
    }
}
