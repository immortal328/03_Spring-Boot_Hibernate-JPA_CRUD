package ap.immortal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/")
	public String greetingMsg() {
		return "<h1>"+"WellCome to Hibernate Spring Practice project"+"</h1>";
	}
	

}
