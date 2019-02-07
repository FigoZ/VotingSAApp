package by.shaternik.service;


import by.shaternik.model.Voting;
import by.shaternik.repository.VotingRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor (onConstructor = @__(@Autowired))
public class VotingService {
    private final VotingRepository votingRepository;
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



    /*  public void  save2 (Voting voting){
        votingRepository.save(voting);
        log.info("add DB new Voting "+ voting.getId()+" "+voting.getQuestion());
    }
    public Voting  save (String str){
        Voting voting= votingRepository.save(new Voting(str));
        log.info("add DB new Voting "+ voting.getId()+" "+voting.getQuestion());
        return voting;
    }

    public String  save3 (String str){
        Voting voting= votingRepository.save(new Voting(str));
        log.info("add DB new Voting "+ voting.getId()+" "+voting.getQuestion());
        return "blalala/nanan/"+voting.getId();
    }

    public Voting update (Long id){
        Optional<Voting> voting = votingRepository.findById(id);
        Voting votingNew = new Voting();
        BeanUtils.copyProperties(voting.get(),votingNew);

        votingNew.setEndStatus(true);
        votingNew.setUrl("http://localhost:8080/votings/"+votingNew.getId());
        votingRepository.save(votingNew);
        return votingNew;
    }*/
}

