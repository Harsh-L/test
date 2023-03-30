/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import entities.Address;
import entities.Customer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class PublishingBean implements PublishingBeanLocal {
    
    @PersistenceContext(unitName = "PublishingPU")
    EntityManager em;

    @Override
    public void addCustomer(String fname, String lname) {
        Customer c = new Customer();
        c.setFirstName(fname);
        c.setLastName(lname);
        
        em.persist(c);
    }

    @Override
    public void updateCustomer(Integer cid, String fname, String lname) {
        Customer c = em.find(Customer.class, cid);
        
        c.setFirstName(fname);
        c.setLastName(lname);
        
        em.merge(c);
    }

    @Override
    public void removeCustomer(Integer cid) {
        Customer c = em.find(Customer.class, cid);
        em.remove(c);
    }

    @Override
    public Collection<Customer> getCustomers() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addAddress(String street, String state, String city, String zip, Integer cid) {
        Customer c = em.find(Customer.class, cid);
        Collection<Address> addresses = c.getAddressCollection();
        
        Address a = new Address();
        a.setStreet(street);
        a.setState(state);
        a.setCity(city);
        a.setZip(zip);
        a.setCustomer(c);
        
        addresses.add(a);
        c.setAddressCollection(addresses);
        
        em.persist(a);
        em.merge(c);
    }

    @Override
    public void updateAddress(Integer aid, String street, String state, String city, String zip, Integer cid) {
        Address a = em.find(Address.class, aid);
        
        Customer c = em.find(Customer.class, cid);
        Collection<Address> addresses = c.getAddressCollection();
        
        a.setStreet(street);
        a.setState(state);
        a.setCity(city);
        a.setZip(zip);
        a.setCustomer(c);
        
        c.setAddressCollection(addresses);
        em.merge(a);
        
    }

    @Override
    public void removeAddress(Integer aid, Integer cid) {
        Address a = em.find(Address.class, aid);
        
        Customer c = em.find(Customer.class, cid);
        Collection<Address> addresses = c.getAddressCollection();
        
        if(addresses.contains(a)) {
            em.remove(a);
            addresses.remove(a);
            c.setAddressCollection(addresses);
        }
    }

    @Override
    public Collection<Address> getAddressByCustomer(Integer cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
