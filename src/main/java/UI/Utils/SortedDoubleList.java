package UI.Utils;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SortedDoubleList<T> extends JPanel {
    private JPanel root;
    
    private DoubleList<T> doubleList;
    
    private JButton rightListUp;
    private JButton rightListDown;
    private JButton leftListUp;
    private JButton leftListDown;
    
    private DefaultListModel<T> leftListModel;
    private DefaultListModel<T> rightListModel;
    
    public SortedDoubleList() {
        this.leftListModel = this.doubleList.getLeftListModel();
        this.rightListModel = this.doubleList.getRightListModel();
        
        initListener();
    }
    
    private void initListener() {
        this.leftListUp.addActionListener(event -> {
            List<T> selected = this.doubleList.getLeftSelected();
            this.moveUpSelected(selected, this.leftListModel);
        });
        
        this.leftListDown.addActionListener(event -> {
            List<T> selected = this.doubleList.getLeftSelected();
            this.moveDownSelected(selected, this.leftListModel);
        });
        
        this.rightListUp.addActionListener(event -> {
            List<T> selected = this.doubleList.getRightSelected();
            this.moveUpSelected(selected, this.rightListModel);
        });
        
        this.rightListDown.addActionListener(event -> {
            List<T> selected = this.doubleList.getLeftSelected();
            this.moveDownSelected(selected, this.rightListModel);
        });
    }
    
    private void moveUpSelected(List<T> selected, DefaultListModel<T> listModel) {
        for (T el : selected) {
            this.moveUp(el, listModel);
        }
    }
    
    private void moveDownSelected(List<T> selected, DefaultListModel<T> listModel) {
        for (T el : selected) {
            this.moveDown(el, listModel);
        }
    }
    
    private void moveUp(T element, DefaultListModel<T> listModel) {
        int currentIndex = listModel.indexOf(element);
        listModel.remove(currentIndex);
        listModel.insertElementAt(element, currentIndex - 1);
    }
    
    private void moveDown(T element, DefaultListModel<T> listModel) {
        int currentIndex = listModel.indexOf(element);
        listModel.remove(currentIndex);
        listModel.insertElementAt(element, currentIndex + 1);
    }
    
    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }
    
    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        root = new JPanel();
        root.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        doubleList = new DoubleList();
        root.add(doubleList.$$$getRootComponent$$$(), new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        root.add(panel1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        rightListUp = new JButton();
        rightListUp.setText("/\\");
        panel1.add(rightListUp, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rightListDown = new JButton();
        rightListDown.setText("\\/");
        panel1.add(rightListDown, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        root.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        leftListUp = new JButton();
        leftListUp.setText("/\\");
        panel2.add(leftListUp, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leftListDown = new JButton();
        leftListDown.setText("\\/");
        panel2.add(leftListDown, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel2.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel2.add(spacer4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }
    
    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return root;
    }
}
