package mapdemo;

import java.awt.Color;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MapDemo {

    public static void main(String[] args) {
        
        Map<String, Color> favoriteColors = new HashMap<>();
       
        favoriteColors.put("Juliet", Color.BLUE);
        favoriteColors.put("Romeo", Color.GREEN);
        favoriteColors.put("Adam", Color.red);
        favoriteColors.put("Eve", Color.blue);
        
       
        Set<String> keySet = favoriteColors.keySet();
        
        for(String key: keySet){
            Color value = favoriteColors.get(key);
            System.out.println(key + ": " + value);
        }
    }
    
}
