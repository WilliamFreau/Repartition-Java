package UI.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoubleList<T> {
    private JPanel root;
    
    private JList<T> leftList;
    private JList<T> rightList;
    
    private JButton fromLeftToRight;
    private JButton fromRightToLeft;
    
    private DefaultListModel<T> leftListModel;
    private DefaultListModel<T> rightListModel;
    
    public DoubleList () {
        
        leftListModel = new DefaultListModel<T>();
        rightListModel = new DefaultListModel<T>();
        
        this.leftList.setModel(this.leftListModel);
        this.rightList.setModel(this.rightListModel);
        
        initListener();
        
    }
    
    private void initListener() {
        this.fromLeftToRight.addActionListener( event -> {
            
        });
        
        this.fromRightToLeft.addActionListener( event -> {
            
        });
    }
    
    public void addToLeftList(T element)
    {
        this.addToListModel(this.leftListModel, element);
    }
    
    public void addToRightList(T element)
    {
        this.addToListModel(this.rightListModel, element);
    }
    
    private void addToListModel(DefaultListModel<T> list, T element)
    {
        list.add(list.size(), element);
    }
    
}
