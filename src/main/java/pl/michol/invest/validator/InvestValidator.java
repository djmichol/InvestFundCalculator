package pl.michol.invest.validator;

import org.springframework.stereotype.Component;
import pl.michol.invest.data.Fund;
import pl.michol.invest.data.InvestRequestModel;
import pl.michol.invest.data.InvestStyle;
import pl.michol.invest.exception.ExceptationFailed;
import pl.michol.invest.repository.FundRepository;
import pl.michol.invest.repository.InvestStyleRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public void validateFundsOfKind(List<Fund> selectedFunds, Fund.FundKind kind) {
        validateSelectedFunds(selectedFunds);
        List<Fund> funds = selectedFunds.stream().filter(e -> kind.equals(e.getKind())).collect(Collectors.toList());
        if (funds == null || funds.isEmpty()) {
            throw new ExceptationFailed("Empty funds of kind: " + kind.name());
        }
    }

    public void validateRequest(InvestRequestModel investRequestModel, FundRepository fundRepository, InvestStyleRepository investStyleRepository) {
        List<Fund> selectedFunds = investRequestModel.getFundIds().stream().map(fundRepository::findOne).filter(fund -> fund != null).collect(Collectors.toList());
        validateSelectedFunds(selectedFunds);
        InvestStyle investStyle = investStyleRepository.findByName(investRequestModel.getInvestStyle());
        validateInvestStyle(investStyle);
        validateFundsOfKind(selectedFunds, Fund.FundKind.CASH);
        validateFundsOfKind(selectedFunds, Fund.FundKind.POLISH);
        validateFundsOfKind(selectedFunds, Fund.FundKind.FOREIGN);
    }
}
