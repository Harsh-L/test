/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Billdetail;
import entity.Billmaster;
import entity.Customer;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ritesh
 */
@Stateless
public class BusinessLogic implements BusinessLogicLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    
    @EJB
    CartBeanLocal cart;

    @Override
    public boolean loginUser(int userid) {
        Customer customer = em.find(Customer.class, userid);
        return customer != null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        if (em == null) {
            System.err.println("\n\n\nEM is NULL\n\n\n");
        }
        if (em.createNamedQuery("Product.findAll").getResultList() != null) {
            System.out.println("\n\n\nproducts::::\n\n\n");
            System.err.println(products);
            products = em.createNamedQuery("Product.findAll").getResultList();
        }
        return products;
    }

    @Override
    public Customer getCustomer(int userid) {
        return em.find(Customer.class, userid);
    }

    @Override
    public Product getProduct(int pid) {
        return em.find(Product.class, pid);
    }

    @Override
    public boolean makeOrder(int custid, int grossTotal) {
        Billmaster billmaster = new Billmaster();
        Customer customer = getCustomer(custid);
        if (customer != null) {
            billmaster.setCustid(customer);
            billmaster.setGrosstotal(grossTotal);
            em.persist(billmaster);
            em.flush();
            em.refresh(billmaster);
            List<CartItem> cartItems=cart.getCartItems();
            for(CartItem item:cartItems)
            {
                Billdetail billdetail=new Billdetail();
                billdetail.setBillid(billmaster);
                Product product=getProduct(item.getProductid());
                billdetail.setProductid(product);
                billdetail.setQty(item.getQuantity());
                billdetail.setTotal(item.getTotal());
                em.persist(billdetail);
            }
            cart.clearCart();
            return true;
        } else {
            return false;
        }
    }
}
