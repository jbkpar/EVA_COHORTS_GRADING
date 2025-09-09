package EVA_COHORTS_GRADING.services;

import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.entities.Question;
import EVA_COHORTS_GRADING.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

    public void publish(long id){
        Assignment assignment = assignmentRepository.findById(id).get();
        assignment.setPublished(true);
    }
    public void addQuestion(long id, Question question){
        Assignment assignment = assignmentRepository.findById(id).get();
        assignment.getQuestions().add(question);
        int points = assignment.getPointsPossible();
        assignment.setPointsPossible(points + 1);
    }
    public void removeQuestion(long id, Question question){
        Assignment assignment = assignmentRepository.findById(id).get();
        assignment.getQuestions().remove(question);
        int points = assignment.getPointsPossible();
        assignment.setPointsPossible(points - 1);
    }
}
