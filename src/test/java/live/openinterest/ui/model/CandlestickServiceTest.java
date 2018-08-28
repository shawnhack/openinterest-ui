package live.openinterest.ui.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;

import live.openinterest.ui.repository.OpenInterestRepository;
import live.openinterest.ui.service.DailyCandleService;
import live.openinterest.ui.test.AbstractTest;

public class CandlestickServiceTest extends AbstractTest {

	@Autowired
	private DailyCandleService service;

	@Mock
	private OpenInterestRepository repository;

	/**
	 * @throws JsonProcessingException
	 * 
	 */
	@Test
	void getCandleStickData() {
		assertThat(service.getCandleStickData()).isNotNull();
	}

}
