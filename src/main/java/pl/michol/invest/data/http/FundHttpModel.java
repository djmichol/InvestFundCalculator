package pl.michol.invest.data.http;

import pl.michol.invest.data.entity.Fund;

import javax.validation.constraints.NotNull;

public class FundHttpModel {

    @NotNull
    private String name;
    @NotNull
    private Fund.FundKind kind;

    public FundHttpModel() {
    }

    public FundHttpModel(String name, Fund.FundKind kind) {
        this.name = name;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fund.FundKind getKind() {
        return kind;
    }

    public void setKind(Fund.FundKind kind) {
        this.kind = kind;
    }
}
