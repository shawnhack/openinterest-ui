package live.openinterest.ui.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.fasterxml.jackson.core.JsonProcessingException;

import live.openinterest.ui.service.CandlestickService;
import live.openinterest.ui.test.AbstractTest;

@AutoConfigureTestDatabase(replace = Replace.NONE)
class CandlestickServiceTest extends AbstractTest {

	@Autowired
	private CandlestickService service;

	/**
	 * @throws JsonProcessingException
	 * 
	 */
	@Test
	void testGetCandleStickData() throws JsonProcessingException {
		System.out.println(service.getCandleStickData());
	}

}
