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
        return employmentRepository.findById(employmentId);
    }

    public long createEmployment(EmploymentHistory employment) {
        return employmentRepository.save(employment);
    }

    public EmploymentHistory updateEmployment(EmploymentHistory employment) {
        return employmentRepository.update(employment);
    }

    public void deleteEmployment(Long employmentId)
    {
        employmentRepository.deleteById(employmentId);
    }
}
