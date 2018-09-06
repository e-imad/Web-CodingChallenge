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
    public static List<Place> getPlaces()
    {
         GooglePlaces client = new GooglePlaces("AIzaSyCDA46HYMy-6rFKDPQyRIn0NyxUQy-Q-2o");
         List<Place> places = client.getNearbyPlaces(33.9954233, -6.8522169, 80000,40,Param.name("type").value("shopping_mall"),Param.name("rankedby").value("distance"));

    
       return places;
    }
    public static void main(String[] args)
    {
        for(Place a : Client.getPlaces())
            System.out.println(a.getName());
    }
        
   
    
    
}
