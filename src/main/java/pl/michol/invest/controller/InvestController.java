package pl.michol.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michol.invest.data.InvestRequestModel;
import pl.michol.invest.data.InvestResponseModel;
import pl.michol.invest.handler.InvestHandler;
import pl.michol.invest.repository.FundRepository;
import pl.michol.invest.repository.InvestStyleRepository;
import pl.michol.invest.validator.InvestValidator;

import javax.validation.Valid;

@RestController
@RequestMapping("/invest")
public class InvestController {

    private final InvestHandler investHandler;
    private final InvestValidator investValidator;
    private final FundRepository fundRepository;
    private final InvestStyleRepository investStyleRepository;

    @Autowired
    public InvestController(InvestHandler investHandler, InvestValidator investValidator, FundRepository fundRepository, InvestStyleRepository investStyleRepository) {
        this.investHandler = investHandler;
        this.investValidator = investValidator;
        this.fundRepository = fundRepository;
        this.investStyleRepository = investStyleRepository;
    }

    @PostMapping
    public ResponseEntity<InvestResponseModel> getInvest(@RequestBody @Valid InvestRequestModel investRequestModel) {
        investValidator.validateRequest(investRequestModel, fundRepository, investStyleRepository);
        return new ResponseEntity<>(investHandler.handle(investRequestModel), HttpStatus.OK);
    }

}
