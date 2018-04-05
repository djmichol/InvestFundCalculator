package pl.michol.invest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michol.invest.data.entity.Fund;
import pl.michol.invest.data.entity.InvestStyle;
import pl.michol.invest.exception.ExceptationFailed;
import pl.michol.invest.validator.InvestValidator;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTests {

    @Autowired
    private InvestValidator investValidator;

    @Test(expected = ExceptationFailed.class)
    public void validateSelectedFundsTestEmptyListExceptedException(){
        investValidator.validateSelectedFunds(Collections.EMPTY_LIST);
    }

    @Test(expected = ExceptationFailed.class)
    public void validateSelectedFundsTestNullListExceptedException(){
        investValidator.validateSelectedFunds(null);
    }

    @Test
    public void validateSelectedFundsTestList(){
        investValidator.validateSelectedFunds(Arrays.asList(new Fund()));
    }

    @Test(expected = ExceptationFailed.class)
    public void validateSelectedFundsOfKindTestEmptyListExceptedException(){
        investValidator.validateFundsOfKind(Collections.EMPTY_LIST, Fund.FundKind.FOREIGN.name());
    }

    @Test(expected = ExceptationFailed.class)
    public void validateSelectedFundsTestOfKindNullListExceptedException(){
        investValidator.validateFundsOfKind(null, Fund.FundKind.FOREIGN.name());
    }

    @Test
    public void validateSelectedFundsOfKindTestList(){
        investValidator.validateFundsOfKind(Arrays.asList(new Fund()), Fund.FundKind.FOREIGN.name());
    }

    @Test(expected = ExceptationFailed.class)
    public void validateNullInvestStyleExceptedException(){
        investValidator.validateInvestStyle(null);
    }

    @Test
    public void validateInvestStyle(){
        investValidator.validateInvestStyle(new InvestStyle());
    }
}
