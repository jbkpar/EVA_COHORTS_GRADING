package EVA_COHORTS_GRADING.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    private String questionText;
    private String answer;
    private long answeredByTeacherId;

}
