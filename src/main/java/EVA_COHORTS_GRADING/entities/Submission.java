package EVA_COHORTS_GRADING.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor

public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_id")
    @NotNull
    private long studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    @NotNull
    private Assignment assignment;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "submission_date")
    @NotNull
    private LocalDateTime submissionDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Grade grade;

    // Constructors
    public Submission() {
        this.submissionDate = LocalDateTime.now();
    }

    // getter and setter

    // calculate hr

}

