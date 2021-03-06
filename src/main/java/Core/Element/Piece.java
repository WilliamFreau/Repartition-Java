package Core.Element;

import java.util.LinkedHashMap;
import java.util.Map;

public class Piece {
    private String fullName;
    private String smallName;
    
    private int[] amount;
    
    private LinkedHashMap<Ligne, int[]> produceOn;
    
    public Piece(String fullName, int[] amount) {
        this.fullName = fullName;
        this.amount = amount;
        this.smallName = fullName;
        
        this.produceOn = new LinkedHashMap<>();
    }
    
    
    
    /**
     * Return a Array wth the min of each cell of both tab
     * @param tabA
     * @param tabB
     * @return  int[i]: Math.min(tabA[i], tabB[i])
     */
    private static int[] getBestRepart(int[] tabA, int[] tabB) {
        int[] returned = new int[tabA.length];
        
        for(int i = 0 ; i < tabA.length ; i++)
        {
            returned[i] = Math.min(tabA[i], tabB[i]);
        }
        
        return returned;
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
    
    public int[] addProduceOn(Ligne ligne, int[] amntMax) {
        int[] pieceRepart = Piece.getBestRepart(this.amount, amntMax);
        
        this.produceOn.put(ligne, pieceRepart);
        
        return pieceRepart;
    }
    
    public int[] removeProduceOn(Ligne ligne)
    {
        int[] returned = new int[amount.length];
        
        if(this.produceOn.containsKey(ligne))
        {
            returned = this.produceOn.get(ligne);
            this.produceOn.remove(ligne);
            //TODO: Faire le rebuild des quantites vue qu'on faire de faire du vide...
        }
        
        return returned;
    }
    
    public boolean isFullProduce() {
        boolean returned = true;
        int[] remain = this.remainToPlace();
        for(int el : remain)
        {
            returned &= el==0;
        }
        return returned;
    }
    
    public boolean isFullReplaceOnIndex(int index)
    {
        return this.remainToPlace()[index]==0;
    }
    
    public String getSmallName() {
        return smallName;
    }
    
    public int[] getAmount() {
        return amount;
    }
    
    public String getFullName() {
        return fullName;
    }
}
