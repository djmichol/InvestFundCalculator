package pl.michol.invest.data;

import javax.persistence.*;

@Entity
public class Fund {
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    @Enumerated(EnumType.STRING)
    private FundKind kind;

    public enum FundKind {
        POLISH("Polskie"),
        FOREIGN("Zagraniczne"),
        CASH("Pieniężne");

        private String value;

        FundKind(String value) {
            this.value = value;
        }
    }

    public Fund() {
    }

    public Fund(String name, FundKind kind) {
        this.name = name;
        this.kind = kind;
    }

    public Fund(Long ID, String name, FundKind kind) {
        this.ID = ID;
        this.name = name;
        this.kind = kind;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FundKind getKind() {
        return kind;
    }

    public void setKind(FundKind kind) {
        this.kind = kind;
    }
}
