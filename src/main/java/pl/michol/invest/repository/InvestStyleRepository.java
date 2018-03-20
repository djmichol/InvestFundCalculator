package pl.michol.invest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michol.invest.data.InvestStyle;

@Repository
public interface InvestStyleRepository extends CrudRepository<InvestStyle, Long>{

    InvestStyle findByName(InvestStyle.InvestStyleName name);
}
