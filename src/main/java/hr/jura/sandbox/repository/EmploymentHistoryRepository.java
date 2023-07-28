package hr.jura.sandbox.repository;
import hr.jura.sandbox.model.EmploymentHistory;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentHistoryRepository extends CrudRepository<EmploymentHistory, Long> {

}
