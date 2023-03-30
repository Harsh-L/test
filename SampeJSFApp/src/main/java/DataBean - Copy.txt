/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import client.BookClient;
import entity.BookMaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "dataBean")
@Dependent
public class DataBean {
    
    BookClient cl;
    Response res;
    Collection<BookMaster> books;
   GenericType<Collection<BookMaster>> gbooks;
    
   
    
    
    

    public Collection<BookMaster> getBooks() {
       
        res = cl.getAllBooks(Response.class);
        Collection<BookMaster> allbooks =  res.readEntity(gbooks);
        return allbooks;  //em.createNamedQuery("BookMaster.findAll").getResultList();
    }

    public void setBooks(Collection<BookMaster> books) {
        this.books = books;
    }
    

    /**
     * Creates a new instance of DataBean
     */
    public DataBean() {
        cl = new BookClient();
        books = new ArrayList<>();
        gbooks = new GenericType<Collection<BookMaster>>(){};
    }
    
}
 