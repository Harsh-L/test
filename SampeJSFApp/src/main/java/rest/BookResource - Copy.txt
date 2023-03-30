/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.ModelEJBLocal;
import entity.BookMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("book")
@RequestScoped
public class BookResource {
    @EJB ModelEJBLocal m;
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }

    /**
     * Retrieves representation of an instance of rest.BookResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Collection<BookMaster> getAllBooks() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
    return m.getAllBooks();
    }

    /**
     * PUT method for updating or creating an instance of BookResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
