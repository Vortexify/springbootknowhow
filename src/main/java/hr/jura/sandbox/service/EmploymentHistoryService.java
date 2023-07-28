package hr.jura.sandbox.service;

import hr.jura.sandbox.model.EmploymentHistory;
import hr.jura.sandbox.repository.EmploymentHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class EmploymentHistoryService {

    private final EmploymentHistoryRepository employmentRepository;

    public EmploymentHistoryService(EmploymentHistoryRepository employmentRepository) {
        this.employmentRepository = employmentRepository;
    }

    public EmploymentHistory getEmploymentById(Long employmentId) {
        return employmentRepository.findById(employmentId).orElse(null);
    }

    public EmploymentHistory createEmployment(EmploymentHistory employment) {
        return employmentRepository.save(employment);
    }

    public EmploymentHistory updateEmployment(Long companyId, EmploymentHistory updatedCompany) {
        EmploymentHistory existingEmployment = employmentRepository.findById(companyId).orElse(null);
        if (existingEmployment != null) {
            existingEmployment.setEmployeeId(updatedCompany.getEmployeeId());
            existingEmployment.setWorkplaceId(updatedCompany.getWorkplaceId());
            existingEmployment.setStartDate(updatedCompany.getStartDate());
            existingEmployment.setEndDate(updatedCompany.getEndDate());
            return employmentRepository.save(existingEmployment);
        }
        return null;
    }

    public void deleteEmployment(Long employmentId) {
        employmentRepository.deleteById(employmentId);
    }
}
