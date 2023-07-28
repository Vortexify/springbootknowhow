package hr.jura.sandbox.controller;

import hr.jura.sandbox.model.OrganizationUnit;
import hr.jura.sandbox.service.OrganizationUnitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizationUnits")
public class OrganizationUnitController {

    private final OrganizationUnitService organizationUnitService;

    public OrganizationUnitController(OrganizationUnitService organizationUnitService) {
        this.organizationUnitService = organizationUnitService;
    }

    @GetMapping("/{organizationUnitId}")
    public OrganizationUnit getOrganizationUnitById(@PathVariable Long organizationUnitId) {
        return organizationUnitService.getOrganizationUnitById(organizationUnitId);
    }

    @PostMapping
    public OrganizationUnit createOrganizationUnit(@RequestBody OrganizationUnit organizationUnit) {
        return null;
    }

    @PutMapping("/{organizationUnitId}")
    public OrganizationUnit updateOrganizationUnit(@RequestBody OrganizationUnit organizationUnit) {
        return organizationUnitService.updateOrganizationUnit(organizationUnit);
    }

    @DeleteMapping("/{organizationUnitId}")
    public void deleteOrganizationUnit(@PathVariable Long organizationUnitId) {
        organizationUnitService.deleteOrganizationUnit(organizationUnitId);
    }
}