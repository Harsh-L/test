/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.CustLogic;
import entity.Cust;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@Named(value = "customerBean")
@RequestScoped
public class CustomerBean {
@EJB CustLogic cl;
    
   String phone; 

    public CustLogic getCl() {
        return cl;
    }

    public void setCl(CustLogic cl) {
        this.cl = cl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
   
    
    public String enterShop()
    {
     Cust c = cl.getCustomerByPhone(phone);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
     session.setAttribute("cid", c.getCid());
     return "index.jsf";
    }
    
}
