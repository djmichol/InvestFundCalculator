package pl.michol.invest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.michol.invest.data.*;
import pl.michol.invest.data.entity.Fund;
import pl.michol.invest.data.entity.InvestStyle;
import pl.michol.invest.data.http.InvestRequestModel;
import pl.michol.invest.data.http.InvestResponseModel;
import pl.michol.invest.repository.InvestStyleRepository;
import pl.michol.invest.repository.FundRepository;
import pl.michol.invest.validator.InvestValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvestHandler implements Handler<InvestRequestModel, InvestResponseModel> {

    private final FundRepository fundRepository;
    private final InvestStyleRepository investStyleRepository;
    private final InvestValidator investValidator;

    @Autowired
    public InvestHandler(FundRepository fundRepository, InvestStyleRepository investStyleRepository, InvestValidator investValidator) {
        this.fundRepository = fundRepository;
        this.investStyleRepository = investStyleRepository;
        this.investValidator = investValidator;
    }

    @Override
    public InvestResponseModel handle(InvestRequestModel investRequestModel) {
        List<Fund> selectedFunds = investRequestModel.getFundIds().stream()
                .map(fundRepository::findOne)
                .collect(Collectors.toList());
        investValidator.validateSelectedFunds(selectedFunds);
        InvestStyle investStyle = investStyleRepository.findByName(investRequestModel.getInvestStyle());
        investValidator.validateInvestStyle(investStyle);
        Long polishFundCashAmount = (investRequestModel.getCashAmount() * investStyle.getPolishFundPercent()) / 100;
        Long foreignFundCashAmount = (investRequestModel.getCashAmount() * investStyle.getForeignFundPercent()) / 100;
        Long cashFundCashAmount = (investRequestModel.getCashAmount() * investStyle.getCashFundPercent()) / 100;
        Long notAllocatedCashAmount = investRequestModel.getCashAmount() - polishFundCashAmount - foreignFundCashAmount - cashFundCashAmount;
        List<SingleInvestRow> polishFunds = getFunds(investRequestModel.getCashAmount() - notAllocatedCashAmount, polishFundCashAmount, selectedFunds, Fund.FundKind.POLISH);
        List<SingleInvestRow> foreignFunds = getFunds(investRequestModel.getCashAmount() - notAllocatedCashAmount, foreignFundCashAmount, selectedFunds, Fund.FundKind.FOREIGN);
        List<SingleInvestRow> cashFunds = getFunds(investRequestModel.getCashAmount() - notAllocatedCashAmount, cashFundCashAmount, selectedFunds, Fund.FundKind.CASH);
        polishFunds.addAll(foreignFunds);
        polishFunds.addAll(cashFunds);
        return new InvestResponseModel(polishFunds, notAllocatedCashAmount);
    }

    private List<SingleInvestRow> getFunds(Long allCashAmountWithoutNotAllocated, Long cashFundCashAmount, List<Fund> selectedFunds, Fund.FundKind fundKind) {
        List<Fund> funds = selectedFunds.stream().filter(e -> e.getKind().equals(fundKind)).collect(Collectors.toList());
        investValidator.validateFundsOfKind(funds, fundKind.name());
        List<SingleInvestRow> singleInvestRows = new ArrayList<>();
        Long singleFundCashAmount = cashFundCashAmount / funds.size();
        Long validCashAmount = cashFundCashAmount - (singleFundCashAmount * funds.size());
        for (int i = 0; i < funds.size(); i++) {
            SingleInvestRow singleInvestRow = new SingleInvestRow();
            if (i == 0) {
                singleInvestRow.setFundCashAmount(singleFundCashAmount + validCashAmount);
            } else {
                singleInvestRow.setFundCashAmount(singleFundCashAmount);
            }
            Double singleFundPercentAmount = (singleInvestRow.getFundCashAmount().doubleValue() / allCashAmountWithoutNotAllocated.doubleValue()) * 100;
            singleInvestRow.setFoundCashPercent(singleFundPercentAmount);
            singleInvestRow.setFundKind(fundKind);
            singleInvestRow.setFundName(funds.get(i).getName());
            singleInvestRows.add(singleInvestRow);
        }
        return singleInvestRows;
    }
}
