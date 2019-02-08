package by.shaternik.service;


import by.shaternik.repository.AnswersRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor (onConstructor = @__(@Autowired))
public class AnsewrsService {

    private final AnswersRepository answersRepository;
    Logger log = LoggerFactory.getLogger(AnsewrsService.class);



    public void coutQuestions() {
      //  String hql ="SELECT count(V.id) FROM Voting V";
      // Long l = answersRepository.countByAnswers();

    }



}

