package hr.jura.sandbox;

import hr.jura.sandbox.model.Company;
import hr.jura.sandbox.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SandboxApplicationTests {

	@Autowired
	CompanyService companyService;

	@Test
	void getCompany() {
		Company company = companyService.getCompanyById(1L);
		log.info(company.getCompanyName());
	}

	@Test
	void saveCompany() {
		Company company = new Company(-1L, "Firma xyz");
		companyService.createCompany(company);
		companyService.updateCompany(company);
	}

	@Test
	void deleteCompany(){
		Company company = companyService.getCompanyById(22L);
		companyService.deleteCompany(company.getCompanyId());
	}

}