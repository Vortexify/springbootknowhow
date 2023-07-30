package hr.jura.sandbox.repository;
import hr.jura.sandbox.model.Employee;
import hr.jura.sandbox.model.EmploymentHistory;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmploymentHistoryRepository implements DataReporistory<EmploymentHistory> {

    private final NamedParameterJdbcTemplate njdbc;

    public EmploymentHistoryRepository(@Qualifier("namedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public EmploymentHistory findById(Long employmentId) {

        String SQL = "SELECT employee_id, workplace_id, start_date, end_date FROM SYS.CAPP_EMPLOYMENTHISTORY WHERE employment_id = :employmentId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employmentId", employmentId);

        List<EmploymentHistory> employmentList = njdbc.query(SQL, parameterMap, BeanPropertyRowMapper.newInstance(Employee.class));

        if(employmentList.size()>0) {
            return employmentList.get(0);
        }

        return null;
    }

    @Override
    public long save(EmploymentHistory employment) {
        String SQL = "INSERT INTO SYS.CAPP_EMPLOYMENTHISTORY (employee_id, workplace_id, start_date, end_date) VALUES (:employeeId, :workplaceId, :startDate, :endDate)";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeId", employment.getEmployeeId());
        parameterMap.put("workplaceId", employment.getWorkplaceId());
        parameterMap.put("StartDate", employment.getStartDate());
        parameterMap.put("EndDate", employment.getEndDate());
        njdbc.update(SQL,parameterMap);
        return 0;
    }

    @Override
    public EmploymentHistory update(EmploymentHistory employment) {
        String SQL = "UPDATE SYS.CAPP_EMPLOYMENTHISTORY SET employee_id = :employeeId, worplace_id = :workplaceId, start_date = :startDate, end_date = :endDate) WHERE EMPLOYMENT_ID = :employmentId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeId", employment.getEmployeeId());
        parameterMap.put("workplaceId", employment.getWorkplaceId());
        parameterMap.put("startDate", employment.getStartDate());
        parameterMap.put("endDate", employment.getEndDate());
        parameterMap.put("employmentId", employment.getEmploymentId());
        njdbc.update(SQL, parameterMap);
        return employment;
    }

    @Override
    public void deleteById(long employmentId){

        String SQL = "DELETE FROM SYS.CAPP_EMPLOYMENTHISTORY WHERE EMPLOYMENT_ID = :employmentId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employmentId", employmentId);
        njdbc.update(SQL, parameterMap);

    }


}
