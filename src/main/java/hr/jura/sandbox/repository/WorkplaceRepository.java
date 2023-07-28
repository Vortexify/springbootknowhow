package hr.jura.sandbox.repository;

import hr.jura.sandbox.model.Workplace;
import hr.jura.sandbox.model.Workplace;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class WorkplaceRepository implements DataReporistory<Workplace> {

    private final NamedParameterJdbcTemplate njdbc;

    public WorkplaceRepository(@Qualifier("namedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public Workplace findById(Long workplaceId) {

        String SQL = "SELECT workplace_name, unit_id FROM SYS.CAPP_WORKPLACE WHERE workplace_id = :workplaceId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("workplaceId", workplaceId);

        List<Workplace> workplaceList = njdbc.query(SQL, parameterMap, BeanPropertyRowMapper.newInstance(Workplace.class));

        if(workplaceList.size()>0) {
            return workplaceList.get(0);
        }

        return null;
    }

    @Override
    public long save(Workplace workplace) {
        String SQL = "INSERT INTO SYS.CAPP_WORKPLACE (WORKPLACE_NAME) VALUES (:workplaceName, :unitId)";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("workplaceName", workplace.getWorkplaceName());
        parameterMap.put("unitId", workplace.getUnitId());
        njdbc.update(SQL,parameterMap);
        return 0;
    }

    @Override
    public Workplace update(Workplace workplace) {
        String SQL = "UPDATE SYS.CAPP_WORKPLACE SET WORKPLACE_NAME = :workplaceName, UNIT_ID = :unitId WHERE WORKPLACE_ID = :workplaceId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("workplaceName", workplace.getWorkplaceName());
        parameterMap.put("workplaceId", workplace.getWorkplaceId());
        parameterMap.put("unitId", workplace.getUnitId());
        njdbc.update(SQL, parameterMap);
        return workplace;
    }

    @Override
    public void deleteById(long workplaceId){

        String SQL = "DELETE FROM SYS.CAPP_WORKPLACE WHERE WORKPLACE_ID = :workplaceId";
        ParameterMap parameterMap = new ParameterMap();
        parameterMap.put("workplaceId", workplaceId);
        njdbc.update(SQL, parameterMap);

    }

}

