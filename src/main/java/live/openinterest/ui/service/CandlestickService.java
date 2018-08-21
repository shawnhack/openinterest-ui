package live.openinterest.ui.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import live.openinterest.ui.model.Candlestick;
import live.openinterest.ui.model.OpenInterest;
import live.openinterest.ui.repository.OpenInterestRepository;

@Service
public class CandlestickService {

	@Autowired
	private OpenInterestRepository repository;

	/**
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getCandleStickData() {
		String jsonData = "";

		List<OpenInterest> ticks = repository.findAll();

		List<Candlestick> candlesticks = buildCandlesticks(ticks);

		jsonData = buildChartData(candlesticks);

		return jsonData;
	}

	/**
	 * @param candlesticks
	 * @return
	 * @throws JsonProcessingException
	 */
	private String buildChartData(List<Candlestick> candlesticks) {
		String jsonData = "";
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();

		List<List<Number>> chartData = new ArrayList<>();

		for (Candlestick candlestick : candlesticks) {
			List<Number> day = new ArrayList<>();
			chartData.add(day);

			day.add(candlestick.getDate().toEpochSecond(ZoneOffset.UTC) * 1000);
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

	/**
	 * @param ticks
	 */
	private List<Candlestick> buildCandlesticks(List<OpenInterest> ticks) {

		List<Candlestick> candlesticks = new ArrayList<Candlestick>();

		Candlestick currentCandleStick = new Candlestick();

		for (OpenInterest tick : ticks) {
			LocalDateTime timestamp = tick.getTimestamp();
			float amount = tick.getAmount();

			LocalDateTime candleDate = timestamp;

			if (!currentCandleStick.isSameDay(candleDate)) {

				// Previous candlestick
				if (currentCandleStick.getOpen() > 0) {
					candlesticks.add(currentCandleStick);
					currentCandleStick = new Candlestick();
				}

				currentCandleStick.setDate(candleDate);
				currentCandleStick.setOpen(amount);

			} else {
				currentCandleStick.setClose(amount);
			}

			currentCandleStick.update(amount);
		}

		return candlesticks;
	}

}
