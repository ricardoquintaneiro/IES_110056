package ex1.multilayer.service;

import ex1.multilayer.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee Employee);

    Employee getEmployeeById(Long EmployeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee Employee);

    void deleteEmployee(Long EmployeeId);

    Employee getEmployeeByEmail(String email);
}
