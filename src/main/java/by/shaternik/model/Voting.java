package by.shaternik.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany (mappedBy = "voting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answers> answers;

    public Voting (String question){
        this.question = question;
    }
}
