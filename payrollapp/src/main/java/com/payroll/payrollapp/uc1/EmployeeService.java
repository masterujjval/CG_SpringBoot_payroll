package com.payroll.payrollapp.uc1;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String addEmployee(Employee employee) {
        int result = employeeRepository.addEmployee(employee);
        return result > 0 ? "Employee added successfully!" : "Failed to add employee!";
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    public String updateEmployee(Long id, Employee employee) {
        int result = employeeRepository.updateEmployee(id, employee);
        return result > 0 ? "Employee updated successfully!" : "Failed to update employee!";
    }

    public String deleteEmployee(Long id) {
        int result = employeeRepository.deleteEmployee(id);
        return result > 0 ? "Employee deleted successfully!" : "Failed to delete employee!";
    }
}
