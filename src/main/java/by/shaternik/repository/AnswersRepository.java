package by.shaternik.repository;

import by.shaternik.model.Answers;
import by.shaternik.model.Voting;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswersRepository extends JpaRepository <Answers, Long> {

     Long countByVotingIdAndTypeAnswer(Long id, int typeAnswer);
     Long countByVotingId(Long id);

}
