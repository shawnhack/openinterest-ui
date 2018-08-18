package live.openinterest.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.openinterest.ui.model.OpenInterest;
import live.openinterest.ui.repository.OpenInterestRepository;

@Service
public class OpenInterestService {

    @Autowired
    private OpenInterestRepository repository;

    /**
     * @param amount
     */
    public float getOpenInterest() {
        OpenInterest last = repository.findFirstByOrderByIdDesc();
        return last.getAmount();
    }

}
