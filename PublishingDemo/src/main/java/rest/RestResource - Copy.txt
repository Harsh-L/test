/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import beans.PublishingBeanLocal;
import entities.Customer;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("rest")
@RequestScoped
public class RestResource {
    
    @EJB PublishingBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }
    
    @GET
    @Path("getCustomers")
    @Produces("application/json")
    public Collection<Customer> getCustomers() {
        return pbl.getCustomers();
    }
    
    @POST
    @Path("addCustomer/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname, @PathParam("lname") String lname) {
        pbl.addCustomer(fname, lname);
    }
    
    @PUT
    @Path("updateCustomer/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") Integer cid, @PathParam("fname") String fname, @PathParam("lname") String lname) {
        pbl.updateCustomer(cid, fname, lname);
    }
    
    @DELETE
    @Path("deleteCustomer/{cid}")
    public void removeCustomer(@PathParam("cid") Integer cid) {
        pbl.removeCustomer(cid);
    }
    
    @POST
    @Path("addAddress/{street}/{state}/{city}/{zip}/{cid}")
    public void addAddress(@PathParam("street") String street, @PathParam("state") String state, @PathParam("city") String city, @PathParam("zip") String zip, @PathParam("cid") Integer cid) {
        pbl.addAddress(street, state, city, zip, cid);
    }
    
    @PUT
    @Path("updateAddress/{aid}/{street}/{state}/{city}/{zip}/{cid}")
    public void updateAddress(@PathParam("aid") Integer aid, @PathParam("street") String street, @PathParam("state") String state, @PathParam("city") String city, @PathParam("zip") String zip, @PathParam("cid") Integer cid) {
        pbl.updateAddress(aid, street, state, city, zip, cid);
    }
    
    @DELETE
    @Path("deleteAddress/{aid}/{cid}")
    public void removeAddress(@PathParam("aid") Integer aid, @PathParam("cid") Integer cid) {
        try{
            pbl.removeAddress(aid, cid);
        } catch(Exception e){
            e.getMessage();
        }
    }

    /**
     * Retrieves representation of an instance of rest.RestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
