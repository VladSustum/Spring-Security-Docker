package vladasustum.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vladasustum.api.model.Employee;
@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee,Integer> {

}
