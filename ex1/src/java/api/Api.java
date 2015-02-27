/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import java.io.IOException;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import Models.Player;

/**
 * REST Web Service
 *
 * @author JoachimDittman
 */
@Path("players")
public class Api {
 List<Player> footballLinks = new ArrayList();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Api
     */
    public Api() {
        footballLinks.add(new Player(1,"James Rodríguez","Columbia")); 
        footballLinks.add(new Player(2,"Thomas Mueller","USA")); 
        footballLinks.add(new Player(3,"Messi","Sweden")); 
        footballLinks.add(new Player(4,"Neymar","Demnark")); 
        footballLinks.add(new Player(5,"van Persie","Australia")); 
    }

    /**
     * Retrieves representation of an instance of api.Api
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
       Gson gson = new Gson();
        String clubsJson = gson.toJson(footballLinks);
        return clubsJson;
    }

        @GET
      @Path("/{id}")
     @Produces("application/json")
    public String getone(@PathParam("id") int id) {
            String clubsJson = null;
        Gson gson = new Gson();
            for (Player footballLink : footballLinks) {
                 if(id == footballLink.getId()){clubsJson =   footballLink.toString();}
            }
           if(clubsJson.isEmpty()) 
                 {
                    clubsJson = "{\"errCode\": 404, \"errMsg\" : \"No player found with the given ID:"+id+"\" }";
                }
           
                return gson.toJson(clubsJson);
        
              
          
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
