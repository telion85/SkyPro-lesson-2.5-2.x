package site.telion.skypro_lesson_25_2x.service;

import site.telion.skypro_lesson_25_2x.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    List<Employee> getAllEmployeeByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployeeGroupByDepartment();
}
