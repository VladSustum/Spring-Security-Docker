package vladasustum.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vladasustum.api.model.Employee;
import vladasustum.api.repository.InMemoryEmployeeRepository;
import vladasustum.api.service.EmployeeService;

import java.util.List;
@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemory")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
     return inMemoryEmployeeRepository.addEmployee(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return inMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee( Integer id,Employee employee) {
       return inMemoryEmployeeRepository.updateEmployee(id,employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryEmployeeRepository.deleteById(id);
    }
}
