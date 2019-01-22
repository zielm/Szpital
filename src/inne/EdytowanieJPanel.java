/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inne;

import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import zarzadzanie.Main;

/**
 *
 * @author Monika
 */
public abstract class EdytowanieJPanel extends JPanel{
    
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public void zerujWszystko() {
        for (Component mainComponent : getComponents()) {
            if (mainComponent.getClass() == JPanel.class) {
                for(Component component : ((JPanel)mainComponent).getComponents()) {
                    zerujComponent(component);
                }
            }
            else {
                zerujComponent(mainComponent);
            }
        }
    }
    
    private void zerujComponent(Component component) {
        if (component.getClass() == JTextField.class) {
            ((JTextField)component).setText("");
        }
        else if (component.getClass() == JFormattedTextField.class ) {
            ((JFormattedTextField)component).setText("");
        }
        else if (component.getClass() == JComboBox.class) {
            ((JComboBox)component).setSelectedIndex(0);
        }
        else if (component.getClass() == JScrollPane.class) {
            JTable table = getJTableFromJScrollPane((JScrollPane)component);
            ((DefaultTableModel)(table).getModel()).setRowCount(0);
        }
        else if(component.getClass() == JLabel.class &&
                component.getAccessibleContext().getAccessibleName() == "stanLabel") {
            ((JLabel)component).setText("");
        }
    }
    
    private JTable getJTableFromJScrollPane(JScrollPane pane) {
        JViewport view = pane.getViewport();
        for(Component c : view.getComponents()) {
            if(c.getClass() == JTable.class) {
                return (JTable)c;
            }
        }
        return null;
    }
    
    public void wroc() {
        ((CardLayout)this.getParent().getLayout()).removeLayoutComponent(this);
        this.getParent().remove(this);
        this.setVisible(false);
        
        unblockButtonsOnMainPanel();
    }
    
    public void blockButtonsOnMainPanel() {
        for (JButton button : Main.getApp().getButtons()) {
            button.setEnabled(false);
        }
    }
    
    public void unblockButtonsOnMainPanel() {
        for (JButton button : Main.getApp().getButtons()) {
            button.setEnabled(true);
        }
    }
    
    public abstract void odrzuc();
    
}
