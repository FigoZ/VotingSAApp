package by.shaternik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "voting_storage", name = "answers")
public class Answers {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;

    @Column
    private int typeAnswer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voting_id")
    private Voting voting;

}
