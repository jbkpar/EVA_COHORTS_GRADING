package EVA_COHORTS_GRADING.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private long id;
    private long assignmentId;
    private String questionText;
    private String answer;
    private long answeredByTeacherId;

}
