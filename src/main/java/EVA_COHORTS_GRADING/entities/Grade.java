package EVA_COHORTS_GRADING.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long submissionId;
    private int pointsEarned;
    private LocalDateTime gradedDate;
    private long gradedByTeacherId;


    private double calculatePercentage(){
        //TODO
        return 0.00;
    }

}
