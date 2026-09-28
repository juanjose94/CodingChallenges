package org.example.technical_tests.epam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Employee {

    private long id;
    private String name;
    private int age;

    public static List<Employee> getEmployees(){
        Employee employee_1 = Employee.builder().id(1L).age(25).name("jorgito").build();
        Employee employee_2 = Employee.builder().id(2L).age(35).name("juan").build();
        Employee employee_3 = Employee.builder().id(3L).age(45).name("mendez").build();
        Employee employee_4 = Employee.builder().id(4L).age(44).name("Zapata").build();
        Employee employee_5 = Employee.builder().id(4L).age(44).name("Zapata").build();
        return List.of(employee_1, employee_2, employee_3, employee_4,employee_5);
    }
}
