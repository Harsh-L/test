/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MDB;

import Ejb.empEJBLocal;
import WEBEntity.Employeetb;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Bhatt Jaimin
 */
@MessageDriven(mappedName = "myEmpQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MDBLogic implements MessageListener{

    @EJB empEJBLocal e;
    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage txtmsg =(TextMessage) msg;
            String newmsg = txtmsg.getText();
            
            String Operation = newmsg.split(";")[0];
            switch(Operation){
                
                case "insert":{
                    Employeetb emp = getdataFromMsg(newmsg);
                    e.addEmployee(emp);
                    break;
                }
                case "update":{
                    Employeetb emp = getdataFromMsg(newmsg);
                    int id=Integer.parseInt(newmsg.split(";")[7].split(":")[1]); 
                    emp.setEmpid(id);
                System.out.print("address : "+newmsg.split(";")[6].split(":")[1]); 
                
                    e.updateEmployee(emp);
                    break;
                }
                case "delete":{
                   // Employeetb emp = getdataFromMsg(newmsg);
                   String empid = newmsg.split(":")[1]; 
                   int id=Integer.parseInt(empid);
                   System.out.println(id);
                   e.delete(id);
                    break;
                }
                default:{
                    break;
                }
                              
            }
            
            System.out.println(txtmsg.getText());
        }catch(Exception ex){
            
        }
    }
    
    public Employeetb getdataFromMsg(String newmsg){
            Employeetb emp = new Employeetb();
                emp.setName(newmsg.split(";")[2].split(":")[1]);
                System.out.print("name : "+newmsg.split(";")[2].split(":")[1]);
                
                emp.setEmail(newmsg.split(";")[3].split(":")[1]);
                System.out.print("email : "+newmsg.split(";")[3].split(":")[1]);
                
                int phone= Integer.parseInt(newmsg.split(";")[4].split(":")[1]);
                System.out.print("phone : "+newmsg.split(";")[4].split(":")[1]);
                emp.setPhone(phone);
                
                emp.setDesignation(newmsg.split(";")[5].split(":")[1]);
                System.out.print("designation : "+newmsg.split(";")[5].split(":")[1]);
                
                emp.setAddress(newmsg.split(";")[6].split(":")[1]);
                System.out.print("address : "+newmsg.split(";")[6].split(":")[1]); 
                
                
                return emp;
                
    }
    
}
