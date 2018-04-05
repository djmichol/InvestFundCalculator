package pl.michol.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michol.invest.converter.InvestStyleToInvestStyleHttpModelConverter;
import pl.michol.invest.data.http.InvestStyleHttpModel;
import pl.michol.invest.repository.InvestStyleRepository;
import pl.michol.invest.utils.ListUtils;

@RestController
@RequestMapping("/investStyle")
public class InvestStyleController {

    private final InvestStyleRepository investStyleRepository;
    private final InvestStyleToInvestStyleHttpModelConverter investStyleToInvestStyleHttpModelConverter;

    @Autowired
    public InvestStyleController(InvestStyleRepository investStyleRepository, InvestStyleToInvestStyleHttpModelConverter investStyleToInvestStyleHttpModelConverter) {
        this.investStyleRepository = investStyleRepository;
        this.investStyleToInvestStyleHttpModelConverter = investStyleToInvestStyleHttpModelConverter;
    }

    @GetMapping
    public ResponseEntity<Iterable<InvestStyleHttpModel>> getAllFund() {
        return new ResponseEntity<>(investStyleToInvestStyleHttpModelConverter.convert(ListUtils.convertToList(investStyleRepository.findAll())), HttpStatus.OK);
    }
}
