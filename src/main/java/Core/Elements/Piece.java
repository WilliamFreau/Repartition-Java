package Core.Elements;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Piece {
    private String name;
    private String smallName;
    
    private int amount;
    
    private LinkedHashMap<Ligne, Integer> produceOn;
    private List<Ligne> assignedTo;
    
    
    public Piece(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.smallName = name;
        
        this.produceOn = new LinkedHashMap<>();
        this.assignedTo = new ArrayList<>();
    }
    
    
    
    public int remainToPlace() {
        int somme = 0;
        for(Map.Entry<Ligne, Integer> entry : this.produceOn.entrySet())
        {
            somme += entry.getValue();
        }
        return somme;
    }
    
    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }
}
