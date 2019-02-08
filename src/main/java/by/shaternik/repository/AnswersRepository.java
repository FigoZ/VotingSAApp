package by.shaternik.repository;

import by.shaternik.model.Answers;
import by.shaternik.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswersRepository extends JpaRepository <Answers, Long> {

    /*@Query("SELECT count(*) FROM answers a WHERE a.voting_id = :VotingId")
   // Long countByAnswers (@Param("VotingId") Long id);
    Long countByAnswers ();*/
}
