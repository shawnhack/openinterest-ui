package live.openinterest.ui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import live.openinterest.ui.model.OpenInterest;

@Repository
public interface OpenInterestRepository extends JpaRepository<OpenInterest, Integer> {

    /**
     * @return
     */
    public OpenInterest findFirstByOrderByIdDesc();
}
