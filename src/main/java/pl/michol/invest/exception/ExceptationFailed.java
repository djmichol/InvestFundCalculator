package pl.michol.invest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class ExceptationFailed extends RuntimeException {

    public ExceptationFailed(String message) {
        super(message);
    }
}