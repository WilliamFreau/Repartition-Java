package Core.Elements;

import java.util.LinkedHashMap;
import java.util.Map;

public class Piece {
    private String name;
    private String smallName;
    
    private int[] amount;
    
    private LinkedHashMap<Ligne, int[]> produceOn;
    
    public Piece(String name, int[] amount) {
        this.name = name;
        this.amount = amount;
        this.smallName = name;
        
        this.produceOn = new LinkedHashMap<>();
    }
    
    public int[] remainToPlace() {
        int[] somme = new int[amount.length];
        
        for(Map.Entry<Ligne, int[]> entry : this.produceOn.entrySet())
        {
            for(int i = 0 ; i < amount.length ; i++)
            {
                somme[i] += entry.getValue()[i];
            }
        }
        return somme;
    }
    
    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }
}
