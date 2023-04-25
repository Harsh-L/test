/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import Ejb.empEJBLocal;
import MDB.MySender;
import WEBEntity.Employeetb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author Bhatt Jaimin
 */
@Named(value = "managedBean")
@SessionScoped
public class managedBean implements Serializable {

    /**
     * Creates a new instance of managedBean
     */
    Employeetb emp;

    public Employeetb getEmp() {
        return emp;
    }

    public void setEmp(Employeetb emp) {
        this.emp = emp;
    }
    MySender sender;
    String empname;
    String email;
    String designation;
    String address;

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Integer phoneno) {
        this.phoneno = phoneno;
    }
    Integer phoneno;
    @EJB empEJBLocal db;
    public managedBean() throws NamingException, JMSException {
        sender= new MySender();
         this.emp=new Employeetb();
    }
    public List<Employeetb> Display(){
        return db.getall();
    }
    
    public  String insert() throws JMSException{
        String msg="insert;employeetb;empname:"+emp.getName()+";email:"+emp.getEmail()+";phoneno:"+emp.getPhone()+";designation:"+emp.getDesignation()+";address:"+emp.getAddress();
        sender.sendMessage(msg);
        this.emp=new Employeetb();
        return "index.xhtml";
    }
     public  String update() throws JMSException{
        String msg="update;employeetb;empname:"+emp.getName()+";email:"+emp.getEmail()+";phoneno:"+emp.getPhone()+";designation:"+emp.getDesignation()+";address:"+emp.getAddress()+";empid:"+emp.getEmpid();
        sender.sendMessage(msg);
         this.emp=new Employeetb();
        return "index.xhtml";
    }
     public  String delete(int empid) throws JMSException{
        String msg="delete;employeetb:"+empid;
        sender.sendMessage(msg);
        return "index.xhtml";
    }
    
     public String loadUpdate(Employeetb exsistingEmp){
         this.emp=exsistingEmp;
         return "update.xhtml";
     }
     
}
