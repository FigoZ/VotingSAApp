package by.shaternik.model;

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


}
