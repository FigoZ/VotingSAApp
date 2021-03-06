package by.shaternik.controller;

import by.shaternik.model.Voting;
import by.shaternik.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingRestController {

    private final VotingService votingService;

    @PostMapping("/addque")
    public Voting add(@RequestParam(value="question") String str){
        return votingService.add(str);
    }

    @RequestMapping("/endvotings")
    public Voting end(@RequestParam(value="id") Long id){
        return votingService.end(id);
    }

}
