package EVA_COHORTS_GRADING.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @GetMapping("/assignments")
    public String viewAssignments() { return "View assignments"; }

    @PostMapping("/assignments/{id}/submit")
    public String submitAssignment(@PathVariable Long id) { return "Submit assignment"; }

    @GetMapping("/grades")
    public String viewGrades() { return "View grades"; }
}
