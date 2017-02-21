
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
    
    ViewAllView(){
    String[] columnName ={"UserName", "Password", "Source"};
    Object[][] data = {{"User1"},{"Pass1"},{"Source"},{"User2"},{"Pass2"},{"Source2"}};
    
    table = new JTable(data, columnName);
    }
    
}
