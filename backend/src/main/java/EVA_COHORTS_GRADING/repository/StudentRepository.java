package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
