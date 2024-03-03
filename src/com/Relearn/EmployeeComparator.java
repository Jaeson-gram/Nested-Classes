package com.Relearn;

import com.Relearn.NestedClass.Employee;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee> implements Comparator<Employee>{
// a (Employee) comparator that accepts any type that is a child class of Employee, or Employee itself


    @Override
    public int compare(Employee employee1, Employee employee2) {
//        return 0;

//        return employee1.yearStarted - employee2.yearStarted; // sort by year started -> this doesn't compile bc our yearStarted is private
//        return employee1.employeeId - employee2.employeeId; // sort by year started -> this doesn't compile bc our employeeId is private

        return employee1.getName().compareTo(employee2.getName()); //sort by name

    }
}
