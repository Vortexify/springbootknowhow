package hr.jura.sandbox.repository;

import hr.jura.sandbox.model.Company;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository implements DataReporistory<Company> {

    private final NamedParameterJdbcTemplate njdbc;

    public CompanyRepository(@Qualifier("namedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public Company findById(Long companyId) {

        String SQL = "SELECT company_id, company_name FROM SYS.CAPP_COMPANY WHERE company_id = :companyId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("companyId", companyId);

        List<Company> companyList = njdbc.query(SQL, parameterMap, BeanPropertyRowMapper.newInstance(Company.class));

        if(companyList.size()>0) {
             return companyList.get(0);
        }

        return null;
    }

    @Override
    public long save(Company company) {
        String SQL = "INSERT INTO SYS.CAPP_COMPANY (COMPANY_NAME) VALUES (:companyName)";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("companyName", company.getCompanyName());
        njdbc.update(SQL,parameterMap);
        return 0;
    }

    @Override
    public Company update(Company company) {
        String SQL = "UPDATE SYS.CAPP_COMPANY SET COMPANY_NAME = :companyName WHERE COMPANY_ID = :companyId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("companyName", company.getCompanyName());
        parameterMap.put("companyId", company.getCompanyId());
        njdbc.update(SQL, parameterMap);
        return company;
    }

    @Override
    public void deleteById(long companyId){

        String SQL = "DELETE FROM SYS.CAPP_COMPANY WHERE COMPANY_ID = :companyId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("companyId", companyId);
        njdbc.update(SQL, parameterMap);

    }


}
