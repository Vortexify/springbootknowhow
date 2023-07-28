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
        return companyRepository.findById(companyId);
    }

    public long createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company) {
       return companyRepository.update(company);
    }

    public void deleteCompany(long companyId) {
        companyRepository.deleteById(companyId);
    }
}
