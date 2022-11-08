package service;

import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 1:32 PM
    
    ProjectName: Bai13
*/public class EmployeeManager {
    private Map<String, Employee> employees;

    public EmployeeManager() {
        this.employees = new HashMap<>();
    }

    //
    public void insert(Employee employee) {
        this.employees.put(employee.getId(), employee);
    }

    // findByID
    public Employee findById(String id) {
        return this.employees.entrySet().stream()
                .filter(o -> o.getKey().equals(id)).findFirst().get().getValue();
//                .map(Map.Entry::getValue).findFirst().orElse(null);
    }


    //delete by id
    public boolean deleteById(String id) {
        Employee employee = this.findById(id);
        if (employee == null) {
            return false;
        } else {
            this.employees.remove(id);
            return true;
        }
    }

    // find by type
    public List<Employee> findByType(int type) {
        return this.employees.entrySet().stream().filter(o -> {
            if (type == 0) {
                return o.getValue() instanceof Experience;
            }
            if (type == 1) {
                return o.getValue() instanceof Fresher;
            }
            if (type == 2) {
                return o.getValue() instanceof Intern;
            }
            return false;
        }).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    // fildAll
    public List<Employee> findAll() {
        return this.employees.entrySet().stream()
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
