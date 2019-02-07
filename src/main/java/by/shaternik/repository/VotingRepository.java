package by.shaternik.repository;

import by.shaternik.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepository extends JpaRepository <Voting, Long> {
}
