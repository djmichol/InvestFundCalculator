package pl.michol.invest.data;

import java.util.List;

public class InvestResponseModel {

    private List<SingleInvestRow> investRows;
    private Long notAllocatedCash;

    public InvestResponseModel() {
    }

    public InvestResponseModel(List<SingleInvestRow> investRows, Long notAllocatedCash) {
        this.investRows = investRows;
        this.notAllocatedCash = notAllocatedCash;
    }

    public List<SingleInvestRow> getInvestRows() {
        return investRows;
    }

    public void setInvestRows(List<SingleInvestRow> investRows) {
        this.investRows = investRows;
    }

    public Long getNotAllocatedCash() {
        return notAllocatedCash;
    }

    public void setNotAllocatedCash(Long notAllocatedCash) {
        this.notAllocatedCash = notAllocatedCash;
    }
}
