package pl.michol.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michol.invest.converter.FundToFundHttpConverter;
import pl.michol.invest.converter.FuntHttpModelToFundConverter;
import pl.michol.invest.data.entity.Fund;
import pl.michol.invest.data.http.FundHttpModel;
import pl.michol.invest.repository.FundRepository;
import pl.michol.invest.utils.ListUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/fund")
public class FundController {

    private final FundRepository fundRepository;
    private final FundToFundHttpConverter fundToFundHttpConverter;
    private final FuntHttpModelToFundConverter funtHttpModelToFundConverter;

    @Autowired
    public FundController(FundRepository fundRepository, FundToFundHttpConverter fundToFundHttpConverter, FuntHttpModelToFundConverter funtHttpModelToFundConverter) {
        this.fundRepository = fundRepository;
        this.fundToFundHttpConverter = fundToFundHttpConverter;
        this.funtHttpModelToFundConverter = funtHttpModelToFundConverter;
    }

    @PostMapping
    public ResponseEntity insertFund(@RequestBody @Valid FundHttpModel fundFromRequest) {
        Fund fund = fundRepository.save(funtHttpModelToFundConverter.convert(fundFromRequest));
        if (fund.getID() != null) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<FundHttpModel>> getAllFund() {
        return new ResponseEntity<>(fundToFundHttpConverter.convert(ListUtils.convertToList(fundRepository.findAll())), HttpStatus.OK);
    }
}
