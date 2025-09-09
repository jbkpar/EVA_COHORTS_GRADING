package EVA_COHORTS_GRADING.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "submissions")
@AllArgsConstructor
@NoArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "submission_date", nullable = false)
    private LocalDateTime submissionDate;


    @OneToOne(mappedBy = "submission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Grade grade;



    // getter and setter

    // calculate hr

}

