package EVA_COHORTS_GRADING.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    @GetMapping("/{id}")
    public String getSubmission(@PathVariable Long id) { return "Get submission"; }

    @GetMapping("/assignment/{assignmentId}")
    public String getSubmissionsByAssignment(@PathVariable Long assignmentId) { return "Get submissions by assignment"; }
}
