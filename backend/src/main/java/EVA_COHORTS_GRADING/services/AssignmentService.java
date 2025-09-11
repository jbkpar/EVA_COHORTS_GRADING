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

    public void publish(String id){
        Assignment assignment = assignmentRepository.findByTitle(id).get();
        assignment.setPublished(true);
        assignmentRepository.save(assignment);
    }
    public void addQuestion(String title, Question question){
        Assignment assignment = assignmentRepository.findByTitle(title).get();
        assignment.getQuestions().add(question);
        int points = assignment.getPointsPossible();
        assignment.setPointsPossible(points + 1);
        assignmentRepository.save(assignment);
    }
    public void removeQuestion(String id, Question question){
        Assignment assignment = assignmentRepository.findByTitle(id).get();
        assignment.getQuestions().remove(question);
        int points = assignment.getPointsPossible();
        assignment.setPointsPossible(points - 1);
        assignmentRepository.delete(assignment);
    }
}
