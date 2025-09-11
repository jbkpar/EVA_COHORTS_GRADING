package EVA_COHORTS_GRADING.controllers;

import EVA_COHORTS_GRADING.entities.Assignment;
import EVA_COHORTS_GRADING.entities.Question;
import EVA_COHORTS_GRADING.services.AssignmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;



    @PutMapping
    public ResponseEntity<Void> publish(String id) {
        assignmentService.publish(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Question> addQuestion(@PathVariable String title, Question question) {

        assignmentService.addQuestion(title, question);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeQuestion(@PathVariable String title, Question question) {
        assignmentService.removeQuestion(title, question);
        return ResponseEntity.noContent().build();
    }
}
