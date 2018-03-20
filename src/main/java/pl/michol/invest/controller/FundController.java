package pl.michol.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michol.invest.data.Fund;
import pl.michol.invest.repository.FundRepository;

@RestController
@RequestMapping("/fund")
public class FundController {

    private final FundRepository fundRepository;

    @Autowired
    public FundController(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @PostMapping
    public ResponseEntity insertFund(@RequestBody Fund fundFromRequest) {
        Fund fund = fundRepository.save(fundFromRequest);
        if (fund.getID() != null) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Fund>> getAllFund() {
        return new ResponseEntity<>(fundRepository.findAll(), HttpStatus.OK);
    }
}
