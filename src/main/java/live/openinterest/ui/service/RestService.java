package live.openinterest.ui.service;

import org.springframework.stereotype.Service;

@Service
public class RestService extends AbstractService {

	/**
	 * @return
	 */
	public String getCandleStickData() {
		return restTemplate.getForObject(restUrl + chartdataEndpoint, String.class);
	}

	/**
	 * @return
	 */
	public float getOpenInterest() {
		String openInterest = restTemplate.getForObject(restUrl + openinterestEndpoint, String.class);
		return Float.valueOf(openInterest);
	}

}
