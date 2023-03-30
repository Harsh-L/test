package it.samplerestapp.resources;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
      @GET
    //@Produces(MediaType.TEXT_HTML)
     @Produces("text/html")
     public String sayHello(){
        return "<h2>Hello world of REST !!!</h2>";
    }
     
    
     @GET
     @Path("someone/{sname}")
     @Produces("text/html")
     public String sayHelloToSomeOne(@PathParam("sname") String pname)
     {
         
         return "<h3>Hello "+ pname + " !!</h3>"; 
     }
     
   
   @Path("getups")
   @PUT
   @Consumes("application/json")
   @Produces("application/json")
   public Collection<String> ucases(Collection<String> strs)
   {
      Collection<String> uppers = new ArrayList<>(); 
      
      for(String s : strs)
      {
          uppers.add(s.toUpperCase());
      }
      
      return uppers;
   }
     
     
     
     
     
     
     
     
}
