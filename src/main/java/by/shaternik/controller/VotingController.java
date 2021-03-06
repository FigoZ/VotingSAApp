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

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingController {
	private final VotingService votingService;

	@RequestMapping("/votings/{id}")
	String pageVoting (@PathVariable("id") Long id, ModelMap modal){
		Optional<Voting> voting= votingService.getById(id);
		if (voting.get().isEndStatus()==false){
			modal.addAttribute("message",voting.get().getQuestion());
			modal.addAttribute("votingId",voting.get().getId());
			return "voting";
		}
		else{
			ArrayList<Long> arr =  votingService.countAnswers(id);

			modal.addAttribute("question",voting.get().getQuestion());
			modal.addAttribute("allVoices",arr.get(0));
			modal.addAttribute("answer1",arr.get(1));
			modal.addAttribute("answer2",arr.get(2));
			modal.addAttribute("answer3",arr.get(3));
			return "statistic";
		}
	}

	@RequestMapping("/endvoting")
	String endVoting (){
		return "endvoting";
	}

	@RequestMapping("/votings/voice")
	String pageThank (@RequestParam(name="answer") Integer answerType,@RequestParam(name="id") Long id){
		votingService.addAnswer(id, answerType);
		return "thank";
	}
}
