package vladasustum.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vladasustum.api.model.Employee;
import vladasustum.api.repository.JpaEmployeeRepository;
import vladasustum.api.service.EmployeeService;

import java.util.List;
@Service
@RequiredArgsConstructor
@Qualifier(value = "mySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee toEdit = jpaEmployeeRepository.findById(id).get();

        toEdit.setEmail(employee.getEmail());
        toEdit.setFirstName(employee.getFirstName());
        toEdit.setLastName(employee.getLastName());

        return jpaEmployeeRepository.save(toEdit);

    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
