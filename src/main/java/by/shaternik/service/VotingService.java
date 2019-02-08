package by.shaternik.service;


import by.shaternik.model.Answers;
import by.shaternik.model.Voting;
import by.shaternik.repository.AnswersRepository;
import by.shaternik.repository.VotingRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

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

    public Optional<Voting> end(Long id) {
        Optional<Voting> voting = votingRepository.findById(id);

        voting.get().setEndStatus(true);
        log.info("status End of voting id= "+ id);
        return voting;
    }

    public void addAnswer(Long id, Integer answerType) {

        Answers answer = new Answers();
        answer.setTypeAnswer(answerType);
        answersRepository.save(answer);

        Optional<Voting> voting= votingRepository.findById(id);
        if(voting.get().getAnswers().isEmpty()){
            ArrayList <Answers> answers = new ArrayList();
            answers.add(answer);
            voting.get().setAnswers(answers);
        }
        else {
            voting.get().getAnswers().add(answer);
        }
        log.info("add answer type "+answerType+" for question id= "+id);
    }


    public void countAnswers() {
        Long l = votingRepository.countByVotingIdAndTypeAnswer(2L,1);
       // String l = votingRepository.findURL(1L);
        System.out.println("===="+l);
    }
}

