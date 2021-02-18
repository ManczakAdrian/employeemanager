package pl.manczak.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manczak.employeemanager.exception.UserNotFoundEception;
import pl.manczak.employeemanager.model.Employee;
import pl.manczak.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee (Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);


    }
    public List<Employee> findAllEmployees(){
    return employeeRepo.findAll();

    }
    public Employee updateEmployee (Employee employee){
    return employeeRepo.save(employee);

    }

    public Employee findEmployeeById(Long id){
    return employeeRepo.findEmployeeById(id)
            .orElseThrow(()->new UserNotFoundEception("User by id"+id+"was not found"));
    }


    public void deleteEmployee (Long id){
    employeeRepo.deleteEmployeeById(id);
    }


}
