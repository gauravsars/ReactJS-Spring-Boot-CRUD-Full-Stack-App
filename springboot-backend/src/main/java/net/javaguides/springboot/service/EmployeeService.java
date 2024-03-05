package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto) ;


    EmployeeDto getEmployeeById(Long employeeId);


}
