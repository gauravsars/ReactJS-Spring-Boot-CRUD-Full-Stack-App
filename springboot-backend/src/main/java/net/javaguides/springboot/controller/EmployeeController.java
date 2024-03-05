package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee Rest API.

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDto);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getEmployeeById() {
        List<EmployeeDto> employeeDto = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDto);
    }


    @PostMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employeeDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }


}
