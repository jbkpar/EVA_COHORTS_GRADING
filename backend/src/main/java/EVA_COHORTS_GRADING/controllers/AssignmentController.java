package EVA_COHORTS_GRADING.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @GetMapping
    public String getAllAssignments() { return "Get all assignments"; }

    @GetMapping("/{id}")
    public String getAssignment(@PathVariable Long id) { return "Get assignment"; }

    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id) { return "Delete assignment"; }
}
