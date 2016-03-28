package com.javarush.test.NetCraker.OOP_Task.employee;

import java.util.ArrayList;

/**
 * Created by Аркадий on 10.10.2015.
 */
public class EmployeeMain
{
    public static void main(String[] args)
    {
        ArrayList<Employee> list = new ArrayList<>();
        Employee employee = new EmployeeImpl();
        Employee manager = new EmployeeImpl();
        Employee secondManager = new EmployeeImpl();
        Employee topManager = new EmployeeImpl();
        list.add(employee);
        list.add(manager);
        list.add(topManager);
        list.add(secondManager);
        employee.setFirstName("Kirill");
        employee.setLastName("Grasch");
        employee.setManager(manager);
        manager.setFirstName("Valera");
        manager.setLastName("Tramp");
        manager.setManager(secondManager);
        secondManager.setFirstName("John");
        secondManager.setLastName("Travolta");
        secondManager.setManager(topManager);
        topManager.setFirstName("Arkady");
        topManager.setLastName("Baranok");
        topManager.increaseSalary(4000);
        for(Employee e: list)
            System.out.println(e);
    }
}
