package by.shaternik.repository;

import by.shaternik.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotingRepository extends JpaRepository <Voting, Long> {
    /*@Query("SELECT count(*) FROM voting v join v.answers a WHERE a.typeAnswer =?1")
   // Long countByAnswers (@Param("VotingId") Long id);
    Long countByAnswers (Integer i);*/

   // @Query("select v.url from voting v WHERE v.id=?1")

    //@Query(value = "select v.url from voting v WHERE v.id=?1", nativeQuery = true) //!!!запускается, запрос не раб (
   // @Query(value = "select v.url from VOTING_STORAGE.voting v WHERE v.id=?1", nativeQuery = true) //!!! работает



  // @Query(countQuery = "SELECT count(*) FROM VOTING_STORAGE.voting WHERE typeAnswer =?1", nativeQuery = true)
  // Long countByAnswers (Integer i);

    Long countByVotingIdAndTypeAnswer(Long id, int typeAnswer);

    //@Query(value = "select v.url from VOTING_STORAGE.voting v WHERE v.id=?1", nativeQuery = true) //!!! работает
    //String findURL (Long id);
}

