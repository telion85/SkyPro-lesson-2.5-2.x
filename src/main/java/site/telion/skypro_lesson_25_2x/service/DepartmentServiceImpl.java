package site.telion.skypro_lesson_25_2x.service;

import org.springframework.stereotype.Service;
import site.telion.skypro_lesson_25_2x.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.printList().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.printList().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> getAllEmployeeByDepartment(Integer departmentId) {
        return employeeService.printList().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeeGroupByDepartment() {
        return employeeService.printList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
