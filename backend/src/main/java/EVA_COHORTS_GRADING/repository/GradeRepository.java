package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findBySubmissionId(long submissionId);
}
