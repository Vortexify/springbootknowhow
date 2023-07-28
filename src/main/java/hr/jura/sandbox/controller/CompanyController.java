package hr.jura.sandbox.controller;
import hr.jura.sandbox.model.Company;
import hr.jura.sandbox.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

   public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable Long companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return null;
    }

    @PutMapping("/{companyId}")
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
    }
}