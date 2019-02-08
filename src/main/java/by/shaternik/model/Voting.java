package by.shaternik.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "voting_storage", name = "voting")
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;

    @Column
    String url;

    @Column
    private  String question;

    @Column
    boolean endStatus;


    @OneToMany (cascade = CascadeType.ALL)
  //  @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answers> answers;

    public Voting (String question){
        this.question = question;
    }
}
