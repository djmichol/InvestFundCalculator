package pl.michol.invest.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class InvestRequestModel {

    @NotNull
    private Long cashAmount;
    @NotEmpty
    private List<Long> fundIds;
    @NotNull
    private InvestStyle.InvestStyleName investStyle;

    public Long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }

    public InvestStyle.InvestStyleName getInvestStyle() {
        return investStyle;
    }

    public void setInvestStyle(InvestStyle.InvestStyleName investStyle) {
        this.investStyle = investStyle;
    }

    public List<Long> getFundIds() {
        return fundIds;
    }

    public void setFundIds(List<Long> fundIds) {
        this.fundIds = fundIds;
    }

    public InvestRequestModel() {
    }

    public InvestRequestModel(Long cashAmount, List<Long> fundIds, InvestStyle.InvestStyleName investStyle) {
        this.cashAmount = cashAmount;
        this.fundIds = fundIds;
        this.investStyle = investStyle;
    }

    @Override
    public String toString() {
        return "InvestRequestModel{" +
                "cashAmount=" + cashAmount +
                ", fundIds=" + fundIds +
                ", investStyle=" + investStyle +
                '}';
    }
}
