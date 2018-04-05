package pl.michol.invest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michol.invest.data.*;
import pl.michol.invest.data.entity.Fund;
import pl.michol.invest.data.entity.InvestStyle;
import pl.michol.invest.data.http.InvestRequestModel;
import pl.michol.invest.data.http.InvestResponseModel;
import pl.michol.invest.handler.InvestHandler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestApplicationTests {

    @Autowired
    private InvestHandler investHandler;


    @Test
    public void investHandlerTestNotAllocatedCashExceptedZero() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        Assert.assertEquals(0L, investResponseModel.getNotAllocatedCash().longValue());
    }

    @Test
    public void investHandlerTestNotAllocatedCashExceptedOne() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10001L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        Assert.assertEquals(1L, investResponseModel.getNotAllocatedCash().longValue());
    }

    @Test
    public void investHandlerTestFundSizeExceptedSix() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10001L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        Assert.assertEquals(6, investResponseModel.getInvestRows().size());
    }

    @Test
    public void investHandlerTestFundsAmountSumWithNotAllocated() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10001L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        Long amount = investResponseModel.getNotAllocatedCash() + investResponseModel.getInvestRows().stream()
                .map(SingleInvestRow::getFundCashAmount).reduce((s1, s2) -> s1 + s2).orElse(0L);
        Assert.assertEquals(10001L, amount.longValue());
    }

    @Test
    public void investHandlerTestFundsAmountSumWithAllCashAllocated() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        Long amount = investResponseModel.getInvestRows().stream()
                .map(SingleInvestRow::getFundCashAmount).reduce((s1, s2) -> s1 + s2).orElse(0L);
        Assert.assertEquals(10000L, amount.longValue());
    }

    @Test
    public void investHandlerTestFundsAmount() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        List<SingleInvestRow> sortedInvestRows = investResponseModel.getInvestRows().stream().sorted(Comparator.comparing(SingleInvestRow::getFundCashAmount)).collect(Collectors.toList());
        Assert.assertEquals(500L, sortedInvestRows.get(0).getFundCashAmount().longValue());
        Assert.assertEquals(1000L, sortedInvestRows.get(1).getFundCashAmount().longValue());
        Assert.assertEquals(1000L, sortedInvestRows.get(2).getFundCashAmount().longValue());
        Assert.assertEquals(2500L, sortedInvestRows.get(3).getFundCashAmount().longValue());
        Assert.assertEquals(2500L, sortedInvestRows.get(4).getFundCashAmount().longValue());
        Assert.assertEquals(2500L, sortedInvestRows.get(5).getFundCashAmount().longValue());
    }

    @Test
    public void investHandlerTestFundsPercent() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        List<SingleInvestRow> sortedInvestRows = investResponseModel.getInvestRows().stream().sorted(Comparator.comparing(SingleInvestRow::getFundCashAmount)).collect(Collectors.toList());
        Assert.assertEquals(5L, sortedInvestRows.get(0).getFoundCashPercent().longValue());
        Assert.assertEquals(10L, sortedInvestRows.get(1).getFoundCashPercent().longValue());
        Assert.assertEquals(10L, sortedInvestRows.get(2).getFoundCashPercent().longValue());
        Assert.assertEquals(25L, sortedInvestRows.get(3).getFoundCashPercent().longValue());
        Assert.assertEquals(25L, sortedInvestRows.get(4).getFoundCashPercent().longValue());
        Assert.assertEquals(25L, sortedInvestRows.get(5).getFoundCashPercent().longValue());
    }

    @Test
    public void investHandlerTestFundsKinds() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 4L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        List<SingleInvestRow> sortedInvestRows = investResponseModel.getInvestRows().stream().sorted(Comparator.comparing(SingleInvestRow::getFundCashAmount)).collect(Collectors.toList());
        Assert.assertEquals(Fund.FundKind.CASH, sortedInvestRows.get(0).getFundKind());
        Assert.assertEquals(Fund.FundKind.POLISH, sortedInvestRows.get(1).getFundKind());
        Assert.assertEquals(Fund.FundKind.POLISH, sortedInvestRows.get(2).getFundKind());
        Assert.assertEquals(Fund.FundKind.FOREIGN, sortedInvestRows.get(3).getFundKind());
        Assert.assertEquals(Fund.FundKind.FOREIGN, sortedInvestRows.get(4).getFundKind());
        Assert.assertEquals(Fund.FundKind.FOREIGN, sortedInvestRows.get(5).getFundKind());
    }

    @Test
    public void investHandlerTestFundsAmount2() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 3L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        List<SingleInvestRow> sortedInvestRows = investResponseModel.getInvestRows().stream().sorted(Comparator.comparing(SingleInvestRow::getFundCashAmount)).collect(Collectors.toList());
        Assert.assertEquals(500L, sortedInvestRows.get(0).getFundCashAmount().longValue());
        Assert.assertEquals(666L, sortedInvestRows.get(1).getFundCashAmount().longValue());
        Assert.assertEquals(666L, sortedInvestRows.get(2).getFundCashAmount().longValue());
        Assert.assertEquals(668L, sortedInvestRows.get(3).getFundCashAmount().longValue());
        Assert.assertEquals(3750L, sortedInvestRows.get(4).getFundCashAmount().longValue());
        Assert.assertEquals(3750L, sortedInvestRows.get(5).getFundCashAmount().longValue());
    }

    @Test
    public void investHandlerTestFundsPercent2() {
        InvestResponseModel investResponseModel = investHandler.handle(new InvestRequestModel(10000L, Arrays.asList(1L, 2L, 3L, 5L, 6L, 7L), InvestStyle.InvestStyleName.SAFE));
        List<SingleInvestRow> sortedInvestRows = investResponseModel.getInvestRows().stream().sorted(Comparator.comparing(SingleInvestRow::getFundCashAmount)).collect(Collectors.toList());
        Assert.assertEquals(5D, sortedInvestRows.get(0).getFoundCashPercent(),0.01);
        Assert.assertEquals(6.66D, sortedInvestRows.get(1).getFoundCashPercent(),0.01);
        Assert.assertEquals(6.66D, sortedInvestRows.get(2).getFoundCashPercent(),0.01);
        Assert.assertEquals(6.68D, sortedInvestRows.get(3).getFoundCashPercent(),0.01);
        Assert.assertEquals(37.5D, sortedInvestRows.get(4).getFoundCashPercent(),0.01);
        Assert.assertEquals(37.5D, sortedInvestRows.get(5).getFoundCashPercent(),0.01);
    }
}
