package Core.Element;

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
    
    public int[] alreadyPlace() {
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
    
    public int[] remainToPlace() {
        int[] alreadyPlace = this.alreadyPlace();
        int[] remain = new int[alreadyPlace.length];
        
        for(int i = 0 ; i < remain.length ; i++)
        {
            remain[i] = this.amount[i]-alreadyPlace[i];
        }
        return remain;
    }
    
    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSmallName() {
        return smallName;
    }
    
    public int[] getAmount() {
        return amount;
    }
}
