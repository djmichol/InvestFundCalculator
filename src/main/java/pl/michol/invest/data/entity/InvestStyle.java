package pl.michol.invest.data.entity;

import javax.persistence.*;

@Entity
public class InvestStyle {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private Long polishFundPercent;
    private Long foreignFundPercent;
    private Long cashFundPercent;

    public InvestStyle() {
    }

    public InvestStyle(String name, Long polishFundPercent, Long foreignFundPercent, Long cashFundPercent) {
        this.name = name;
        this.polishFundPercent = polishFundPercent;
        this.foreignFundPercent = foreignFundPercent;
        this.cashFundPercent = cashFundPercent;
    }

    public InvestStyle(Long id, String name, Long polishFundPercent, Long foreignFundPercent, Long cashFundPercent) {
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
