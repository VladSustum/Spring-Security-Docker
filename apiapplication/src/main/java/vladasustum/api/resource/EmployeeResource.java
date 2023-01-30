package vladasustum.api.resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vladasustum.api.model.Employee;
import vladasustum.api.service.EmployeeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "mySQLEmployeeService")EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
//        employee.setId(employeeService.getAllEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id")Integer id){

        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")Integer id,@RequestBody Employee employee){

      return   ResponseEntity.ok(employeeService.updateEmployee(id,employee));
    }


    protected static URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}
