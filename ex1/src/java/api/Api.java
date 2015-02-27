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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Object rand;

    /**
     * Creates a new instance of Api
     */
    public Api() {
        String arrayFirstName[] ={"James","Thomas","Messi","Neymar","Van"};
        String arrayLastName[] ={"Rodríguez","Mueller","Tanros","Bullik","Perise"};
        String arrayCountry[] ={"Denmark","USA","Columbia","Australia","Sweden"};
        String create1 = "";
        Random rand = new Random();
        for (int i = 1; i < 100; i++) {
            int  x = rand.nextInt(4);
            int  y = rand.nextInt(4);
            int  aa = rand.nextInt(4);
            create1 = ""+arrayFirstName[x]+" "+arrayLastName[y];
            footballLinks.add(new Player(i,create1,arrayCountry[aa]));   
        }
       
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
         @GET
      @Path("/AllPlayersFromWebsite")
     @Produces("application/json")
    public String getAllPlayersFromWebsite(@PathParam("id") int id) throws IOException {
            URL url = null; try {
         url = new URL("http://footballpool.dataaccess.eu/data/info.wso/AllPlayerNames/JSON/debug?bSelected=sName");
     } catch (MalformedURLException ex) {
         Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, ex);
     }
URLConnection con = url.openConnection(); Scanner scan = new Scanner(con.getInputStream()); String jsonStr=null;
if (scan.hasNext()) {
  jsonStr = scan.nextLine();
}
System.out.println(jsonStr);
scan.close();
     return jsonStr;
          
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
