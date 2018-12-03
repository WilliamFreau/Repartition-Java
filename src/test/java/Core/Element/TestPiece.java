package Core.Element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPiece {
    
    String nomPiece;
    private Piece piece;
    private int[] amnt;
    
    @BeforeEach
    public void setUP(){
        amnt =  new int[]{100, 100, 200};
        nomPiece = "Nom de la piece";
        piece = new Piece(nomPiece, amnt);
    }
    
    @Test
    public void surLeConstructeur() {
        assertEquals(nomPiece, piece.getFullName());
        assertEquals(amnt, piece.getAmount());
    }
    
    @Test
    public void noPieceProduceWhenCreate() {
        int[] remain = piece.remainToPlace();
        int[] alreadyPlace = piece.alreadyPlace();
        
        for(int i = 0 ; i < remain.length ; i++)
        {
            assertEquals(remain[i], amnt[i]);
            assertEquals(alreadyPlace[i], 0);
        }
    }
    
    @Test
    public void assignementNotFull(){
        
    }
    
}
