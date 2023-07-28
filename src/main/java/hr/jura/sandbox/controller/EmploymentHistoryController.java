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
        return employmentHistoryService.createEmployment(employmentHistory);
    }

    @PutMapping("/{employmentHistoryId}")
    public EmploymentHistory updateEmploymentHistory(@PathVariable Long employmentHistoryId, @RequestBody EmploymentHistory updatedEmploymentHistory) {
        return employmentHistoryService.updateEmployment(employmentHistoryId, updatedEmploymentHistory);
    }

    @DeleteMapping("/{employmentHistoryId}")
    public void deleteEmploymentHistory(@PathVariable Long employmentHistoryId) {
        employmentHistoryService.deleteEmployment(employmentHistoryId);
    }
}