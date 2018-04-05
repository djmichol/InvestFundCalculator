package pl.michol.invest.converter;

import org.springframework.stereotype.Service;
import pl.michol.invest.data.entity.InvestStyle;
import pl.michol.invest.data.http.InvestStyleHttpModel;

@Service
public class InvestStyleToInvestStyleHttpModelConverter implements Converter<InvestStyle, InvestStyleHttpModel> {
    @Override
    public InvestStyleHttpModel convert(InvestStyle investStyle) {
        InvestStyleHttpModel investStyleHttpModel = new InvestStyleHttpModel();
        if(investStyle!=null){
            investStyleHttpModel.setCashFundPercent(investStyle.getCashFundPercent());
            investStyleHttpModel.setForeignFundPercent(investStyle.getForeignFundPercent());
            investStyleHttpModel.setName(investStyle.getName());
            investStyleHttpModel.setPolishFundPercent(investStyle.getPolishFundPercent());
        }
        return investStyleHttpModel;
    }
}
