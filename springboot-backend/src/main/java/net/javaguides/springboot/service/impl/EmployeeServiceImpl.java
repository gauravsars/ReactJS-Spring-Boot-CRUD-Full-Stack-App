package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.mapper.EmployeeMapper;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findEmployeeById(employeeId);
       return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto updatedEmployee) {
       Employee employee =employeeRepository.findEmployeeById(updatedEmployee.getId());
       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());
       Employee updatedObject = employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(updatedObject);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
         employeeRepository.deleteById(employeeId);
    }


}
