package ex1.multilayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ex1.multilayer.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     
  Employee findByEmail(String email);
   
}
