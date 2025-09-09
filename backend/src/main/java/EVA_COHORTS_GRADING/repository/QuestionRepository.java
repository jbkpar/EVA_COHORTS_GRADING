package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
