package ca.sheridancollege.consmatt.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import ca.sheridancollege.consmatt.beans.Score;
import ca.sheridancollege.consmatt.repositories.ScoreRepository;

@Controller
public class HomeController {
	
	static ArrayList<Score> scores = new ArrayList<Score>();
	
	@Autowired
	private ScoreRepository scoreRepo;

	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}
	
	@GetMapping("/scores")
	public String scores(@ModelAttribute Score score, Model model) {
		model.addAttribute("myScores", scoreRepo.getScores());
		return "scoreboard.html";
	}
	
}
