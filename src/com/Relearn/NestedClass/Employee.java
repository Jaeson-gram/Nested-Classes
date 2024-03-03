package com.Relearn.NestedClass;

import java.util.Comparator;

public class Employee {

    // -> Nested Class
    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
//      a (Employee) comparator that accepts any type that is a child class of Employee, or Employee itself

        private String sortType;

        public EmployeeComparator() {
            this.sortType = "name";
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee employee1, Employee employee2) {
//        return 0;

            if (sortType.equalsIgnoreCase("year started"))
                return employee1.yearStarted - employee2.yearStarted; // sort by year started -> this compiles bc our Comparator class is nested inside Employee

            else if (sortType.equalsIgnoreCase("employee id"))
                return employee1.employeeId - employee2.employeeId; // sort by employeeId -> this doesn't compile bc our Comparator class is nested inside Employee

            else
                return employee1.name.compareTo(employee2.name); //sort by name

        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
//        return super.toString();
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
