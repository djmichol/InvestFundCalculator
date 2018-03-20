package pl.michol.invest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.michol.invest.data.Fund;
import pl.michol.invest.data.InvestStyle;

import javax.annotation.PostConstruct;

@Component
public class InitialData {

    private final FundRepository fundRepository;
    private final InvestStyleRepository investStyleRepository;

    @Autowired
    public InitialData(FundRepository fundRepository, InvestStyleRepository investStyleRepository) {
        this.fundRepository = fundRepository;
        this.investStyleRepository = investStyleRepository;
    }

    @PostConstruct
    public void insertInitialData() {
        insertInitialFunds();
        insertInitialInvestStyles();
    }

    private void insertInitialInvestStyles() {
        investStyleRepository.save(new InvestStyle(InvestStyle.InvestStyleName.SAFE, 20L, 75L, 5L));
        investStyleRepository.save(new InvestStyle(InvestStyle.InvestStyleName.BALANCED, 30L, 60L, 10L));
        investStyleRepository.save(new InvestStyle(InvestStyle.InvestStyleName.AGGRESSIVE, 40L, 20L, 40L));
    }

    private void insertInitialFunds() {
        fundRepository.save(new Fund("Fundusz Polski 1", Fund.FundKind.POLISH));
        fundRepository.save(new Fund("Fundusz Polski 2", Fund.FundKind.POLISH));
        fundRepository.save(new Fund("Fundusz Polski 3", Fund.FundKind.POLISH));
        fundRepository.save(new Fund("Fundusz Zagraniczny 1", Fund.FundKind.FOREIGN));
        fundRepository.save(new Fund("Fundusz Zagraniczny 2", Fund.FundKind.FOREIGN));
        fundRepository.save(new Fund("Fundusz Zagraniczny 3", Fund.FundKind.FOREIGN));
        fundRepository.save(new Fund("Fundusz Pieniężny 1", Fund.FundKind.CASH));
    }
}
