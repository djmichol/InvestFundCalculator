package pl.michol.invest.validator;

import org.springframework.stereotype.Component;
import pl.michol.invest.data.Fund;
import pl.michol.invest.data.InvestStyle;
import pl.michol.invest.exception.ExceptationFailed;

import java.util.List;

@Component
public class InvestValidator {

    public void validateSelectedFunds(List<Fund> selectedFunds) {
        if (selectedFunds == null || selectedFunds.isEmpty()) {
            throw new ExceptationFailed("Empty selected funds");
        }
    }

    public void validateInvestStyle(InvestStyle investStyle) {
        if (investStyle == null) {
            throw new ExceptationFailed("Invest style not found");
        }
    }

    public void validateFundsOfKind(List<Fund> funds, String kindName){
        if (funds == null || funds.isEmpty()) {
            throw new ExceptationFailed("Empty funds of kind: " + kindName);
        }
    }

}
