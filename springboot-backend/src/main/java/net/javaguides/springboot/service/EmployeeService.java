package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto) ;


    EmployeeDto getEmployeeById(Long employeeId);

     List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(EmployeeDto employee);

    void deleteEmployee(Long employeeId);


}
