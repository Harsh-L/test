/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RestResource [rest]<br>
 * USAGE:
 * <pre>
 *        PublishingClient client = new PublishingClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class PublishingClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PublishingDemo/resources";

    public PublishingClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void addCustomer(String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCustomer/{0}/{1}", new Object[]{fname, lname})).request().post(null);
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getCustomers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getCustomers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateAddress(String aid, String street, String state, String city, String zip, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAddress/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{aid, street, state, city, zip, cid})).request().put(null);
    }

    public void addAddress(String street, String state, String city, String zip, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAddress/{0}/{1}/{2}/{3}/{4}", new Object[]{street, state, city, zip, cid})).request().post(null);
    }

    public void updateCustomer(String cid, String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCustomer/{0}/{1}/{2}", new Object[]{cid, fname, lname})).request().put(null);
    }

    public void removeAddress(String aid, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteAddress/{0}/{1}", new Object[]{aid, cid})).request().delete();
    }

    public void removeCustomer(String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCustomer/{0}", new Object[]{cid})).request().delete();
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
