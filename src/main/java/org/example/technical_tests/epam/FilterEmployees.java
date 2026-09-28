package org.example.technical_tests.epam;

import org.example.technical_tests.epam.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class FilterEmployees {

    //TODO:: Do the following tasks
    //TODO:: 1. Filter All employees where age are greater than 30
    //TODO:: 2. Sort the result By name
    //TODO:: 3. Return the result as a new List without repeated elements


    public static void main(String[] args) {

        Set<Employee> result = filterEmployees(Employee.getEmployees());

        System.out.println("Results: ");
        result.forEach(System.out::println);
    }

    public static Set<Employee> filterEmployees(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getAge() > 30) // Filter by Age
                .sorted(Comparator.comparing(Employee::getName).reversed()) // Sorted by name
                .collect(Collectors.toCollection(LinkedHashSet::new)); // Return Unique elements
    }
}
