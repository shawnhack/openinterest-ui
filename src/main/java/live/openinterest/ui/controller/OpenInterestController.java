package live.openinterest.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import live.openinterest.ui.service.OpenInterestService;

@Controller
public class OpenInterestController {

    @Autowired
    private OpenInterestService service;

    /**
     * @return
     */
    @GetMapping("/openinterest")
    public ResponseEntity<Float> getOpenInterest() {
        float openInterest = service.getOpenInterest();
        return ResponseEntity.ok().body(openInterest);
    }

}
