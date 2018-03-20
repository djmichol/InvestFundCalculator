package pl.michol.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michol.invest.data.InvestStyle;
import pl.michol.invest.repository.InvestStyleRepository;

@RestController
@RequestMapping("/investStyle")
public class InvestStyleController {

    private final InvestStyleRepository investStyleRepository;

    @Autowired
    public InvestStyleController(InvestStyleRepository investStyleRepository) {
        this.investStyleRepository = investStyleRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<InvestStyle>> getAllFund() {
        return new ResponseEntity<>(investStyleRepository.findAll(), HttpStatus.OK);
    }
}
