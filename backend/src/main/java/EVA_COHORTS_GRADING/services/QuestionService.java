package EVA_COHORTS_GRADING.services;

import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.entities.Question;
import EVA_COHORTS_GRADING.repository.AssignmentRepository;
import EVA_COHORTS_GRADING.repository.QuestionRepository;
import org.springframework.stereotype.Service;
@Service
public class QuestionService {
    private AssignmentRepository assignmentRepository;
    private QuestionRepository questionRepository;
    public Question createQuestion(String answer, String question_text, long teacherId, long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        Question question = Question.builder()
                .questionText(question_text)
                .answer(answer)
                .answeredByTeacherId(teacherId)
                .assignment(assignment)
                .build();

        return questionRepository.save(question);
    }
    public Question updateQuestion(Long id, String newText, String newAnswer) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        if (newText != null && !newText.isBlank()) {
            question.setQuestionText(newText);
        }

        if (newAnswer != null && !newAnswer.isBlank()) {
            question.setAnswer(newAnswer);
        }

        return questionRepository.save(question);
    }

    // ✅ Delete Question
    public void deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("Question not found");
        }
        questionRepository.deleteById(id);
    }
}

