package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
