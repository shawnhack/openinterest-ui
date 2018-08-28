package live.openinterest.ui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import live.openinterest.ui.model.DailyCandle;

@Repository
public interface DailyCandleRepository extends JpaRepository<DailyCandle, Integer> {

}
