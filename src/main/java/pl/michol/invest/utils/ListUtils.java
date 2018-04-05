package pl.michol.invest.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListUtils {

    public static List convertToList(Iterable iterable){
        return (List) StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

}
