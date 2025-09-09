package EVA_COHORTS_GRADING.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @PostMapping
    public String addQuestion() { return "Add question"; }

    @PutMapping("/{id}")
    public String updateQuestion(@PathVariable Long id) { return "Update question"; }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) { return "Delete question"; }
}
