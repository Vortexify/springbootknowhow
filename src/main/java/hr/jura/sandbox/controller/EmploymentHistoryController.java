package hr.jura.sandbox.controller;

import hr.jura.sandbox.model.EmploymentHistory;
import hr.jura.sandbox.service.EmploymentHistoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employmentHistories")
public class EmploymentHistoryController {

    private final EmploymentHistoryService employmentHistoryService;

    public EmploymentHistoryController(EmploymentHistoryService employmentHistoryService) {
        this.employmentHistoryService = employmentHistoryService;
    }

    @GetMapping("/{employmentHistoryId}")
    public EmploymentHistory getEmploymentHistoryById(@PathVariable Long employmentHistoryId) {
        return employmentHistoryService.getEmploymentById(employmentHistoryId);
    }

    @PostMapping
    public EmploymentHistory createEmploymentHistory(@RequestBody EmploymentHistory employmentHistory) {
        return null;
    }

    @PutMapping("/{employmentHistoryId}")
    public EmploymentHistory updateEmploymentHistory(@RequestBody EmploymentHistory employmentHistory) {
        return employmentHistoryService.updateEmployment(employmentHistory);
    }

    @DeleteMapping("/{employmentHistoryId}")
    public void deleteEmploymentHistory(@PathVariable Long employmentHistoryId) {
        employmentHistoryService.deleteEmployment(employmentHistoryId);
    }
}