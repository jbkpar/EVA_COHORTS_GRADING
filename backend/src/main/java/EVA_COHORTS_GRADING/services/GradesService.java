package EVA_COHORTS_GRADING.services;

import EVA_COHORTS_GRADING.entities.Grade;
import EVA_COHORTS_GRADING.entities.Submission;
import EVA_COHORTS_GRADING.repository.GradeRepository;
import EVA_COHORTS_GRADING.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradesService {

    private final GradeRepository gradeRepository;
    private final SubmissionRepository submissionRepository;
    @Autowired
    private final StudentService studentService;

    // 1️⃣ Assign a grade to a submission
    public Grade assignGrade(Long submissionId, int pointsEarned, Long teacherId) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        Grade grade = new Grade();
        grade.setSubmission(submission);
        grade.setPointsEarned(pointsEarned);
        grade.setGradedByTeacherId(teacherId);
        grade.setGradedDate(LocalDateTime.now());

        return gradeRepository.save(grade);
    }

    // 2️⃣ Update an existing grade
    public Grade updateGrade(Long gradeId, int newPointsEarned, Long teacherId) {
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found"));

        grade.setPointsEarned(newPointsEarned);
        grade.setGradedByTeacherId(teacherId);
        grade.setGradedDate(LocalDateTime.now());

        return gradeRepository.save(grade);
    }

    // 3️⃣ Get all grades for a student
    public List<Grade> getGradesByStudent(Long studentId) {
        return studentService.viewGrades(studentId);
    }
}
