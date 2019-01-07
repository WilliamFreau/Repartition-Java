package Core.Element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLigne {
    
    String bomLigne;
    private Piece piece;
    private int[] amntOfPiece;
    
    private Ligne ligne;
    private int[] amntOfLigne;
    
    
    @BeforeEach
    void setUP() {
        amntOfPiece = new int[]{100, 100, 200};
        bomLigne = "Nom de la ligne";
        piece = new Piece(bomLigne, amntOfPiece);
    
        amntOfLigne = new int[]{50, 200, 120};
        ligne = new Ligne(bomLigne, amntOfLigne);
    }
    
    
    @Test
    void testConstructeur() {
        
    }
    
    
}
