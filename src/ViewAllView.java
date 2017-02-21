
import javax.swing.JPanel;
import javax.swing.JTable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ajl5735
 */
public class ViewAllView extends JPanel{
    JTable table;
    Object[][] data = {{"User1","Pass1","Source"},{"User2","Pass2","Source2"}};
    ViewAllView(){
    String[] columnName ={"UserName", "Password", "Source"};
     
    
    table = new JTable(data, columnName);
    
    add(table);
    }

    public JTable getTable() {
        return table;
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
    
}
