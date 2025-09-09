package EVA_COHORTS_GRADING.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @PostMapping
    public String assignGrade() { return "Assign grade"; }

    @PutMapping("/{id}")
    public String updateGrade(@PathVariable Long id) { return "Update grade"; }

    @GetMapping("/student/{studentId}")
    public String getGradesByStudent(@PathVariable Long studentId) { return "Get grades by student"; }
}
