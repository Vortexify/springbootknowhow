package hr.jura.sandbox.service;

import hr.jura.sandbox.model.Workplace;
import hr.jura.sandbox.repository.WorkplaceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceService {

    private final WorkplaceRepository workplaceRepository;

    public WorkplaceService(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    public Workplace getWorkplaceById(Long workplaceId) {
        return workplaceRepository.findById(workplaceId);
    }

    public long createWorkplace(Workplace workplace) {
        return workplaceRepository.save(workplace);
    }

    public Workplace updateWorkplace(Workplace workplace) {
        return workplaceRepository.update(workplace);
    }

    public void deleteWorkplace(Long workplaceId) {
        workplaceRepository.deleteById(workplaceId);
    }
}