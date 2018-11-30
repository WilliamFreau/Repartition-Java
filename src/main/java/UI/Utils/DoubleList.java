package UI.Utils;

import javax.swing.*;
import java.util.List;

public class DoubleList<T> extends JPanel{
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
            this.moveSelectedElementOfAToB(this.leftListModel, this.rightListModel, this.leftList.getSelectedValuesList());
        });
        
        this.fromRightToLeft.addActionListener( event -> {
            this.moveSelectedElementOfAToB(this.rightListModel, this.leftListModel, this.rightList.getSelectedValuesList());
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
    
    private void addToListModel(DefaultListModel<T> listModel, T element)
    {
        listModel.addElement(element);
    }
    
    private void moveSelectedElementOfAToB(DefaultListModel<T> A, DefaultListModel<T> B, List<T> elementsToMove)
    {
        for(T element : elementsToMove)
        {
            A.remove(A.indexOf(element));
            B.addElement(element);
        }
    }
    
    public DefaultListModel<T> getLeftListModel(){return this.leftListModel;}
    public DefaultListModel<T> getRightListModel(){return this.rightListModel;}
    
}
