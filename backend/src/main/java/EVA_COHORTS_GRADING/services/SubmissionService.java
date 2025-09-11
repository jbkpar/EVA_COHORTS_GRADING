package EVA_COHORTS_GRADING.services;

import EVA_COHORTS_GRADING.entities.Submission;
import EVA_COHORTS_GRADING.entities.Student;
import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.repository.SubmissionRepository;
import EVA_COHORTS_GRADING.repository.StudentRepository;
import EVA_COHORTS_GRADING.repository.AssignmentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final StudentRepository studentRepository;
    private final AssignmentRepository assignmentRepository;

    public SubmissionService(SubmissionRepository submissionRepository,
                             StudentRepository studentRepository,
                             AssignmentRepository assignmentRepository) {
        this.submissionRepository = submissionRepository;
        this.studentRepository = studentRepository;
        this.assignmentRepository = assignmentRepository;
    }

    /**
     * Student submits an assignment
     */
    public Submission submitAssignment(Long studentId, Long assignmentId, String content) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));



        Submission submission = new Submission();
        submission.setStudentId(studentId);
        submission.setAssignment(assignment);
        submission.setContent(content);
        submission.setSubmissionDate(LocalDateTime.now());

        return submissionRepository.save(submission);
    }

    /**
     * Update a student's submission
     */
    public Submission updateSubmission(Long submissionId, String updatedContent) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        submission.setContent(updatedContent);
        submission.setSubmissionDate(LocalDateTime.now());

        return submissionRepository.save(submission);
    }

    /**
     * Get all submissions by a student
     */
    public List<Submission> getSubmissionsByStudent(Long studentId) {

        return submissionRepository.findByStudentId(studentId);
    }

    /**
     * Get all submissions for a given assignment
     */
    public List<Submission> getSubmissionsByAssignment(Long assignmentId) {
        return submissionRepository.findByAssignmentId(assignmentId);
    }

}