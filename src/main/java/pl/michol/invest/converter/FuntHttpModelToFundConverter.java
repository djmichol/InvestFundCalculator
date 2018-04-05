package pl.michol.invest.converter;

import org.springframework.stereotype.Service;
import pl.michol.invest.data.entity.Fund;
import pl.michol.invest.data.http.FundHttpModel;

@Service
public class FuntHttpModelToFundConverter implements Converter<FundHttpModel, Fund> {
    @Override
    public Fund convert(FundHttpModel fundHttpModel) {
        Fund fund = new Fund();
        if (fundHttpModel != null) {
            fund.setKind(fundHttpModel.getKind());
            fund.setName(fundHttpModel.getName());
        }
        return fund;
    }
}
