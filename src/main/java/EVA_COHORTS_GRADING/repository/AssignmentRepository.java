package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
