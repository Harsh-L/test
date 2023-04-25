/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MDB;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Bhatt Jaimin
 */
public class MySender {
    InitialContext ctx;
    QueueConnectionFactory f;
    QueueConnection con;
    QueueSession ses;
    Queue q;
    QueueSender sender;
    TextMessage msg;
    public MySender() throws NamingException, JMSException{
        ctx = new InitialContext();
        f= (QueueConnectionFactory) ctx.lookup("myEmployeeQueueConnectionFactory");
        con= f.createQueueConnection();
        con.start();
        ses= con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        q= (Queue) ctx.lookup("myEmpQueue");
        sender= ses.createSender(q);
        msg= ses.createTextMessage();
        
//        String str="Hello from Frontend!!!";
//        msg.setText(str);
//        sender.send(msg);
        
    }
    
    public void sendMessage(String m ) throws JMSException{
        TextMessage msg = ses.createTextMessage();
        msg.setText(m);
        sender.send(msg);
        System.out.println("Message sent from front end!");
    }
    
}
