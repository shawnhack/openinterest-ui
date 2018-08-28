package live.openinterest.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import live.openinterest.ui.service.DailyCandleService;
import live.openinterest.ui.service.OpenInterestService;

@Controller
public class OpenInterestController {

	@Autowired
	private OpenInterestService service;

	@Autowired
	private DailyCandleService candleStickService;

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String getOpenInterestPage(Model model) {
		float openinterest = service.getOpenInterest();
		model.addAttribute("openinterest", openinterest);
		return "home";
	}

	/**
	 * @return
	 */
	@GetMapping("/openinterest")
	public ResponseEntity<Float> getOpenInterest() {
		float openInterest = service.getOpenInterest();
		return ResponseEntity.ok().body(openInterest);
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/chartdata")
	public ResponseEntity<String> getChartData() {
		String data = candleStickService.getCandleStickData();
		return ResponseEntity.ok().body(data);
	}

}
