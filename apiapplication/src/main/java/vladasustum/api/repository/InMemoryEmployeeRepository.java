package vladasustum.api.repository;

import org.springframework.stereotype.Repository;
import vladasustum.api.model.Employee;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryEmployeeRepository {

    private static  final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1,"John", "Smith", "johnsmith@email.com"));
        DATABASE.add(new Employee(2,"Alex", "Raymond", "alexraymond@email.com"));
        DATABASE.add(new Employee(3,"Brat", "Vlada", "bratvlada@email.com"));
    }


    public Employee addEmployee(Employee employee){
        DATABASE.add(employee);
        return employee;
    }


    public List<Employee> getAllEmployees(){
        return  List.copyOf(DATABASE);
    }


   public Employee findById(Integer id){
        return DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
    }


   public Employee updateEmployee(Integer id, Employee employee){

        DATABASE.set(id-1,employee);
        return employee;

    }


   public Boolean deleteById(Integer id){
        Employee employee = DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(employee);

        return Boolean.TRUE;
    }

}
