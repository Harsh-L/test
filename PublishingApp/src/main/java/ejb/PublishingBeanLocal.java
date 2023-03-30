/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishingBeanLocal {
    
   //=== CRUD and Fetch Operations  
    
   // Customer CRUD
    
    void createCustomer(String firstName, String lastName);
    void updateCustomer(Integer custId, String firstName, String lastName);
    void removeCustomer(Integer custId);
  // Customer Fetch
    Collection<Customer> getAllCustomers();
    Customer getCustomerById(Integer custId);
    Collection<Customer>  getCustomerByFirstName(String firstName);
    Collection<Customer>  getCustomerByLastName(String lastName);
    
    // Address
        // CRUD
    void addAddressToCustomer(String street, String city, String state, String zip, Integer custId);
    void updateAddressToCustomer( Integer aid, String street, String city, String state, String zip, Integer custId);
        void removeAddressOfCustomer(Integer aid, Integer custId);
    // Fetch
        
      Collection<Address> getAddressesOfCustomer(Integer custId);
      Collection<Address> getAddressesByCity(String city);
      Collection<Address> getAddressesByState(String state);
      Collection<Address> getAddressesByZip(String zip);
      Collection<Address> getAddresses(String city, String State);
      
      // Subscription
        // CRUD
      void addSubscription(String title, String type);
      void updateSubscription(Integer sid, String title, String type);
      void removeSubscription(Integer sid);
      void addSubscriptionsToCustomer(Integer custId, Collection<Integer> sids);
      void removeSubscriptionsFromCustomer(Integer custId, Collection<Integer> sids);
      
      // Fetch
      
      Collection<Subscription> getSubscriptionsOfCustomer(Integer custId);
      Collection<Subscription> getAllSubscriptions();
      Collection<Subscription> getAllSubscriptionsByType(String type);
      Subscription getSubscriptionByTitle(String title);
      
      
     
    
    
    
    
    
    
    
}
