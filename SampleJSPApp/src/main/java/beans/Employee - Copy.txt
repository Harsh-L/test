package beans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.util.Hashtable;

/**
 *
 * @author root
 */
public class Employee implements Serializable {
    
    String firstName;
    String lastName;
    Double salary;
    Hashtable errors;

    public Employee() {
        firstName="";
        lastName="";
        salary=0.0;
        errors=new Hashtable();
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean validate()
    {
    boolean allOK=true;
    
    if(firstName.equals(""))
    {
        errors.put("firstName","First Name can not be blank");
        allOK=false;
        firstName="";
    }
     if(lastName.equals(""))
    {
        errors.put("lastName","Last Name can not be blank");
        allOK=false;
        lastName="";
    }
    
    
    
    return allOK;
    }
    
    
    public String getError(String s)
    {
        String err = (String) errors.get(s.trim());
          
        return (err==null)?"":err;
    }
    
    
    
    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + '}';
    }
    
    
    
    
}
