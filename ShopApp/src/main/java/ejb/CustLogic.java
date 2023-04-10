/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Cust;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CustLogic {
 @PersistenceContext(unitName = "billpu")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

  public Cust getCustomer(int cid)
    {
        return em.find(Cust.class, cid);
    }
 
 public Cust getCustomerByPhone(String phone)
 {
     Collection<Cust> c =  em.createNamedQuery("Cust.findByPhone").setParameter("phone", phone).getResultList();
     for(Cust c1 : c)
     {
         return c1;
     }
     return null;
 }
}
