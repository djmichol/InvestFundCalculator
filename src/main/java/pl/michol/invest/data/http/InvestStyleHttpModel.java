package pl.michol.invest.data.http;

import pl.michol.invest.data.entity.InvestStyle;

public class InvestStyleHttpModel {

    private String name;
    private Long polishFundPercent;
    private Long foreignFundPercent;
    private Long cashFundPercent;

    public InvestStyleHttpModel() {
    }

    public InvestStyleHttpModel(String name, Long polishFundPercent, Long foreignFundPercent, Long cashFundPercent) {
        this.name = name;
        this.polishFundPercent = polishFundPercent;
        this.foreignFundPercent = foreignFundPercent;
        this.cashFundPercent = cashFundPercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPolishFundPercent() {
        return polishFundPercent;
    }

    public void setPolishFundPercent(Long polishFundPercent) {
        this.polishFundPercent = polishFundPercent;
    }

    public Long getForeignFundPercent() {
        return foreignFundPercent;
    }

    public void setForeignFundPercent(Long foreignFundPercent) {
        this.foreignFundPercent = foreignFundPercent;
    }

    public Long getCashFundPercent() {
        return cashFundPercent;
    }

    public void setCashFundPercent(Long cashFundPercent) {
        this.cashFundPercent = cashFundPercent;
    }
}
