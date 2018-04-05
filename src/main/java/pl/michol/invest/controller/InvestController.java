package pl.michol.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michol.invest.data.http.InvestResponseModel;
import pl.michol.invest.handler.InvestHandler;
import pl.michol.invest.data.http.InvestRequestModel;

import javax.validation.Valid;

@RestController
@RequestMapping("/invest")
public class InvestController {

    private final InvestHandler investHandler;

    @Autowired
    public InvestController(InvestHandler investHandler) {
        this.investHandler = investHandler;
    }

    @PostMapping
    public ResponseEntity<InvestResponseModel> getInvest(@RequestBody @Valid InvestRequestModel investRequestModel) {
        return new ResponseEntity<>(investHandler.handle(investRequestModel), HttpStatus.OK);
    }

}
