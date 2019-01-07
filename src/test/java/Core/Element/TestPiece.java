package Core.Element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPiece {
    
    String nomPiece;
    private Piece piece;
    private int[] amntOfPiece;
    
    private Ligne ligne;
    private int[] amntOfLigne;
    
    
    @BeforeEach
    void setUP(){
        amntOfPiece = new int[]{100, 100, 200};
        nomPiece = "Nom de la piece";
        piece = new Piece(nomPiece, amntOfPiece);
        
        amntOfLigne = new int[] {50, 200, 120};
        ligne = new Ligne(nomPiece, amntOfLigne);
        
    }
    
    @Test
    void surLeConstructeur() {
        assertEquals(nomPiece, piece.getFullName());
        assertEquals(amntOfPiece, piece.getAmount());
    }
    
    @Test
    void noPieceProduceWhenCreate() {
        int[] remain = piece.remainToPlace();
        int[] alreadyPlace = piece.alreadyPlace();
        
        for(int i = 0 ; i < remain.length ; i++)
        {
            assertEquals(remain[i], amntOfPiece[i]);
            assertEquals(alreadyPlace[i], 0);
        }
    }
    
    @Test
    void assignementNotFull(){
        piece.addProduceOn(ligne, ligne.getRemainProductionCapacity());
        
        int[] qte = piece.alreadyPlace();
        
        assertEquals(50, qte[0]);
        assertEquals(100, qte[1]);
        assertEquals(120, qte[2]);
    }
    
    @Test
    void assignementNotFullBis(){
        piece.addProduceOn(ligne, ligne.getRemainProductionCapacity());
        
        int[] qte = piece.remainToPlace();
        
        assertEquals(50, qte[0]);
        assertEquals(0, qte[1]);
        assertEquals(80, qte[2]);
        
        
    }
    
}
