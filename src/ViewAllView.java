
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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

    JPanel panel;

    public ViewAllView() {
        viewAllSearchPanel = new ViewAllSearchPanel();

        searchArea = new JTextArea("");

        searchButton = new JButton("Search");

        table.setRowSorter(rowSorter);
        table.setRowSelectionAllowed(true);
        panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
        panel.setBackground(Color.YELLOW);
        panel.add(searchArea, BorderLayout.CENTER);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(viewAllSearchPanel, BorderLayout.WEST);

    }

    public TableRowSorter<TableModel> getRowSorter() {
        return rowSorter;
    }

    public void setRowSorter(TableRowSorter<TableModel> rowSorter) {
        this.rowSorter = rowSorter;
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
