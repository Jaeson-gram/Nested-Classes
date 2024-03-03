package com.Relearn;

import com.Relearn.InnerClass.StoreEmployee;
import com.Relearn.NestedClass.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Eddie", 2021),
                new Employee(10014, "Fred", 2019),
                new Employee(10021, "Richard", 2021),
                new Employee(10004, "Rita", 2023),
                new Employee(10003, "Irvin", 2022)
        ));

//        var comparator = new EmployeeComparator<>(); -> unnecessary to have it in a variable
//        employees.sort(new EmployeeComparator<>());

//        var comparator = new Employee.EmployeeComparator<>(); -> unnecessary to have it in a variable
        employees.sort(new Employee.EmployeeComparator<>("employee id"));



        for (Employee employee : employees){
            System.out.println(employee);
        }

        System.out.println("-".repeat(35));
        System.out.println("Store Members:");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10002, "Maggie", 2019, "Amazon"),
                new StoreEmployee(10025, "Anita", 2022, "Verizon"),
                new StoreEmployee(10029, "Jey", 2023, "Samsung"),
                new StoreEmployee(10102, "Eddie", 2021, "Netflix"),
                new StoreEmployee(11415, "Josh", 2024, "KFC")
                ));

//        var comparator = new Employee.EmployeeComparator<>(); -> nested classes are inherited by subclasses. So this comparator is actually from the Employee class

        //how to instantiate an inner class
        /*
            to create an instance of an inner class, you must first create an instance of the Enclosing Class.
                    var genericEmloyee = new StoreEmployee();
                    var comparator = genericEmloyee.new StoreComparator();
                    ||
                    var comparator = new StoreEmployee().new StoreComparator();

         */

        var comparator = new StoreEmployee().new StoreComparator();
        storeEmployees.sort(comparator);

        for (Employee employee : storeEmployees){
            System.out.println(employee);
        }

        System.out.println("---".repeat(15));
        System.out.println("With Pig Latin names:");

        addPigLatinName(storeEmployees);


    }

    public static void addPigLatinName(List<? extends StoreEmployee> list){

        final String defaultLastName = "Piggy"; // has to be final
        // Local Class
        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
//                return super.toString();
                return originalInstance.toString() + " - " + pigLatinName + " " + defaultLastName;
            }

            /* Local Class
                Why create a class this way?
                I might want to create a class for just one purpose, and nothing else
                not wanting to add it to my library of classes, or wanting any other class to inherit it.

                If I want that kind of class, like this one that just simply makes a pig-latin version of a name
                then a local class is a good idea
             */

            @Override
            public int compareTo(DecoratedEmployee demployee) {
//                return 0;
                return pigLatinName.compareTo(demployee.pigLatinName);
            }


        }

        List<DecoratedEmployee> decoratedEmployees = new ArrayList<>(list.size());

        for (var employee : list){
            String name = employee.getName();   // -> get the name so we can use it
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";    //-> create the pig-latin version
            decoratedEmployees.add(new DecoratedEmployee(pigLatin, employee));  //-> add it to a new instance of the local class. passing the pig-latin and the employee
        }

        decoratedEmployees.sort(null); //  == decoratedEmployees.sort(Comparator.naturalOrder());
        // when we make it null, and we use a Comparable, it uses the default sort the class's comparable implements

//        defaultLastName = "sss";

        for (var DeEmployee : decoratedEmployees){
            System.out.println(DeEmployee);
//            System.out.println(DeEmployee.originalInstance.getName() + " " + DeEmployee.pigLatinName);
        }
    }
}

