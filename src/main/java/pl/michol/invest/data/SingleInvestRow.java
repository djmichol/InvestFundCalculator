package pl.michol.invest.data;

public class SingleInvestRow {

    private Fund.FundKind fundKind;
    private String fundName;
    private Long fundCashAmount;
    private Double foundCashPercent;

    public Fund.FundKind getFundKind() {
        return fundKind;
    }

    public void setFundKind(Fund.FundKind fundKind) {
        this.fundKind = fundKind;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Long getFundCashAmount() {
        return fundCashAmount;
    }

    public void setFundCashAmount(Long fundCashAmount) {
        this.fundCashAmount = fundCashAmount;
    }

    public Double getFoundCashPercent() {
        return foundCashPercent;
    }

    public void setFoundCashPercent(Double foundCashPercent) {
        this.foundCashPercent = foundCashPercent;
    }
}
