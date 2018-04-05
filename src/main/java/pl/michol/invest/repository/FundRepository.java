package pl.michol.invest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michol.invest.data.entity.Fund;

@Repository
public interface FundRepository extends CrudRepository<Fund, Long> {
}
