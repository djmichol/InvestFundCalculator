package pl.michol.invest.converter;

import org.springframework.stereotype.Service;
import pl.michol.invest.data.entity.Fund;
import pl.michol.invest.data.http.FundHttpModel;

@Service
public class FundToFundHttpConverter implements Converter<Fund, FundHttpModel> {

    @Override
    public FundHttpModel convert(Fund fund) {
        FundHttpModel fundHttpModel = new FundHttpModel();
        if (fund != null) {
            fundHttpModel.setKind(fund.getKind());
            fundHttpModel.setName(fund.getName());
        }
        return fundHttpModel;
    }

}
