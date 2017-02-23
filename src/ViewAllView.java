
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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

    Object[][] data = {{"User1", "Pass1", "Source"}, {"User2", "Pass2", "Source2"}};
    JScrollPane scrollPane;
    JTextArea searchArea;
    JButton searchButton;

    ViewAllSearchPanel viewAllSearchPanel;

    String[] columnName = {"UserName", "Password", "Source"};
    DefaultTableModel model = new DefaultTableModel(data, columnName);
    JTable table = new JTable(model);

    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(table.getModel());

    private JTextField jtfFilter = new JTextField();
JPanel panel;
//    ViewAllView() {
//        setLayout(new BorderLayout());
//        viewAllSearchPanel = new ViewAllSearchPanel();
//
//
//        
//        table.setDefaultEditor(Object.class, null);
//
//        scrollPane = new JScrollPane(table);
//
//        searchArea = new JTextArea("");
//
//        searchButton = new JButton("Search");
//
//        add(scrollPane, BorderLayout.CENTER);
//        add(viewAllSearchPanel, BorderLayout.SOUTH);
//    }
    public ViewAllView() {
        viewAllSearchPanel = new ViewAllSearchPanel();
//        table.setDefaultEditor(Object.class, null);

        searchArea = new JTextArea("");

        searchButton = new JButton("Search");

        table.setRowSorter(rowSorter);
table.setColumnSelectionAllowed(true);
        panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
        panel.add(searchArea, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(viewAllSearchPanel, BorderLayout.WEST);

        searchArea.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchArea.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchArea.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTextArea getSearchArea() {
        return searchArea;
    }

    public void setSearchArea(JTextArea searchArea) {
        this.searchArea = searchArea;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public ViewAllSearchPanel getViewAllSearchPanel() {
        return viewAllSearchPanel;
    }

    public void setViewAllSearchPanel(ViewAllSearchPanel viewAllSearchPanel) {
        this.viewAllSearchPanel = viewAllSearchPanel;
    }

}
