package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.entities.Grade;
import EVA_COHORTS_GRADING.entities.Student;
import EVA_COHORTS_GRADING.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByStudentId(long studentId);
    List<Submission> findByAssignmentId(Long assignmentId);
}
