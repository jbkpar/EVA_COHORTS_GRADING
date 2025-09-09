package EVA_COHORTS_GRADING.services;

import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.entities.Grade;
import EVA_COHORTS_GRADING.entities.Submission;
import EVA_COHORTS_GRADING.repository.AssignmentRepository;
import EVA_COHORTS_GRADING.repository.GradeRepository;
import EVA_COHORTS_GRADING.repository.StudentRepository;
import EVA_COHORTS_GRADING.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private AssignmentRepository assignmentRepository;
    private GradeRepository gradeRepository;
    private SubmissionRepository submissionRepository;

    private List<Assignment> viewAssignments(){
        List<Assignment> assignmentList = assignmentRepository.findAll();
        return  assignmentList;
    }
    private void submitAssignment(long assignmentId, long studentId, String submissionContent){
        Submission submission = new Submission();
        submission.setAssignment(assignmentRepository.findById(assignmentId).get());
        submission.setStudentId(studentId);
        submission.setContent(submissionContent);
    }
    private List<Grade> viewGrades(long studentId){
        List<Submission> submissions = submissionRepository.findByStudentId(studentId);
        List<Grade> grades = new ArrayList<>();
        for(Submission submission : submissions){
             grades.addAll(gradeRepository.findBySubmissionId(submission.getId()));
        }
        return grades;
    }
    private List<Submission> viewSubmissionHistory(long studentId){
        return submissionRepository.findByStudentId(studentId);
    }


}
