package pl.michol.invest.data.entity;

import javax.persistence.*;

@Entity
public class InvestStyle {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private InvestStyleName name;
    private Long polishFundPercent;
    private Long foreignFundPercent;
    private Long cashFundPercent;

    public enum InvestStyleName {
        SAFE("bezpieczny"),
        BALANCED("zrownowazony"),
        AGGRESSIVE("agresywny");

        private String value;

        InvestStyleName(String value) {
            this.value = value;
        }
    }

    public InvestStyle() {
    }

    public InvestStyle(InvestStyleName name, Long polishFundPercent, Long foreignFundPercent, Long cashFundPercent) {
        this.name = name;
        this.polishFundPercent = polishFundPercent;
        this.foreignFundPercent = foreignFundPercent;
        this.cashFundPercent = cashFundPercent;
    }

    public InvestStyle(Long id, InvestStyleName name, Long polishFundPercent, Long foreignFundPercent, Long cashFundPercent) {
        this.id = id;
        this.name = name;
        this.polishFundPercent = polishFundPercent;
        this.foreignFundPercent = foreignFundPercent;
        this.cashFundPercent = cashFundPercent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvestStyleName getName() {
        return name;
    }

    public void setName(InvestStyleName name) {
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
