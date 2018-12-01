package UI.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDoubleList {
    
    
    @Test
    public void testAddItemToLeftList() {
        Object obj = new Object();
        
        DoubleList<Object> doubleList = new DoubleList<>();
        doubleList.addToLeftList(obj);
        
        assertEquals(1, doubleList.getLeftListModel().size());
    }
    
    @Test
    public void testAddItemToRightList() {
        Object obj = new Object();
        
        DoubleList<Object> doubleList = new DoubleList<>();
        doubleList.addToRightList(obj);
        
        assertEquals(1, doubleList.getRightListModel().size());
    }
    
    @Test
    public void testLeftElementToRight() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        DoubleList<Object> doubleList = new DoubleList<Object>();
        
        doubleList.addToLeftList(obj1);
        doubleList.addToRightList(obj1);
    }
    
    
    
}
