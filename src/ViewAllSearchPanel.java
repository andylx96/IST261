
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zabuz
 */
public class ViewAllSearchPanel extends JPanel {

    JButton deleteButton, editButton, saveEditButton;

    public ViewAllSearchPanel() {
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        saveEditButton = new JButton("save");
        add(deleteButton);
        add(editButton);
        add(saveEditButton);
        saveEditButton.setVisible(false);
    }

    public void addDeleteButtonListener(ActionListener al) {
        this.deleteButton.addActionListener(al);
    }

    public void addEditButtonListener(ActionListener al) {
        this.editButton.addActionListener(al);
    }

    public void addsaveEditButtonListener(ActionListener al) {
        this.saveEditButton.addActionListener(al);
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
}
