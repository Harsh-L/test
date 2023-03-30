/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import entities.Address;
import entities.Customer;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface PublishingBeanLocal {
    
    public void addCustomer(String fname, String lname);
    public void updateCustomer(Integer cid, String fname, String lname);
    public void removeCustomer(Integer cid);
    Collection<Customer> getCustomers();
    
    public void addAddress(String street, String state, String city, String zip, Integer cid);
    public void updateAddress(Integer aid, String street, String state, String city, String zip, Integer cid);
    public void removeAddress(Integer aid, Integer cid);
    Collection<Address> getAddressByCustomer(Integer cid);
}
