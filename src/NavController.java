
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

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

        viewAll_view.getViewAllSearchPanel().addDeleteButtonListener(new ViewAllDeleteButtonListener());
        viewAll_view.getViewAllSearchPanel().addEditButtonListener(new ViewAllEditButtonListener());
        viewAll_view.getViewAllSearchPanel().addSaveEditButtonListener(new ViewAllSaveEditButtonListener());
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
                int tempColumn = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedColumn());
                System.out.println("Row, " + tempRow + ", " + tempColumn);

                try {
                    fout = new FileWriter("src/Accounts.txt");
                    for (int i = 0; i < viewAll_view.getTable().getRowCount(); i++) {

                        for (int j = 0; j < viewAll_view.getTable().getColumnCount(); j++) {

                            if(i != tempRow){
                            System.out.println(viewAll_view.getTable().getValueAt(i, j));
                            fout.write(viewAll_view.getTable().getValueAt(i, j) + "\n");
                            }
                        }
                    }
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
                int tempColumn = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedColumn());
                System.out.println("Row, " + tempRow + ", " + tempColumn);
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

                try {
                    fout = new FileWriter("src/Accounts.txt");
                    for (int i = 0; i < viewAll_view.getTable().getRowCount(); i++) {

                        for (int j = 0; j < viewAll_view.getTable().getColumnCount(); j++) {

                            System.out.println(viewAll_view.getTable().getValueAt(i, j));
                            fout.write(viewAll_view.getTable().getValueAt(i, j) + "\n");
                        }
                    }
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
                viewAll_view.setModel(viewAll_view.getModel());
                  fin.close();
//                viewAll_view.setTable(new JTable(viewAll_view.getModel()));
//                viewAll_view.updateTableView(viewAll_view.getTable());
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
            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure?\nThis Will DELETE ALL saved passwords!");

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

    class SaveButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane pane = new JOptionPane("Do you want to save?");
            int resp = JOptionPane.showConfirmDialog(null, "Do you want to save?\n After saving it is safe to exit program.");

            if (resp == JOptionPane.YES_OPTION) {
                try {
                    FileInputStream inFile = new FileInputStream("Account1.txt");
                    FileOutputStream outFile = new FileOutputStream("encryptedfile.des");
                    String password = "javapaper";
                    byte[] salt = new byte[8];
                    SecureRandom secureRandom = new SecureRandom();
                    secureRandom.nextBytes(salt);
                    FileOutputStream saltOutFile = new FileOutputStream("salt.enc");
                    saltOutFile.write(salt);
                    saltOutFile.close();

                    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                    KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
                    SecretKey secretKey = factory.generateSecret(keySpec);
                    SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(Cipher.ENCRYPT_MODE, secret);
                    AlgorithmParameters params = cipher.getParameters();

                    FileOutputStream ivOutFile = new FileOutputStream("iv.enc");
                    byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
                    ivOutFile.write(iv);
                    ivOutFile.close();

                    byte[] input = new byte[64];
                    int byteRead;

                    while ((byteRead = inFile.read(input)) != -1) {
                        byte[] output = cipher.update(input, 0, byteRead);
                        if (output != null) {
                            outFile.write(output);
                        }
                    }

                    byte[] output = cipher.doFinal();
                    if (output != null) {
                        outFile.write(output);
                    }

                    inFile.close();
                    outFile.flush();
                    outFile.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidParameterSpecException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadPaddingException ex) {
                    Logger.getLogger(NavController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                viewAll_view.setModel(viewAll_view.getModel());
//                viewAll_view.setTable(new JTable(viewAll_view.getModel()));
//                viewAll_view.updateTableView(viewAll_view.getTable());
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
            String tempUsername, tempPassword, tempSource;
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
                n_view.addSaveButtonListener(new SaveButtonListener());

                n_view.nVpanel.getMenu().getLoginButton().setVisible(false);

                n_view.nVpanel.getMenu().createMaster.setVisible(false);
                n_view.nVpanel.getMenu().getCreateButton().setVisible(true);
                n_view.nVpanel.getMenu().getDeleteButton().setVisible(true);
                n_view.nVpanel.getMenu().getViewButton().setVisible(true);
                n_view.nVpanel.getMenu().getSearchButton().setVisible(true);
                n_view.nVpanel.getMenu().getSaveButton().setVisible(true);

                File file = new File("src/Accounts1.txt");
                file.delete();

                try {
                    FileReader fin1 = new FileReader("src/Accounts.txt");
                    Scanner scn = new Scanner(fin1);
                    while (scn.hasNextLine()) {
                        fout = new FileWriter("src/Accounts1.txt", true);
                        tempUsername = scn.nextLine();
                        tempPassword = scn.nextLine();
                        tempSource = scn.nextLine();

                        fout.write(tempUsername + "\n");
                        fout.write(tempPassword + "\n");
                        fout.write(tempSource + "\n");
                        fout.flush();
                    }

                } catch (FileNotFoundException ex) {

                } catch (IOException ex) {

                }

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
