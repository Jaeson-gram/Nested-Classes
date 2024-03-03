package com.Relearn.AnonymousClass;

import com.Relearn.NestedClass.Employee;
import com.Relearn.EmployeeComparator;
import com.Relearn.InnerClass.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10002, "Maggie", 2019, "Amazon"),
                new StoreEmployee(10025, "Anita", 2022, "Verizon"),
                new StoreEmployee(10029, "Jey", 2023, "Samsung"),
                new StoreEmployee(10102, "Eddie", 2021, "Netflix"),
                new StoreEmployee(11415, "Josh", 2024, "KFC")
        ));

        //running our three comparators
        var c0 = new EmployeeComparator<StoreEmployee>(); // the top level class
        var c1 = new Employee.EmployeeComparator<StoreEmployee>(); // the nested class
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>(); // the inner class

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);

        //Using a local class
        class NameSort<T> implements Comparator<StoreEmployee>{
            @Override
            public int compare(StoreEmployee employee1, StoreEmployee employee2) {
//                return 0;
                return employee1.getName().compareTo(employee2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        sortIt(storeEmployees, c3); //our local class

        //Using an anonymous class
        /*
            an anonymous class is instantiated and assigned in a single statement
            the 'new' keyword is followed by a superclass of the anonymous class or the interface the anonymous class will implement. as below
            ->
         */

        var c4 = new Comparator<StoreEmployee>(){ //an anonymous class that implements the Comparator interface
            @Override
            public int compare(StoreEmployee employee1, StoreEmployee employee2) {
//                return 0;
                return employee1.getName().compareTo(employee2.getName());
            }
        };

        sortIt(storeEmployees, c4); // our anonymous class

    }


    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator){

        System.out.println("Sorting with comparator: " + comparator.toString());

        list.sort(comparator);

        for (var employee : list){
            System.out.println(employee);
        }
    }
}
