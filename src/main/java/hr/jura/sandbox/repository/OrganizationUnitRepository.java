package hr.jura.sandbox.repository;

import hr.jura.sandbox.model.Company;
import hr.jura.sandbox.model.OrganizationUnit;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrganizationUnitRepository implements DataReporistory<OrganizationUnit> {

    private final NamedParameterJdbcTemplate njdbc;

    public OrganizationUnitRepository(@Qualifier("namedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    @Override
    public long save(OrganizationUnit unit) {
        String SQL = "INSERT INTO SYS.CAPP_ORGANIZATIONUNIT (UNIT_NAME, COMPANY_ID) VALUES (:unitName, :companyId)";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeName", unit.getUnitName());
        parameterMap.put("companyId", unit.getCompanyId());
        njdbc.update(SQL,parameterMap);
        return 0;
    }

    @Override
    public OrganizationUnit findById(Long unitId) {
        String SQL = "SELECT UNIT_NAME, COMPANY_ID FROM SYS.CAPP_ORGANIZATIONUNIT WHERE UNIT_ID = :unitId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("unitId", unitId);
        List<OrganizationUnit> unitList = njdbc.query(SQL, parameterMap, BeanPropertyRowMapper.newInstance(Company.class));
        if(unitList.size()>0) {
            return unitList.get(0);
        }
        return null;
    }

    @Override
    public OrganizationUnit update(OrganizationUnit unit) {
        String SQL = "UPDATE SYS.CAPP_ORGANIZATIONUNIT SET UNIT_NAME = :unitName, COMPANY_ID = :companyId WHERE UNIT_ID = :unitId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("unitName", unit.getUnitName());
        parameterMap.put("companyId", unit.getCompanyId());
        parameterMap.put("unitId", unit.getUnitId());
        njdbc.update(SQL, parameterMap);
        return unit;
    }

    @Override
    public void deleteById(long unitId) {
        String SQL = "DELETE FROM SYS.CAPP_ORGANIZATIONUNIT WHERE UNIT_ID = :unitId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("unitId", unitId);
        njdbc.update(SQL, parameterMap);
    }
}

