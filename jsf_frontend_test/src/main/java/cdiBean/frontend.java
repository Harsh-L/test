/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBean;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author harsh
 */
@Named(value = "frontend")
@RequestScoped
public class frontend {

    ArrayList<String> days = new ArrayList<>();
    String day;
    
    /**
     * Creates a new instance of frontend
     */
    public frontend() {
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");   
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
        this.days = days;
    }

    public String getDay(Integer index) {
        return days.get(index);
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    
    
}
