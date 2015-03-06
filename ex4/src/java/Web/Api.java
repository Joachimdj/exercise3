/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import com.google.gson.Gson; 
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT; 
import Entity.Person; 
import javax.ws.rs.DELETE; 
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author JoachimDittman
 */
@Path("person")
public class Api {
 List<Person> footballLinks = new ArrayList();
    @Context
    private UriInfo context;
    private Object rand;

    /**
     * Creates a new instance of Api
     */
    public Api() { 
    }

    /**
     * Retrieves representation of an instance of api.Api
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
       Gson gson = new Gson();
        String clubsJson = gson.toJson("Hej");
        return clubsJson;
    }

        @GET
      @Path("person/{name}")
     @Produces("application/json")
    public String getone(@PathParam("id") int id) {
            String clubsJson = null;
             Gson gson = new Gson();
          return gson.toJson(clubsJson);    
    }
          @POST
      @Path("person/add/{type}")
     @Produces("application/json")
    public String addPerson(@PathParam("type") int type) {
         return "";  
    } 
         @PUT
      @Path("person/edit/{id}")
     @Produces("application/json")
    public String editPerson(@PathParam("id") int id) {
         return "";  
    } 
      @DELETE
      @Path("person/delete/{id}")
     @Produces("application/json")
    public String deletePerson(@PathParam("id") int id) {
         return "";  
    } 
    
    
    /**
     * PUT method for updating or creating an instance of Api
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
}
