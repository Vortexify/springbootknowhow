package hr.jura.sandbox.service;
import hr.jura.sandbox.model.Company;
import hr.jura.sandbox.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long companyId, Company updatedCompany) {
        Company existingCompany = companyRepository.findById(companyId).orElse(null);
        if (existingCompany != null) {
            existingCompany.setCompanyName(updatedCompany.getCompanyName());
            return companyRepository.save(existingCompany);
        }
        return null;
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
