package ex1.multilayer.service.impl;

import lombok.AllArgsConstructor;
import ex1.multilayer.entity.Employee;
import ex1.multilayer.repository.EmployeeRepository;
import ex1.multilayer.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
       Employee employee = employeeRepository.findByEmail(email);
        return employee;
    }
}