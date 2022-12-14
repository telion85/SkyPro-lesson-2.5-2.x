package site.telion.skypro_lesson_25_2x.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import site.telion.skypro_lesson_25_2x.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    Map<String, Employee> employees = new HashMap<>();

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp() {
        assertNotNull(employeeService);

        Employee employee1 = new Employee("Петр", "Швец", 1, 30_000.0);
        Employee employee2 = new Employee("Илья", "Евсеев", 3, 50_000.0);
        Employee employee3 = new Employee("Анна", "Фролова", 2, 35_000.0);
        Employee employee4 = new Employee("Ирина", "Антонова", 2, 70_000.0);
        employees.put(employee1.getFullName(), employee1);
        employees.put(employee2.getFullName(), employee2);
        employees.put(employee3.getFullName(), employee3);
        employees.put(employee4.getFullName(), employee4);
    }

    @Test
    public void shouldCorrectIfEmployeeWithMaxSalaryFrom2Department() {
        Mockito.when(employeeService.printList()).thenReturn(new ArrayList<>(employees.values()));
        Employee expected = departmentService.getEmployeeWithMaxSalary(2);
        Employee actual = new Employee("Ирина", "Антонова", 2, 70_000.0);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectIfEmployeeWithMinSalaryFrom2Department() {
        Mockito.when(employeeService.printList()).thenReturn(new ArrayList<>(employees.values()));
        Employee expected = departmentService.getEmployeeWithMinSalary(2);
        Employee actual = new Employee("Анна", "Фролова", 2, 35_000.0);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectWhenGetAllEmployeeByDepartment() {
        Mockito.when(employeeService.printList()).thenReturn(new ArrayList<>(employees.values()));
        List<Employee> expected = departmentService.getAllEmployeeByDepartment(2);

        Employee employee1 = new Employee("Ирина", "Антонова", 2, 70_000.0);
        Employee employee2 = new Employee("Анна", "Фролова", 2, 35_000.0);
        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectWhenGetAllEmployeeGroupByDepartment() {
        Mockito.when(employeeService.printList()).thenReturn((List<Employee>) new HashMap<Integer, List<Employee>>());



    }
}
