package EVA_COHORTS_GRADING.services;

import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.entities.Grade;
import EVA_COHORTS_GRADING.entities.Submission;
import EVA_COHORTS_GRADING.repository.AssignmentRepository;
import EVA_COHORTS_GRADING.repository.SubmissionRepository;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherService {
    private AssignmentRepository assignmentRepository;
    private AssignmentService assignmentService;
    private SubmissionRepository submissionRepository;
    public void createAssignment(String title, long teacherId, LocalDateTime dueDate) {
        Assignment assignment = Assignment.builder()
                .title(title)
                .teacherId(teacherId)
                .dueDate(dueDate)
                .build();
        assignmentRepository.save(assignment);
    }
    public void publishAssignment(long assignmentId) {
        assignmentService.publish(assignmentId);
    }
    public void addQuestionToAssignment(long assignmentId) {
        assignmentService.publish(assignmentId);
    }
    public List<Submission> viewSubmissions() {
        return submissionRepository.findAll();
    }
    public void gradeSubmission(long submissionId, Grade grade) {
        Submission submission = submissionRepository.findById(submissionId).get();
        submission.setGrade(grade);
        submissionRepository.save(submission);
    }
}
