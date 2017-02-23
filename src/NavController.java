
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NavController {

    NavModel n_model;
    NavView n_view;

    CreateView c_view;
    MasterLoginView masterLogin_view;
    GeneratePass g;
    ArrayList<Accounts> accountsArray;
    Accounts masterAccount;
    SearchView search_view;
    FileWriter fout;

    ViewAllView viewAll_view;
    CreateMasterLoginView createMasterLogin_view;

    public NavController(NavModel n_model, NavView n_view) {
        this.n_model = n_model;
        this.n_view = n_view;

        c_view = new CreateView();
        masterLogin_view = new MasterLoginView();
        g = new GeneratePass();
        search_view = new SearchView();
        viewAll_view = new ViewAllView();
        createMasterLogin_view = new CreateMasterLoginView();

        masterLogin_view.addMasterLoginListener(new MasterPassButtonListener());

        n_view.addMasterButtonListener(new MasterLoginViewListener());
        n_view.addCreateMasterButtonListener(new CreateNewMasterButtonListener());
        createMasterLogin_view.addCreateMasterLoginListener(new CreateMasterLoginButtonListener());
        search_view.getFindButton().addActionListener(new FindButtonListener());

//        viewAll_view.getViewAllSearchPanel().addSearchButtonListener(new ViewAllSearchButtonListener());
    }

    class CreateMasterLoginButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                fout = new FileWriter("src/MasterLogin.txt", true);
                fout.write(createMasterLogin_view.getUserName().getText() + "\n");
                fout.write(createMasterLogin_view.getPassword().getText() + "\n");
                createMasterLogin_view.getCreateStatus().setText("account created");
                fout.close();
                fout.flush();
            } catch (IOException ex) {
            }
        }
    }

    class CreateViewButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            n_view.switchToCreateViewPanel(c_view);
        }
    }

    class ViewAllSearchButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {




//TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(viewAll_view.getTable().getModel());
//    viewAll_view.getTable().setRowSorter(sorter);
//  if (viewAll_view.viewAllSearchPanel.getUsernameField().getText().length() == 0) {
//          sorter.setRowFilter(null);
//        } else {
//          sorter.setRowFilter(RowFilter.regexFilter(viewAll_view.viewAllSearchPanel.getUsernameField().getText()));
//        }
//            System.out.println("working");
////
////            
//        String value = viewAll_view.getViewAllSearchPanel().getUsernameField().getText();
//
//        for (int row = 0; row <= viewAll_view.getTable().getRowCount() - 1; row++) {
//
//            for (int col = 0; col <= viewAll_view.getTable().getColumnCount() - 1; col++) {
//
//                if (value.equals(viewAll_view.getTable().getValueAt(row, col))) {
//
//                    // this will automatically set the view of the scroll in the location of the value
//                    viewAll_view.getTable().scrollRectToVisible(viewAll_view.getTable().getCellRect(row, 0, true));
//
//                    // this will automatically set the focus of the searched/selected row/value
//                    viewAll_view.getTable().setRowSelectionInterval(row, row);
//
//                    for (int i = 0; i <= viewAll_view.getTable().getColumnCount() - 1; i++) {
//
//                        viewAll_view.getTable().getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
//                    }
//                }
//            }
//        }
////    }
//}
            
//            Object[][] tempData = new Object[viewAll_view.getTable().getColumnCount()][viewAll_view.getTable().getRowCount()];
//            String[] columnName = {"UserName", "Password", "Source"};
//            DefaultTableModel tempModel;
//            JTable tempTable;
//            tempModel = new DefaultTableModel(tempData, columnName);
//
//            tempTable = new JTable(tempModel);
//
//            int rowCounter = 0;
//            String value = viewAll_view.getViewAllSearchPanel().usernameField.getText();
//            for (int row = 0; row <= viewAll_view.getTable().getRowCount() - 1; row++) {
//
//                for (int col = 0; col <= viewAll_view.getTable().getColumnCount() - 1; col++) {
//
//                    if (value.equals(viewAll_view.getTable().getValueAt(row, col))) {
//                        System.out.println("found");
//                        
//                        
//                        
//                         tempData[rowCounter][col] =value;
//                         rowCounter++;
//
//                }
//                viewAll_view.setTable(new JTable(viewAll_view.getModel()));
//                viewAll_view.updateTableView(viewAll_view.getTable());
//                        
//                        tempTable
//                        rowCounter ++;
//
////                        // this will automatically set the view of the scroll in the location of the value
////                        viewAll_view.getTable().scrollRectToVisible(viewAll_view.getTable().getCellRect(row, 0, true));
////
////                        // this will automatically set the focus of the searched/selected row/value
////                        viewAll_view.getTable().setRowSelectionInterval(row, row);
////
////                        for (int i = 0; i <= viewAll_view.getTable().getColumnCount() - 1; i++) {
////
////                            viewAll_view.getTable().getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
////                        }
//                    }
//                }
//            }

//            TableRowSorter<TableModel> rowSorter
//            = new TableRowSorter<>(viewAll_view.getTable().getModel());
//            viewAll_view.getTable().setRowSorter(rowSorter);
//            rowSorter.setRowFilter(RowFilter.regexFilter(viewAll_view.getViewAllSearchPanel().usernameField.getText()));
//            
//            
//            System.out.println("working");
//            viewAll_view.getTable().setRowSelectionInterval(10, 10);
//            viewAll_view.getViewAllSearchPanel().getUsernameField().getDocument().addDocumentListener(new DocumentListener() {
//                @Override
//                  public void insertUpdate(DocumentEvent e) {
//                String text = viewAll_view.getViewAllSearchPanel().getUsernameField().getText();
//
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//
//
//                @Override
//              public void removeUpdate(DocumentEvent e) {
//                String text = viewAll_view.getViewAllSearchPanel().getUsernameField().getText();
//
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//
//                @Override
//                public void changedUpdate(DocumentEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            });
        }
    }

    class SearchButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Pass a Main View object to our Navigation View
            n_view.switchToSearchViewPanel(search_view);

            search_view.getAccountsArrayUsername().clear();
            search_view.getAccountsArrayPassword().clear();
            search_view.getAccountsArraySource().clear();
            search_view.getAccounts().removeAllItems();
            String username = "", password = "", source = "";
            try {
                FileReader fin = new FileReader("src/Accounts.txt");
                Scanner scan = new Scanner(fin);

                while (scan.hasNextLine()) {

                    username = scan.nextLine();
                    password = scan.nextLine();
                    source = scan.nextLine();

                    search_view.getAccountsArray().get(0).add(username);
                    search_view.getAccountsArray().get(1).add(password);
                    search_view.getAccountsArray().get(2).add(source);

                    search_view.accounts.addItem(username);

                }
            } catch (FileNotFoundException ex) {
                System.out.println("LoginNot Found");
            }
        }
    }

    class MasterLoginViewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Pass a Main View object to our Navigation View
            n_view.switchToMasterLoginViewPanel(masterLogin_view);
        }
    }

    class FindButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int selected = search_view.getAccounts().getSelectedIndex();
            search_view.getPasswords().setText(search_view.getAccountsArrayPassword().get(selected));
            search_view.getSource().setText(search_view.getAccountsArraySource().get(selected));
            System.out.println(selected);
        }
    }

    class CreateNewMasterButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane pane = new JOptionPane("are you sure?");
            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure?\n This Will DELETE ALL saved passwords!");

            if (resp == JOptionPane.YES_OPTION) {
                File masterLoginFile = new File("src/MasterLogin.txt");
                masterLoginFile.delete();
                File accountsFile = new File("src/Accounts.txt");
                accountsFile.delete();

                System.out.println("deleted");

                n_view.switchToCreateMasterLoginViewPanel(createMasterLogin_view);
            }
        }
    }

    class CreateAccountButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                fout = new FileWriter("src/Accounts.txt", true);
                fout.write(c_view.getUserName().getText() + "\n");
                fout.write(c_view.getPassword().getText() + "\n");
                fout.write(c_view.getSource().getText() + "\n");
                c_view.getCreateAccount().setText("Account Created");
                fout.close();
                fout.flush();
            } catch (IOException ex) {
            }
        }
    }

    class ViewAllViewButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            n_view.switchToViewAllViewPanel(viewAll_view);

            String tempUsername, tempPassword, tempSource;

            search_view.getAccountsArrayUsername().clear();
            search_view.getAccountsArrayPassword().clear();
            search_view.getAccountsArraySource().clear();
            viewAll_view.getModel().setRowCount(0);
            try {
                FileReader fin = new FileReader("src/Accounts.txt");
                Scanner scan = new Scanner(fin);
                while (scan.hasNextLine()) {

                    tempUsername = scan.nextLine();
                    tempPassword = scan.nextLine();
                    tempSource = scan.nextLine();

                    search_view.getAccountsArray().get(0).add(tempUsername);
                    search_view.getAccountsArray().get(1).add(tempPassword);
                    search_view.getAccountsArray().get(2).add(tempSource);

                    viewAll_view.getModel().addRow(new Object[]{tempUsername, tempPassword, tempSource});

                }
                viewAll_view.setTable(new JTable(viewAll_view.getModel()));
                viewAll_view.updateTableView(viewAll_view.getTable());
            } catch (FileNotFoundException ex) {
                System.out.println("InfoNotFound");
            }
        }
    }

    class GenRandPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenPass(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerUpperNums(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerUpperSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerNumsSpecial(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenUpperNumsSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerNums(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerSpecial(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(g.GenUpperNums(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenUpperSpecial(10));
            } else if (c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenNumsSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerUpper(10));
            } else if (c_view.getLower().isSelected() == true) {
                c_view.getPassword().setText(g.GenLower(10));
            } else if (c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(g.GenNum(10));
            } else if (c_view.getUpper().isSelected() == true) {
                c_view.getPassword().setText(g.GenUpper(10));
            } else if (c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenSpecial(10));
            } else {
                c_view.getPassword().setText(g.GenPass(10));
            }
        }
    }

    class GenRandUserButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            c_view.getUserName().setText(g.GenLowerUpperNums(10));
        }
    }

    class MasterPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String username = "", password = "";
            try {
                FileReader fin = new FileReader("src/MasterLogin.txt");
                Scanner scan = new Scanner(fin);

                username = scan.nextLine();
                password = scan.nextLine();
            } catch (FileNotFoundException ex) {
                masterLogin_view.loginStatus.setText("Account Not Found");
            }
            if (masterLogin_view.getUserName().getText().equalsIgnoreCase(username) && String.valueOf(masterLogin_view.getPassword().getPassword()).equalsIgnoreCase(password)) {

                n_view.addCreateButtonListener(new CreateViewButtonListener());
                c_view.addCreateAccountListener(new CreateAccountButtonListener());
                c_view.addgenRandPassAccountListener(new GenRandPassButtonListener());
                c_view.addgenRandUserAccountListener(new GenRandUserButtonListener());
                n_view.addSearchButtonListener(new SearchButtonListener());
                n_view.addViewAllViewButtonListener(new ViewAllViewButtonListener());

                n_view.nVpanel.getMenu().getLoginButton().setVisible(false);

                n_view.nVpanel.getMenu().createMaster.setVisible(false);
                n_view.nVpanel.getMenu().getCreateButton().setVisible(true);
                n_view.nVpanel.getMenu().getDeleteButton().setVisible(true);
                n_view.nVpanel.getMenu().getViewButton().setVisible(true);
                n_view.nVpanel.getMenu().getSearchButton().setVisible(true);

                masterLogin_view.getLoginStatus().setText("Logged In");
            } else {
                masterLogin_view.getLoginStatus().setText("Error, Wrong Password or Username");
                try {
                    FileReader fin = new FileReader("src/MasterLogin.txt");
                } catch (FileNotFoundException ex) {
                    masterLogin_view.loginStatus.setText("Account Not Found");
                }
            }

        }

    }

}
