package by.shaternik.service;


import by.shaternik.model.Answers;
import by.shaternik.model.Voting;
import by.shaternik.repository.AnswersRepository;
import by.shaternik.repository.VotingRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor (onConstructor = @__(@Autowired))
public class VotingService {
    private final VotingRepository votingRepository;
    private final AnswersRepository answersRepository;

    Logger log = LoggerFactory.getLogger(VotingService.class);

    public Voting add (String str) {
        Voting voting= new Voting();
        votingRepository.save(voting);
        voting.setQuestion(str);
        voting.setUrl("http://localhost:8080/votings/"+voting.getId());
        log.info("add DB new Voting "+ voting.getId()+" "+voting.getQuestion()+" "+voting.getUrl());
        return voting;
    }

    public Optional<Voting> getById(Long id){
          log.info("find voting id= "+ id);
        return votingRepository.findById(id);
    }

    public Voting end (Long id) {
        Voting voting = votingRepository.findById(id).orElse(null);
        voting.setEndStatus(true);
        log.info("status End of voting id= "+ id);
        return voting;
    }


    public void addAnswer(Long id, Integer answerType) {
        Voting voting = votingRepository.findById(id).orElse(null);
        if (voting != null) {
            Answers answer = new Answers();
            answer.setTypeAnswer(answerType);
            answer.setVoting(voting);
            voting.getAnswers().add(answer);
            votingRepository.save(voting);
        }
        log.info("add answer type "+answerType+ " for voting id= "+ id);
    }

    public ArrayList<Long> countAnswers(Long id) {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(answersRepository.countByVotingId(id));
       arr.add(answersRepository.countByVotingIdAndTypeAnswer(id,1));
       arr.add(answersRepository.countByVotingIdAndTypeAnswer(id,2));
       arr.add(answersRepository.countByVotingIdAndTypeAnswer(id,3));
        log.info("count statistic for voting id= "+ id);
        return arr;
    }
}

