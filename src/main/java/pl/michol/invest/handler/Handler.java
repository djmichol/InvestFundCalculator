package pl.michol.invest.handler;

@FunctionalInterface
public interface Handler<IN, OUT> {

    OUT handle(IN in);

}
