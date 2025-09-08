package EVA_COHORTS_GRADING.repository;

import EVA_COHORTS_GRADING.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
