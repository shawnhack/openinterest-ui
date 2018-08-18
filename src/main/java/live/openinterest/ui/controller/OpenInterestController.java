package live.openinterest.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import live.openinterest.ui.service.OpenInterestService;

@Controller
public class OpenInterestController {

    @Autowired
    private OpenInterestService service;

    /**
     * @param model
     * @return
     */
    @GetMapping("/")
    public String getOpenInterestPage(Model model) {
        model.addAttribute("openinterest", service.getOpenInterest());
        return "openinterest";
    }

    /**
     * @return
     */
    @GetMapping("/openinterest")
    public ResponseEntity<Float> getOpenInterest() {
        float openInterest = service.getOpenInterest();
        return ResponseEntity.ok().body(openInterest);
    }

}
