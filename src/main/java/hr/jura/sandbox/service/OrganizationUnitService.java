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
        return organizationUnitRepository.findById(organizationUnitId).orElse(null);
    }

    public OrganizationUnit createOrganizationUnit(OrganizationUnit organizationUnit) {
        return organizationUnitRepository.save(organizationUnit);
    }

    public OrganizationUnit updateOrganizationUnit(Long organizationUnitId, OrganizationUnit updatedOrganizationUnit) {
        OrganizationUnit existingOrganizationUnit = organizationUnitRepository.findById(organizationUnitId).orElse(null);
        if (existingOrganizationUnit != null) {
            existingOrganizationUnit.setUnitName(updatedOrganizationUnit.getUnitName());
            return organizationUnitRepository.save(existingOrganizationUnit);
        }
        return null;
    }

    public void deleteOrganizationUnit(Long organizationUnitId) {
        organizationUnitRepository.deleteById(organizationUnitId);
    }
}