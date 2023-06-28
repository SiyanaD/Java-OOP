package EncapsulationLabJune.P02SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    //salary: double
    private double salary;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        //викаме стария конструктор
       this(firstName,lastName,age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void increaseSalary(double bonus){
        if (this.getAge()<30){
            this.setSalary(this.getSalary()+(this.getSalary()*bonus)/200);
        }
        else {
            this.setSalary(this.getSalary()+(this.getSalary()*bonus)/100);

    }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",this.getFirstName(),this.getLastName(),
                new DecimalFormat("#.0#####").format(this.getSalary()));
    }
}
