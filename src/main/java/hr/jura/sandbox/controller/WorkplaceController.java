package hr.jura.sandbox.controller;

import hr.jura.sandbox.model.Workplace;
import hr.jura.sandbox.service.WorkplaceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workplaces")
public class WorkplaceController {

    private final WorkplaceService workplaceService;

    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping("/{workplaceId}")
    public Workplace getWorkplaceById(@PathVariable Long workplaceId) {
        return workplaceService.getWorkplaceById(workplaceId);
    }

    @PostMapping
    public Workplace createWorkplace(@RequestBody Workplace workplace) {
        return workplaceService.createWorkplace(workplace);
    }

    @PutMapping("/{workplaceId}")
    public Workplace updateWorkplace(@PathVariable Long workplaceId, @RequestBody Workplace updatedWorkplace) {
        return workplaceService.updateWorkplace(workplaceId, updatedWorkplace);
    }

    @DeleteMapping("/{workplaceId}")
    public void deleteWorkplace(@PathVariable Long workplaceId) {
        workplaceService.deleteWorkplace(workplaceId);
    }
}