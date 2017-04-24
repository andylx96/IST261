
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewAllSearchPanel extends JPanel {

    JButton deleteButton, editButton, saveEditButton;

    public ViewAllSearchPanel() {
        setLayout(new GridLayout(10,1));
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        saveEditButton = new JButton("Save\nEdits");
        add(deleteButton);
//        add(editButton);
        add(saveEditButton);
    }

    public void addDeleteButtonListener(ActionListener al) {
        this.deleteButton.addActionListener(al);
    }

    public void addEditButtonListener(ActionListener al) {
        this.editButton.addActionListener(al);
    }

    public void addSaveEditButtonListener(ActionListener al) {
        this.saveEditButton.addActionListener(al);
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getSaveEditButton() {
        return saveEditButton;
    }

    public void setSaveEditButton(JButton saveEditButton) {
        this.saveEditButton = saveEditButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
}
