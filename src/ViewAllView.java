
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ajl5735
 */
public class ViewAllView extends JPanel {

    JTable table;
    Object[][] data = {{"User1", "Pass1", "Source"}, {"User2", "Pass2", "Source2"}};
    DefaultTableModel model;
    JScrollPane scrollPane;
    
    ViewAllView() {
        setLayout(new BorderLayout());

        
        String[] columnName = {"UserName", "Password", "Source"};

        model = new DefaultTableModel(data, columnName);

        table = new JTable(model);

        table.setDefaultEditor(Object.class, null);
        
        scrollPane = new JScrollPane(table);
        
        add(scrollPane, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public void updateTableView(JTable table) {

        this.table = table;
//        this.remove(table);
//        this.add(table);
    }

}
