/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import bean.PurchasedProducts;
import entity.Billdetail;
import entity.Billmaster;
import entity.Cust;
import entity.Products;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DataLogic {

    @PersistenceContext(unitName = "billpu")
    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;

    public Collection<Products> getAllProducts()
    {
        return em.createNamedQuery("Products.findAll").getResultList();
    }
    
    public int getProductCount()
    {
        int count=0;
      Collection<Products> prs=  em.createNamedQuery("Products.findAll").getResultList();
    for(Products p: prs)
    {
        count++;
        
    }
      return count;
    }
    
    public Billmaster getBillMaster(int cid)
    {
        Billmaster bm=null;
      //  Cust c = em.find(Cust.class, cid);
     Collection<Billmaster> bms=   em.createNamedQuery("Billmaster.findAll").getResultList();
    
     for(Billmaster bm1 : bms)
     {
        bm=bm1;
        //break;
     }
     return bm;
    }
    
    public void createBillMaster(int cid, double grandtotal)
    {
        Cust c = (Cust) em.find(Cust.class,cid);
        Collection<Billmaster> bc = c.getBillmasterCollection();
        Billmaster bm = new Billmaster();
        bm.setCid(c);
        bm.setGrandtotal(grandtotal);
        //bm.setGrandtotal(grandtotal);
        bc.add(bm);
        c.setBillmasterCollection(bc);
        em.persist(bm);
        em.merge(c);
        
    }
    
   
    
    public void updateBillMaster(int bid)
    {
        double grandtotal=0;
        Billmaster bm = (Billmaster) em.find(Billmaster.class, bid);
        Collection<Billdetail> bds = bm.getBilldetailCollection();
        for(Billdetail bd : bds)
        {
            grandtotal+=bd.getTotal();
        }
        
        bm.setGrandtotal(grandtotal);
        
        em.merge(bm);
        
    }
    

    
    public Cust getCustomer(int cid)
    {
        return (Cust)em.find(Cust.class, cid);
    }
    public void insertBillDetail(int billid,Collection<PurchasedProducts> ppd)
    {
        Billmaster bm = (Billmaster) em.find(Billmaster.class, billid);
        Collection<Billdetail> bds = bm.getBilldetailCollection();
        
        for(PurchasedProducts pp : ppd)
        {
            Products p = (Products) em.find(Products.class, pp.getPid());
             
                Billdetail bd = new Billdetail();
                bd.setPid(p);
                bd.setBid(bm);
                bd.setQuantity(pp.getQuantity());
                bd.setTotal(pp.getTotal());
                
                bds.add(bd);
                p.setBilldetailCollection(bds);
                bm.setBilldetailCollection(bds);
                em.persist(bd);
                em.merge(p);
                em.merge(bm);
                
            
        }
        
       
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    
    
}
