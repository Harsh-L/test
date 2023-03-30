/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import client.PublishingClient;
import entities.Customer;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "customer")
@RequestScoped
public class CustomerBean {
    
    PublishingClient pc;
    Response res;
    
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcustomers;
    
    int custID;
    String fname;
    String lname;
    
    

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
        pc = new PublishingClient();
        customers = new ArrayList<Customer>();
        gcustomers = new GenericType<Collection<Customer>>(){};
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Collection<Customer> getCustomers() {
        res = pc.getCustomers(Response.class);
        Collection<Customer> customers = res.readEntity(gcustomers);
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
    
    public String add(){
        pc.addCustomer(fname, lname);
        return "customerList.jsf";
    }
    
    
    
}
