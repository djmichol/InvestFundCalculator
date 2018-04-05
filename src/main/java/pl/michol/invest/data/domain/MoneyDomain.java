package pl.michol.invest.data.domain;

import pl.michol.invest.data.entity.InvestStyle;

public class MoneyDomain {

    private Long polishFundCashAmount;
    private Long foreignFundCashAmount;
    private Long cashFundCashAmount;
    private Long notAllocatedCashAmount;
    private Long allCash;
    private Long allCashWithoutNotAllocated;
    private InvestStyle investStyle;

    public MoneyDomain(Long allCash, InvestStyle investStyle) {
        this.allCash = allCash;
        this.investStyle = investStyle;
        calculate();
    }

    public void calculate() {
        polishFundCashAmount = (allCash * investStyle.getPolishFundPercent()) / 100;
        foreignFundCashAmount = (allCash * investStyle.getForeignFundPercent()) / 100;
        cashFundCashAmount = (allCash * investStyle.getCashFundPercent()) / 100;
        notAllocatedCashAmount = allCash - polishFundCashAmount - foreignFundCashAmount - cashFundCashAmount;
        allCashWithoutNotAllocated = allCash - notAllocatedCashAmount;
    }

    public Long getPolishFundCashAmount() {
        return polishFundCashAmount;
    }

    public Long getForeignFundCashAmount() {
        return foreignFundCashAmount;
    }

    public Long getCashFundCashAmount() {
        return cashFundCashAmount;
    }

    public Long getNotAllocatedCashAmount() {
        return notAllocatedCashAmount;
    }

    public Long getAllCash() {
        return allCash;
    }

    public InvestStyle getInvestStyle() {
        return investStyle;
    }

    public Long getAllCashWithoutNotAllocated() {
        return allCashWithoutNotAllocated;
    }
}

