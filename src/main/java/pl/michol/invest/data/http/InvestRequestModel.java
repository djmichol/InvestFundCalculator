package pl.michol.invest.data.http;

import org.hibernate.validator.constraints.NotEmpty;
import pl.michol.invest.data.entity.InvestStyle;

import javax.validation.constraints.NotNull;
import java.util.List;

public class InvestRequestModel {

    @NotNull
    private Long cashAmount;
    @NotEmpty
    private List<Long> fundIds;
    @NotNull
    private String investStyle;

    public Long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getInvestStyle() {
        return investStyle;
    }

    public void setInvestStyle(String investStyle) {
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

    public InvestRequestModel(Long cashAmount, List<Long> fundIds, String investStyle) {
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
