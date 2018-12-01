package UI.Utils;

import javax.swing.*;
import java.util.List;

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
        this.leftListUp.addActionListener( event -> {
            List<T> selected = this.doubleList.getLeftSelected();
            this.moveUpSelected(selected, this.leftListModel);
        });
        
        this.leftListDown.addActionListener( event -> {
            List<T> selected = this.doubleList.getLeftSelected();
            this.moveDownSelected(selected, this.leftListModel);
        });
        
        this.rightListUp.addActionListener( event -> {
            List<T> selected = this.doubleList.getRightSelected();
            this.moveUpSelected(selected, this.rightListModel);
        });
        
        this.rightListDown.addActionListener( event -> {
            List<T> selected = this.doubleList.getLeftSelected();
            this.moveDownSelected(selected, this.rightListModel);
        });
    }
    
    private void moveUpSelected(List<T> selected, DefaultListModel<T> listModel)
    {
        for(T el : selected)
        {
            this.moveUp(el, listModel);
        }
    }
    
    private void moveDownSelected(List<T> selected, DefaultListModel<T> listModel)
    {
        for(T el : selected)
        {
            this.moveDown(el, listModel);
        }
    }
    
    private void moveUp(T element, DefaultListModel<T> listModel)
    {
        int currentIndex = listModel.indexOf(element);
        listModel.remove(currentIndex);
        listModel.insertElementAt(element, currentIndex-1);
    }
    
    private void moveDown(T element, DefaultListModel<T> listModel)
    {
        int currentIndex = listModel.indexOf(element);
        listModel.remove(currentIndex);
        listModel.insertElementAt(element, currentIndex+1);
    }
}
