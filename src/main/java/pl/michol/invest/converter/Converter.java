package pl.michol.invest.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<IN, OUT> {

    OUT convert(IN in);

    default List<OUT> convert(List<IN> in){
        return in.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
