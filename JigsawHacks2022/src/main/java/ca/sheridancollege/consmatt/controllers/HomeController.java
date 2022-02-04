package ca.sheridancollege.consmatt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}
	
	@GetMapping("/scores")
	public String scores() {
		return "scoreBoard.html";
	}
	
}
