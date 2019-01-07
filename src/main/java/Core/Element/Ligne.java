package Core.Element;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ligne {
    private String name;
    private String smallName;
    
    private int [] capacity;
    
    private LinkedHashMap<Piece, int[]> produced;
    private List<Piece> canProduce;
    
    
    public Ligne(String name, int[] capacity)
    {
        this.name = name;
        this.smallName = name;
        this.capacity = capacity;
        
        produced = new LinkedHashMap<>();
        canProduce = new ArrayList<>();
    }
    
    public void addToCanProdude(Piece piece)
    {
        this.canProduce.add(piece);
    }
    
    public void addToProduce(Piece piece)
    {
        if(!this.canProduce.contains(piece))
            return;
        
        int[] produce = piece.addProduceOn(this, this.getRemainProductionCapacity());
        this.produced.put(piece, produce);
    }
    
    public void removePieceProduce(Piece piece)
    {
        if(!this.produced.containsKey(piece))
            return;
        
        this.produced.remove(piece);
        piece.removeProduceOn(this);
        //TODO: Le rebuild du model
    }
    
    public int[] getCurrentProduction(){
        int[] returned = new int[this.capacity.length];
        
        for(Map.Entry<Piece, int[]> entry : produced.entrySet())
        {
            for(int i = 0 ; i < returned.length ; i++)
            {
                returned[i] += entry.getValue()[i];
            }
        }
        
        return returned;
    }
    
    public int[] getRemainProductionCapacity(){
        int[] currentProd = this.getCurrentProduction();
        int[] returned = new int[currentProd.length];
        
        for(int i = 0 ; i < currentProd.length ; i++) {
            returned[i] = this.capacity[i]-currentProd[i];
        }
        
        return returned;
    }
    
}
