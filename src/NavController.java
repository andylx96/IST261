
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NavController {

    NavModel n_model;
    NavView n_view;

    CreateView c_view;
    MasterLoginView masterLogin_view;
    GeneratePass generate;
    ArrayList<Accounts> accountsArray;
    Accounts masterAccount;
    SearchView search_view;
    FileWriter fout;

    ViewAllView viewAll_view;
    CreateMasterLoginView createMasterLogin_view;
    EncryptionClass encryption;

    String key = "squirrel123"; // needs to be at least 8 characters for DES

    public NavController(NavModel n_model, NavView n_view) throws Throwable {
        this.n_model = n_model;
        this.n_view = n_view;

        encryption = new EncryptionClass();

        c_view = new CreateView();
        masterLogin_view = new MasterLoginView();
        generate = new GeneratePass();
        search_view = new SearchView();
        viewAll_view = new ViewAllView();
        createMasterLogin_view = new CreateMasterLoginView();

        masterLogin_view.addMasterLoginListener(new MasterPassButtonListener());

        n_view.addMasterButtonListener(new MasterLoginViewListener());
        n_view.addCreateMasterButtonListener(new CreateNewMasterButtonListener());
        createMasterLogin_view.addCreateMasterLoginListener(new CreateMasterLoginButtonListener());
        search_view.getFindButton().addActionListener(new FindButtonListener());

        viewAll_view.getViewAllSearchPanel().addDeleteButtonListener(new ViewAllDeleteButtonListener());
        viewAll_view.getViewAllSearchPanel().addEditButtonListener(new ViewAllEditButtonListener());
        viewAll_view.getViewAllSearchPanel().addSaveEditButtonListener(new ViewAllSaveEditButtonListener());
        viewAll_view.getSearchArea().getDocument().addDocumentListener(new ViewAllViewSearchDocumentListener());
        n_view.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane pane = new JOptionPane("Do you want to exit?");
                int resp = JOptionPane.showConfirmDialog(null, "Do you want to exit?\n DID YOU REMEMBER TO SAVE?");
                if (resp == JOptionPane.YES_OPTION) {
                    File tempFile = new File("src/temp.txt");
                    tempFile.delete();
                    System.exit(0);
                }

            }
        });
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

    class ViewAllDeleteButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete Working");
            if (viewAll_view.getTable().getSelectedRow() != -1) {
                int tempRow = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedRow());
                String tempString = viewAll_view.getSearchArea().getText();
                viewAll_view.getSearchArea().setText("");

                try {
                    fout = new FileWriter("src/temp.txt");
                    for (int i = 0; i < viewAll_view.getTable().getRowCount(); i++) {

                        for (int j = 0; j < viewAll_view.getTable().getColumnCount(); j++) {

                            if (i != tempRow) {
                                System.out.println(viewAll_view.getTable().getValueAt(i, j));
                                fout.write(viewAll_view.getTable().getValueAt(i, j) + "\n");
                            }
                        }
                    }
                    viewAll_view.getSearchArea().setText(tempString);
                    c_view.getCreateAccount().setText("Account Created");
                    fout.close();
                    fout.flush();
                } catch (IOException ex) {
                }

            }

            String tempUsername, tempPassword, tempSource;

            search_view.getAccountsArrayUsername().clear();
            search_view.getAccountsArrayPassword().clear();
            search_view.getAccountsArraySource().clear();
            viewAll_view.getModel().setRowCount(0);
            try {
                FileReader fin = new FileReader("src/temp.txt");
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
                viewAll_view.setModel(viewAll_view.getModel());
                fin.close();
//                viewAll_view.setTable(new JTable(viewAll_view.getModel()));
//                viewAll_view.updateTableView(viewAll_view.getTable());
            } catch (FileNotFoundException ex) {
                System.out.println("InfoNotFound");
            } catch (IOException ex) {
                System.out.println("Cannot Close");
            }

        }
    }

    class ViewAllEditButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            System.out.println("Delete Working");
            if (viewAll_view.getTable().getSelectedRow() != -1) {
                int tempRow = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedRow());
            }
            viewAll_view.getViewAllSearchPanel().getSaveEditButton().setVisible(true);
        }
    }

    class ViewAllSaveEditButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete Working");
            if (viewAll_view.getTable().getSelectedRow() != -1) {
                int tempRow = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedRow());
                int tempColumn = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedColumn());
                System.out.println("Row, " + tempRow + ", " + tempColumn);

                String tempString = viewAll_view.getSearchArea().getText();
                viewAll_view.getSearchArea().setText("");

                try {
                    fout = new FileWriter("src/temp.txt");

                    for (int i = 0; i < viewAll_view.getTable().getRowCount(); i++) {

                        for (int j = 0; j < viewAll_view.getTable().getColumnCount(); j++) {

                            System.out.println(viewAll_view.getTable().getValueAt(i, j));
                            fout.write(viewAll_view.getTable().getValueAt(i, j) + "\n");
                        }
                    }

                    viewAll_view.getSearchArea().setText(tempString);
                    c_view.getCreateAccount().setText("Account Created");
                    fout.close();
                    fout.flush();
                } catch (IOException ex) {
                }

            }

            String tempUsername, tempPassword, tempSource;

            search_view.getAccountsArrayUsername().clear();
            search_view.getAccountsArrayPassword().clear();
            search_view.getAccountsArraySource().clear();
            viewAll_view.getModel().setRowCount(0);
            try {
                FileReader fin = new FileReader("src/temp.txt");
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
                viewAll_view.setModel(viewAll_view.getModel());
                fin.close();
            } catch (FileNotFoundException ex) {
                System.out.println("InfoNotFound");
            } catch (IOException ex) {
                System.out.println("InfoNotFound");
            }

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
                FileReader fin = new FileReader("src/temp.txt");
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
            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure?\nThis Will DELETE ALL saved passwords!");

            if (resp == JOptionPane.YES_OPTION) {
                File masterLoginFile = new File("src/MasterLogin.txt");
                masterLoginFile.delete();
                File accountsFile = new File("src/Accounts.txt");

                accountsFile.delete();

                System.out.println("deleted");

                try {

                    fout = new FileWriter("src/Accounts.txt");
                    FileInputStream fis = new FileInputStream("src/Accounts.txt");

                    FileOutputStream fos = new FileOutputStream("src/Accounts.txt");
                    encryption.encrypt(key, fis, fos);

                } catch (FileNotFoundException ex) {
                    System.out.println("LOL");
                } catch (Throwable ex) {
//                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                }

                n_view.switchToCreateMasterLoginViewPanel(createMasterLogin_view);
            }
        }
    }

    class SaveButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane pane = new JOptionPane("Do you want to save?");
            int resp = JOptionPane.showConfirmDialog(null, "Do you want to save?\n After saving it is safe to exit the program.");

            if (resp == JOptionPane.YES_OPTION) {

                try {

                    FileInputStream fis = new FileInputStream("src/temp.txt");
                    FileOutputStream fos = new FileOutputStream("src/Accounts.txt");
                    encryption.encrypt(key, fis, fos);

                } catch (Throwable z) {
                    z.printStackTrace();
                }
            }
        }
    }

    class CreateAccountButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                fout = new FileWriter("src/temp.txt", true);
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
                FileReader fin = new FileReader("src/temp.txt");
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
                fin.close();
                viewAll_view.setModel(viewAll_view.getModel());

            } catch (FileNotFoundException ex) {
                System.out.println("InfoNotFound");
            } catch (IOException ex) {
                System.out.println("cannot close");
            }
        }
    }

    class GenRandPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenPass(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLowerUpperNums(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLowerUpperSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLowerNumsSpecial(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenUpperNumsSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLowerNums(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLowerSpecial(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(generate.GenUpperNums(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenUpperSpecial(10));
            } else if (c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenNumsSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLowerUpper(10));
            } else if (c_view.getLower().isSelected() == true) {
                c_view.getPassword().setText(generate.GenLower(10));
            } else if (c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(generate.GenNum(10));
            } else if (c_view.getUpper().isSelected() == true) {
                c_view.getPassword().setText(generate.GenUpper(10));
            } else if (c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(generate.GenSpecial(10));
            } else {
                c_view.getPassword().setText(generate.GenPass(10));
            }
        }
    }

    class GenRandUserButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            c_view.getUserName().setText(generate.GenLowerUpperNums(10));
        }
    }

    class MasterPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String username = "", password = "";
            String tempUsername, tempPassword, tempSource;
            try {
                FileReader fin = new FileReader("src/MasterLogin.txt");
                Scanner scan = new Scanner(fin);

                username = scan.nextLine();
                password = scan.nextLine();
            } catch (FileNotFoundException ex) {
                masterLogin_view.loginStatus.setText("Account Not Found");
            }
            if (masterLogin_view.getUserName().getText().equals(username) && String.valueOf(masterLogin_view.getPassword().getPassword()).equals(password)) {

                try {

                    FileInputStream fis2 = new FileInputStream("src/Accounts.txt");

                    FileOutputStream fos2 = new FileOutputStream("src/temp.txt");
                    encryption.decrypt(key, fis2, fos2);

                } catch (FileNotFoundException ex) {
                    System.out.println("Eror");
                } catch (Throwable ex) {
                    System.out.println("Eror");
                }

                n_view.addCreateButtonListener(new CreateViewButtonListener());
                c_view.addCreateAccountListener(new CreateAccountButtonListener());
                c_view.addgenRandPassAccountListener(new GenRandPassButtonListener());
                c_view.addgenRandUserAccountListener(new GenRandUserButtonListener());
                n_view.addSearchButtonListener(new SearchButtonListener());
                n_view.addViewAllViewButtonListener(new ViewAllViewButtonListener());
                n_view.addSaveButtonListener(new SaveButtonListener());

                n_view.nVpanel.getMenu().getLoginButton().setVisible(false);

                n_view.nVpanel.getMenu().createMaster.setVisible(false);
                n_view.nVpanel.getMenu().getCreateButton().setVisible(true);
//                n_view.nVpanel.getMenu().getDeleteButton().setVisible(true);
                n_view.nVpanel.getMenu().getViewButton().setVisible(true);
                n_view.nVpanel.getMenu().getSearchButton().setVisible(true);
                n_view.nVpanel.getMenu().getSaveButton().setVisible(true);

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

    class ViewAllViewSearchDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e
        ) {
            String text = viewAll_view.getSearchArea().getText();

            if (text.trim().length() == 0) {
                viewAll_view.getRowSorter().setRowFilter(null);
            } else {
                viewAll_view.getRowSorter().setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e
        ) {
            String text = viewAll_view.getSearchArea().getText();

            if (text.trim().length() == 0) {
                viewAll_view.getRowSorter().setRowFilter(null);
            } else {
                viewAll_view.getRowSorter().setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
