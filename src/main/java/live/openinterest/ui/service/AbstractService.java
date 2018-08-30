package live.openinterest.ui.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractService {

	@Value("${rest.url}")
	protected String restUrl;

	@Value("${endpoint.chartdata}")
	protected String chartdataEndpoint;

	@Value("${endpoint.openinterest}")
	protected String openinterestEndpoint;

	protected RestTemplate restTemplate = new RestTemplate();
}
