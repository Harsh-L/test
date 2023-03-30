/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishingBean implements PublishingBeanLocal {
    
    @PersistenceContext(unitName = "PublishingPU")
    EntityManager em;

    @Override
    public void createCustomer(String firstName, String lastName) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        em.persist(c);
    }

    @Override
    public void updateCustomer(Integer custId, String firstName, String lastName) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, custId);
    c.setFirstName(firstName);
    c.setLastName(lastName);
    
    em.merge(c);
    
    }

    @Override
    public void removeCustomer(Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       Customer c = (Customer) em.find(Customer.class, custId);
 
       em.remove(c);
    }

    @Override
    public Collection<Customer> getAllCustomers() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     return em.createNamedQuery("Customer.findAll").getResultList();
    }

    @Override
    public Customer getCustomerById(Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return (Customer) em.find(Customer.class, custId);
    }

    @Override
    public Collection<Customer> getCustomerByFirstName(String firstName) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Collection<Customer> custs = em.createNamedQuery("Customer.findByFirstName")
               .setParameter("firstName", firstName)
               .getResultList();
       
       return custs;
    
    }

    @Override
    public Collection<Customer> getCustomerByLastName(String lastName) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Collection<Customer> custs = em.createNamedQuery("Customer.findByLastName")
               .setParameter("lastName", lastName)
               .getResultList();
    
     return custs;
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
          Customer c = (Customer) em.find(Customer.class, custId);
          Collection<Address> addresses = c.getAddressCollection();
          
          Address a = new Address();
          a.setStreet(street);
          a.setCity(city);
          a.setState(state);
          a.setZip(zip);
          a.setCustomer(c);
          
          addresses.add(a);
          c.setAddressCollection(addresses);
          
          em.persist(a);
          
          em.merge(c);
       
    
    }

    @Override
    public void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer custId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAddressOfCustomer(Integer aid, Integer custId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       Customer c = (Customer) em.find(Customer.class, custId);
       Address a = (Address) em.find(Address.class, aid);
       
       Collection<Address> addresses = c.getAddressCollection();
       
       if(addresses.contains(a))
       {
           addresses.remove(a);
           c.setAddressCollection(addresses);
           
           em.remove(a);
       }
    
    
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       Customer c = (Customer) em.find(Customer.class, custId);
 
    return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddresses(String city, String State) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscription(String title, String type) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s = new Subscription();
    s.setTitle(title);
    s.setType(type);
    
    em.persist(s);
    
    }

    @Override
    public void updateSubscription(Integer sid, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(Integer sid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s = (Subscription) em.find(Subscription.class, sid);
    
    em.remove(s);
    
    
    }

    @Override
    public void addSubscriptionsToCustomer(Integer custId, Collection<Integer> sids) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Customer c = (Customer) em.find(Customer.class, custId);
        Collection<Subscription> subs = c.getSubscriptionCollection();
    
        for(Integer sid : sids)
        {
            Subscription sub = (Subscription) em.find(Subscription.class,sid );
          
            if(!subs.contains(sub))
            {
                Collection<Customer> custs = sub.getCustomerCollection();
                subs.add(sub);
                custs.add(c);
                
                c.setSubscriptionCollection(subs);
                sub.setCustomerCollection(custs);
                
                em.merge(c);
                
                
            }
            
        }
    
    
    }

    @Override
    public void removeSubscriptionsFromCustomer(Integer custId, Collection<Integer> sids) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, custId);
        Collection<Subscription> subs = c.getSubscriptionCollection();
    
        for(Integer sid : sids)
        {
            Subscription sub = (Subscription) em.find(Subscription.class,sid );
          
            if(subs.contains(sub))
            {
                Collection<Customer> custs = sub.getCustomerCollection();
                subs.remove(sub);
                custs.remove(c);
                
                c.setSubscriptionCollection(subs);
                sub.setCustomerCollection(custs);
                
                em.merge(c);
                
                
            }
            
        }
    
    
    
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       Customer c = (Customer) em.find(Customer.class, custId);
 
       return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subscription getSubscriptionByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
