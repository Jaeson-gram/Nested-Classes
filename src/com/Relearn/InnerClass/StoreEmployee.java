package com.Relearn.InnerClass;

import com.Relearn.NestedClass.Employee;

import java.util.Comparator;

public class StoreEmployee extends Employee {

    private String store;

    public StoreEmployee() {

    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
//        return super.toString();
        return "%-8s%s".formatted(store, super.toString());
    }

    //-> Inner Class
    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee employee1, StoreEmployee employee2) {
//            return 0;
            int result = employee1.store.compareTo(employee2.store); // ->

            if (result == 0){
                return new Employee.EmployeeComparator<>("year started").compare(employee1, employee2);
                //if they work at the same store ( result = 0), then sort them by year started
                //i.e. sort by store, then year started
            }

            return result;
        }
    }

}
