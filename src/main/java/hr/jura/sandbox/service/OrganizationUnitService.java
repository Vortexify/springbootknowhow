package hr.jura.sandbox.service;

import hr.jura.sandbox.model.OrganizationUnit;
import hr.jura.sandbox.repository.OrganizationUnitRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationUnitService {

    private final OrganizationUnitRepository organizationUnitRepository;

    public OrganizationUnitService(OrganizationUnitRepository organizationUnitRepository) {
        this.organizationUnitRepository = organizationUnitRepository;
    }

    public OrganizationUnit getOrganizationUnitById(Long organizationUnitId) {
        return organizationUnitRepository.findById(organizationUnitId);
    }

    public long createOrganizationUnit(OrganizationUnit organizationUnit) {
        return organizationUnitRepository.save(organizationUnit);
    }

    public OrganizationUnit updateOrganizationUnit(OrganizationUnit organizationUnit) {
        return organizationUnitRepository.update(organizationUnit);
    }

    public void deleteOrganizationUnit(Long organizationUnitId) {
        organizationUnitRepository.deleteById(organizationUnitId);
    }
}