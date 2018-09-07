/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleApiService;

import java.util.List;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

/**
 *
 * @author imad
 */
public class Client {
    public static List<Place> getPlaces(double lng,double lat)
    {
        // initialising the google API with the API key
         GooglePlaces client = new GooglePlaces("AIzaSyCDA46HYMy-6rFKDPQyRIn0NyxUQy-Q-2o");
         List<Place> places =null;
         // recovering the closest shops to the provided coordinates
        try{
          places = client.getNearbyPlaces(lng, lat, 8000,40,Param.name("type").value("shopping_mall"),Param.name("rankedby").value("distance"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
       return places;
    }
   
    
    
}
