package live.openinterest.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import live.openinterest.ui.service.RestService;

@Controller
public class HomeController {

	@Autowired
	private RestService service;

	/**
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/chartdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getChartData() {
		return ResponseEntity.ok().body(service.getCandleStickData());
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String getHomepage(Model model) {
		float openinterest = service.getOpenInterest();
		model.addAttribute("openinterest", openinterest);
		return "home";
	}
}
