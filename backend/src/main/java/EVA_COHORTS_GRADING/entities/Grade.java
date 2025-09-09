package EVA_COHORTS_GRADING.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "grades")

@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "submission_id", nullable = false, unique = true)
    private Submission submission;

    @Column(name = "points_earned", nullable = false)
    private int pointsEarned;


    @Column(name = "graded_date", nullable = false)
    private LocalDateTime gradedDate;

    @Column(name = "graded_by_teacher_id", nullable = false)
    private Long gradedByTeacherId;
}