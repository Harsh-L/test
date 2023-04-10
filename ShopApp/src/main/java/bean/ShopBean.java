/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.DataLogic;
import entity.Billmaster;
import entity.Cust;
import entity.Products;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author root
 */
@Named(value = "shopBean")
@SessionScoped
public class ShopBean implements Serializable{
    @EJB DataLogic dl;
    
    Cust c;
    int prcount;// = dl.getAllProducts().size();
    int cid;
    int billid;
    Collection<Products> products;
    Collection<PurchasedProducts> cartProducts;
    double grandtotal=0.0;
    Collection<Integer> quantity;
    Hashtable<String, Integer> qty;

    public Hashtable getQty() {
        return qty;
    }

    public void setQty(Hashtable qty) {
        this.qty = qty;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }

    
    public DataLogic getDl() {
        return dl;
    }

    public void setDl(DataLogic dl) {
        this.dl = dl;
    }

    public int getPrcount() {
      
        return prcount;
    }

    public void setPrcount(int prcount) {
        this.prcount = prcount;
    }

    public Collection<PurchasedProducts> getCartProducts() {
     
       
           
        
        return cartProducts;
    }

    public void setCartProducts(Collection<PurchasedProducts> cartProducts) {
        this.cartProducts = cartProducts;
    }
    

    public Cust getC() {
        return dl.getCustomer(cid);
    }

    public void setC(Cust c) {
        this.c = c;
    }

    public int getCid() {
        
        return cid;
    }

    public void setCustid(int cid) {
        this.cid = cid;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public Collection<Products> getProducts() {
        try{
     prcount = dl.getProductCount();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
 //System.out.println("prcount = "+prcount);
  quantity= new ArrayList<>();
    // prcount = dl.getAllProducts().size();
     for(int i=1; i<=prcount; i++)
     {
         quantity.add(0);
     }
        return dl.getAllProducts();
    }

    public void setProducts(Collection<Products> products) {
        this.products = products;
    }

    public Collection<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Collection<Integer> quantity) {
        this.quantity = quantity;
    }
 

   

    /**
     * Creates a new instance of ShopBean
     */
 
 public ShopBean() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
     cid = Integer.parseInt(session.getAttribute("cid").toString());
   // System.out.println("prcount = "+prcount);
  // Collection<Products> prs = dl.getAllProducts();
  
    
    //c = dl.getCustomer(cid);
    }

   
   
 
 public String viewCart()
 {
     grandtotal=0;
      qty=new Hashtable<>();
     int counter=1;
 Iterator it = quantity.iterator();
     while(it.hasNext())
     {
         
         qty.put(String.valueOf(counter), Integer.parseInt(it.next().toString()));
         counter++;
     }
        
        int counters=1;
        System.out.println("Names :");
        cartProducts= new ArrayList<>();
       for(Products p: dl.getAllProducts())
       {
          // System.out.println("Name :"+p.getPname());
           int q= qty.get(String.valueOf(counters));
            System.out.println("quantity :"+q);
         // int q= (Integer)qty.get(String.valueOf(counters));
          if(q!=0){
           PurchasedProducts pp = new PurchasedProducts();
           pp.setCid(cid);
           pp.setPid(p.getPid());
           pp.setPname(p.getPname());
           pp.setRate(p.getRate());
           pp.setDiscount(p.getDiscount());
           pp.setQuantity(q);
           pp.setTotal(q*p.getRate()*(1-p.getDiscount()/100));
           grandtotal += pp.getTotal();
           cartProducts.add(pp);
          }
           counters++;
       }
   
     return "Bill.jsf";
 }
 
 public String generateBill()
 {
         int counter=1;
    dl.createBillMaster(cid,grandtotal);
     Billmaster bm = dl.getBillMaster(cid);
     Collection<Integer> pids = new ArrayList<>();
     Collection<Integer> pqty = new ArrayList<>();
     
     for(PurchasedProducts p : cartProducts)
     {
         pids.add(p.getPid());
         pqty.add(p.getQuantity());
     }
     
     
     
     dl.insertBillDetail(bm.getBid(), cartProducts);
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
     session.invalidate();
         return "done.jsf";
 }
 
 
 public String goBackToShopAtBill()
 {
     
     return "Bill.jsf";
 }
    
}
