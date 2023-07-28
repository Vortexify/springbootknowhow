package hr.jura.sandbox.repository;

import hr.jura.sandbox.model.Employee;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements DataReporistory<Employee>{

    private final NamedParameterJdbcTemplate njdbc;

    public EmployeeRepository(@Qualifier("namedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public Employee findById(Long employeeId) {

        String SQL = "SELECT employee_id, employee_name FROM SYS.CAPP_EMPLOYEE WHERE employee_id = :employeeId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeId", employeeId);

        List<Employee> employeeList = njdbc.query(SQL, parameterMap, BeanPropertyRowMapper.newInstance(Employee.class));

        if(employeeList.size()>0) {
            return employeeList.get(0);
        }

        return null;
    }

    @Override
    public long save(Employee employee) {
        String SQL = "INSERT INTO SYS.CAPP_EMPLOYEE (EMPLOYEE_NAME) VALUES (:employeeName)";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeName", employee.getEmployeeName());
        njdbc.update(SQL,parameterMap);
        return 0;
    }

    @Override
    public Employee update(Employee employee) {
        String SQL = "UPDATE SYS.CAPP_EMPLOYEE SET EMPLOYEE_NAME = :employeeName WHERE EMPLOYEE_ID = :employeeId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeName", employee.getEmployeeName());
        parameterMap.put("employeeId", employee.getEmployeeId());
        njdbc.update(SQL, parameterMap);
        return employee;
    }

    @Override
    public void deleteById(long employeeId){

        String SQL = "DELETE FROM SYS.CAPP_EMPLOYEE WHERE EMPLOYEE_ID = :employeeId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("employeeId", employeeId);
        njdbc.update(SQL, parameterMap);

    }


}