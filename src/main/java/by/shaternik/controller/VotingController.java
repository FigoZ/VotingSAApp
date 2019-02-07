package by.shaternik.controller;

import by.shaternik.model.Voting;
import by.shaternik.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingController {
	private final VotingService votingService;

	@RequestMapping("/votings/{id}")
	String pageVoting (@PathVariable("id") Long id, ModelMap modal){
		Optional<Voting> voting= votingService.getById(id);
		modal.addAttribute("message",voting.get().getQuestion());
		return "voting";
	}

	@RequestMapping("/endvoting")
	String endVoting (){
		return "endvoting";
	}

	@RequestMapping("/votings/voice")
	String pageThank (@RequestParam(name="answer") Long answerType){
		System.out.println("Voice ====="+answerType);


		return "thank";
	}
}
