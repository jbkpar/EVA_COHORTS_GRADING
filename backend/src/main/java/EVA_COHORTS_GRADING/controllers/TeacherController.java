package EVA_COHORTS_GRADING.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @PostMapping("/assignments")
    public String createAssignment() { return "Create assignment"; }

    @PostMapping("/assignments/{id}/publish")
    public String publishAssignment(@PathVariable Long id) { return "Publish assignment"; }

    @PostMapping("/assignments/{id}/questions")
    public String addQuestion(@PathVariable Long id) { return "Add question"; }

    @GetMapping("/assignments/{id}/submissions")
    public String viewSubmissions(@PathVariable Long id) { return "View submissions"; }

    @PostMapping("/submissions/{id}/grade")
    public String gradeSubmission(@PathVariable Long id) { return "Grade submission"; }
}
