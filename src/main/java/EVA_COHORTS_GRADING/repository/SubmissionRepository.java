package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
