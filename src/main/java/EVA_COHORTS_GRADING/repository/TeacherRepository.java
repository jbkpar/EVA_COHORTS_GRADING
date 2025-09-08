package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
