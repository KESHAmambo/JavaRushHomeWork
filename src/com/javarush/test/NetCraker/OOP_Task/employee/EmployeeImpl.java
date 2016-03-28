package com.javarush.test.NetCraker.OOP_Task.employee;

/**
 * Created by Аркадий on 10.10.2015.
 */
public class EmployeeImpl implements Employee
{
    private String firstName;
    private String lastName;
    private int salary = 1000;
    private Employee manager;

    public EmployeeImpl() {}

    @Override
    public int getSalary()
    {
        return salary;
    }

    @Override
    public void increaseSalary(int value)
    {
        salary += value;
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    @Override
    public void setManager(Employee manager)
    {
        this.manager = manager;
    }

    @Override
    public String getManagerName()
    {
        if(manager == null) {
            return "No manager";
        }
        return manager.getFullName();
    }

    @Override
    public Employee getTopManager()
    {
        if(getManagerName().equals("No manager"))
            return this;
        return manager.getTopManager();
    }
}
