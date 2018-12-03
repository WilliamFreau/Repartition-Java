package Core.Element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPiece {
    
    @Test
    public void testSurLeConstructeur() {
        int[] amnt = {100, 100, 200};
        String nomPiece = "Nom de la piece";
        
        Piece piece = new Piece(nomPiece, amnt);
        
        assertEquals(nomPiece, piece.getName());
        assertEquals(amnt, piece.getAmount());
    }
    
    @Test
    public void testNoPieceProduceWhenCreate() {
        int[] amnt = {100, 100, 200};
        String nomPiece = "Nom de la piece";
        
        Piece piece = new Piece(nomPiece, amnt);
        
        int[] remain = piece.remainToPlace();
        int[] alreadyPlace = piece.alreadyPlace();
        
        for(int i = 0 ; i < remain.length ; i++)
        {
            assertEquals(remain[i], amnt[i]);
            assertEquals(alreadyPlace[i], 0);
        }
    }
    
}
