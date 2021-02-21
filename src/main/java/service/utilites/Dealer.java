package service.utilites;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dealer implements DealerInterface{
    public  String dealCards(){
        List<Integer> list = IntStream.range(0, 52).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return listToString(list, " ");
    }

    private String listToString(List<Integer> list, String delimiter){
        return list.stream().map(e->Integer.toString(e)).reduce("", (result, n)->result+(n+delimiter));
    }
}
