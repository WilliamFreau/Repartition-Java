package UI.Utils;

import javax.swing.*;

public class SortedDoubleList<T> extends JPanel{
    private JPanel root;
    
    private DoubleList<T> doubleList;
    
    private JButton rightListUp;
    private JButton rightListDown;
    private JButton leftListUp;
    private JButton leftListDown;
    
    private DefaultListModel<T> leftListModel;
    private DefaultListModel<T> rightListModel;
    
    public SortedDoubleList () {
        this.leftListModel  = this.doubleList.getLeftListModel();
        this.rightListModel = this.doubleList.getRightListModel();
        
        initListener();
    }
    
    
    private void initListener(){
        this.leftListDown.addActionListener( event -> {
            
        });
        
        this.leftListDown.addActionListener( event -> {
            
        });
        
        this.rightListUp.addActionListener( event -> {
            
        });
        
        this.rightListDown.addActionListener( event -> {
            
        });
    }
<<<<<<< HEAD
=======
    
>>>>>>> origin/SortedDoubleList
}
