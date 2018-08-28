package live.openinterest.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import live.openinterest.ui.model.DailyCandle;
import live.openinterest.ui.repository.DailyCandleRepository;

@Service
public class DailyCandleService {

	private static final int MILLISECONDS_IN_DAY = 86_400_000;

	@Autowired
	private DailyCandleRepository repository;

	/**
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getCandleStickData() {
		String jsonData = "";

		List<DailyCandle> candlesticks = repository.findAll();

		jsonData = buildChartData(candlesticks);

		return jsonData;
	}

	/**
	 * @param candlesticks
	 * @return
	 * @throws JsonProcessingException
	 */
	private String buildChartData(List<DailyCandle> candlesticks) {
		String jsonData = "";
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();

		List<List<Number>> chartData = new ArrayList<>();

		for (DailyCandle candlestick : candlesticks) {
			List<Number> day = new ArrayList<>();
			chartData.add(day);

			day.add(candlestick.getDate().toEpochDay() * MILLISECONDS_IN_DAY);
			day.add(candlestick.getOpen());
			day.add(candlestick.getHigh());
			day.add(candlestick.getLow());
			day.add(candlestick.getClose());
		}

		try {
			jsonData = objectMapper.writeValueAsString(chartData);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonData;
	}

}
