/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author imad
 */
public class Likes {
    private ArrayList<String> IdLocation;

    public Likes(String username,int t) {
        if(t==1)
        this.IdLocation = LikeID.getLikes(username);
        
        else
        this.IdLocation = LikeID.getDisLikes(username);
        
    }
    
    public boolean exist(String ref)
    {
       return  IdLocation.indexOf(ref)!=-1;      
    }

    public ArrayList<String> getIdLocation() {
        return IdLocation;
    }

    public void setIdLocation(ArrayList<String> IdLocation) {
        this.IdLocation = IdLocation;
    }
    
    
}
