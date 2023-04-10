/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Customer;
import entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ritesh
 */
@Local
public interface BusinessLogicLocal {

    //customer login
    public boolean loginUser(int userid);

    //product operations
    public List<Product> getProducts();
    
    public Product getProduct(int pid);

    //get customer
    public Customer getCustomer(int userid);
    
    //order operations
    public boolean makeOrder(int custid,int grossTotal);
}
