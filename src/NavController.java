

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NavController {

    NavModel n_model;
    NavView n_view;

    CreateView create_view;
    MasterLoginView masterLogin_view;
    GeneratePass generate;
    ArrayList<Accounts> accountsArray;
    Accounts masterAccount;
//    SearchView search_view;
    FileWriter fout;

    ViewAllView viewAll_view;
    CreateMasterLoginView createMasterLogin_view;
    EncryptionClass encryption;
    InstructionView instruction_view;

    HelpModel help_model;
    HelpFrame help_frame;
    HelpController help_controller;
    Accounts accounts;

    String key = "squirrel123"; // needs to be at least 8 characters for DES

    public NavController(NavModel n_model, NavView n_view) throws Throwable {
        this.n_model = n_model;
        this.n_view = n_view;

        encryption = new EncryptionClass();
        instruction_view = new InstructionView();
        create_view = new CreateView();
        masterLogin_view = new MasterLoginView();
        generate = new GeneratePass();
        viewAll_view = new ViewAllView();
        createMasterLogin_view = new CreateMasterLoginView();
        accounts = new Accounts();

        n_view.addMasterButtonListener(new MasterLoginViewListener());
        masterLogin_view.getSignup().addActionListener(new CreateNewMasterButtonListener());
        createMasterLogin_view.addCreateMasterLoginListener(new CreateMasterLoginButtonListener());
        masterLogin_view.addMasterLoginListener(new MasterPassButtonListener());

        n_view.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane pane = new JOptionPane("Do you want to exit?");
                int resp = JOptionPane.showConfirmDialog(null, "Do you want to exit?\n DID YOU REMEMBER TO SAVE?");
                if (resp == JOptionPane.YES_OPTION) {
                    File tempFile = new File("src/temp.txt");
                    File tempFile2 = new File("src/MasterTemp.txt");
                    tempFile.delete();
                    tempFile2.delete();
                    System.exit(0);
                }
            }
        });
    }

    class MasterLoginViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            n_view.switchToMasterLoginViewPanel(masterLogin_view);
            n_view.nVpanel.getMenu().getLoginButton().setVisible(false);

        }
    }

    class CreateNewMasterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane pane = new JOptionPane("are you sure?");
            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure?\nThis Will DELETE ALL saved passwords!");

            if (resp == JOptionPane.YES_OPTION) {
                File masterLoginFile = new File("src/MasterLogin.txt");
                masterLoginFile.delete();
                File accountsFile = new File("src/Accounts.txt");
                accountsFile.delete();
                try {
                    FileWriter accfout = new FileWriter("src/Accounts.txt");
                    FileWriter passfout = new FileWriter("src/MasterLogin.txt");
                    FileInputStream fis = new FileInputStream("src/Accounts.txt");
                    FileOutputStream fos = new FileOutputStream("src/Accounts.txt");
                    FileInputStream fis4 = new FileInputStream("src/MasterLogin.txt");
                    FileOutputStream fos4 = new FileOutputStream("src/MasterLogin.txt");
                    encryption.encrypt(key, fis, fos);
                    encryption.encrypt(key, fis4, fos4);
                    accfout.flush();
                    accfout.close();
                    passfout.flush();
                    passfout.close();
                    fis.close();
                    fos.close();
                    fis4.close();
                    fos4.close();
                } catch (FileNotFoundException ex) {
                } catch (Throwable ex) {
                }
                n_view.switchToCreateMasterLoginViewPanel(createMasterLogin_view);
            }
        }
    }

    class CreateMasterLoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                try {
                    FileInputStream fis3Master = new FileInputStream("src/MasterLogin.txt");
                    FileOutputStream fos3Master = new FileOutputStream("src/MasterTemp.txt");
                    encryption.decrypt(key, fis3Master, fos3Master);
                    fis3Master.close();
                    fos3Master.close();
                } catch (FileNotFoundException ex) {
                } catch (Throwable ex) {
                }
                fout = new FileWriter("src/MasterTemp.txt", true);
                fout.write(createMasterLogin_view.getUserName().getText() + "\n");
                fout.write(createMasterLogin_view.getPassword().getText() + "\n");
                createMasterLogin_view.getCreateStatus().setText("Account Created");
                JOptionPane.showMessageDialog(null, "Master Login Has Been Created!");
                n_view.switchToMasterLoginViewPanel(masterLogin_view);

                fout.flush();
                fout.close();
                try {
                    FileInputStream fis5 = new FileInputStream("src/MasterTemp.txt");
                    FileOutputStream fos5 = new FileOutputStream("src/MasterLogin.txt");
                    encryption.encrypt(key, fis5, fos5);
                    fis5.close();
                    fos5.close();
                } catch (FileNotFoundException ex) {
                } catch (Throwable ex) {
                }
                File tempFile4 = new File("src/masterTemp.txt");
                tempFile4.delete();
            } catch (IOException ex) {
            }
        }
    }

    class MasterPassButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                FileInputStream fisMaster = new FileInputStream("src/MasterLogin.txt");
                FileOutputStream fosMaster = new FileOutputStream("src/MasterTemp.txt");
                encryption.decrypt(key, fisMaster, fosMaster);
                fisMaster.close();
                fosMaster.close();
            } catch (FileNotFoundException ex) {
            } catch (Throwable ex) {
            }
            String username = "", password = "";
            String tempUsername, tempPassword, tempSource;
            try {
                FileReader fin = new FileReader("src/MasterTemp.txt");
                Scanner scan = new Scanner(fin);
                while (scan.hasNextLine()) {
                    username = scan.nextLine();
                    password = scan.nextLine();
                    fin.close();
                }
            } catch (FileNotFoundException ex) {
                masterLogin_view.loginStatus.setText("Account Not Found");
            } catch (IOException ex) {
            }
            if (masterLogin_view.getUserName().getText().equals(username)
                    && String.valueOf(masterLogin_view.getPassword().getPassword()).equals(password)) {
                File tempMasterFile = new File("src/MasterTemp.txt");
                tempMasterFile.delete();
                try {
                    FileInputStream fis2 = new FileInputStream("src/Accounts.txt");
                    FileOutputStream fos2 = new FileOutputStream("src/temp.txt");
                    encryption.decrypt(key, fis2, fos2);
                    fis2.close();
                    fos2.close();
                } catch (FileNotFoundException ex) {
                    masterLogin_view.loginStatus.setText("Account Not Found");
                } catch (Throwable ex) {
                    masterLogin_view.loginStatus.setText("Account Not Found");
                }

                n_view.addCreateButtonListener(new CreateViewButtonListener());
                n_view.addInstructionButtonListener(new InstructionButtonListener());
                n_view.addViewAllViewButtonListener(new ViewAllViewButtonListener());
                n_view.addSaveButtonListener(new SaveButtonListener());
                instruction_view.getClickHere().addActionListener(new HelpButtonListener());
                create_view.addCreateAccountListener(new CreateAccountButtonListener());
                create_view.addgenRandPassAccountListener(new GenRandPassButtonListener());
                create_view.addgenRandUserAccountListener(new GenRandUserButtonListener());
                viewAll_view.getViewAllSearchPanel().addDeleteButtonListener(new ViewAllDeleteButtonListener());
                viewAll_view.getViewAllSearchPanel().addEditButtonListener(new ViewAllEditButtonListener());
                viewAll_view.getViewAllSearchPanel().addSaveEditButtonListener(new ViewAllSaveEditButtonListener());
                viewAll_view.getSearchArea().getDocument().addDocumentListener(new ViewAllViewSearchDocumentListener());
                n_view.nVpanel.getMenu().getLoginButton().setVisible(false);
                n_view.nVpanel.getMenu().createMaster.setVisible(false);
                n_view.nVpanel.getMenu().getCreateButton().setVisible(true);
                n_view.nVpanel.getMenu().getViewButton().setVisible(true);
                n_view.nVpanel.getMenu().getInstructionButton().setVisible(true);
                n_view.nVpanel.getMenu().getSaveButton().setVisible(true);
                masterLogin_view.getSignup().setVisible(false);
                masterLogin_view.getLoginButton().setVisible(false);

                n_view.switchToInstructionView(instruction_view);

            } else {
                masterLogin_view.getLoginStatus().setText("Error, Wrong Password or Username");
                File tempMasterFile2 = new File("src/MasterTemp.txt");
                tempMasterFile2.delete();
            }

        }
    }

    class CreateViewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            n_view.switchToCreateViewPanel(create_view);
        }
    }

    class InstructionButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            n_view.switchToInstructionView(instruction_view);
        }
    }

    class CreateAccountButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                fout = new FileWriter("src/temp.txt", true);
                fout.write(create_view.getUserName().getText() + "\n");
                fout.write(create_view.getPassword().getText() + "\n");
                fout.write(create_view.getSource().getText() + "\n");
                JOptionPane.showMessageDialog(null, "Account Created");
                fout.close();
                fout.flush();
            } catch (IOException ex) {
            }
        }
    }

    class ViewAllEditButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (viewAll_view.getTable().getSelectedRow() != -1) {
                int tempRow = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedRow());
            }
        }
    }

    class ViewAllDeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete This Line?");
            if (resp == JOptionPane.YES_OPTION) {

                if (viewAll_view.getTable().getSelectedRow() != -1) {
                    int tempRow = viewAll_view.getTable().convertRowIndexToModel(viewAll_view.getTable().getSelectedRow());
                    tableToFile(tempRow);
                    updateArrayAndTable();
                }
                else if(viewAll_view.getTable().getSelectedRow() == -1)
                {JOptionPane.showMessageDialog(null, "Please Selected A Row First");}
            }
        }
    }

    class ViewAllSaveEditButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            viewAll_view.getTable().changeSelection(-1, -1, true, true);
            int temp = JOptionPane.showConfirmDialog(null, "Are you sure?");

            if (temp == JOptionPane.YES_OPTION) {
                tableToFile(-1);
                updateArrayAndTable();
            }
        }
    }

    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane pane = new JOptionPane("Do you want to save?");
            int resp = JOptionPane.showConfirmDialog(null, "Do you want to save?\n After saving it is safe to exit the program.");
            if (resp == JOptionPane.YES_OPTION) {

                try {

                    FileInputStream fis = new FileInputStream("src/temp.txt");
                    FileOutputStream fos = new FileOutputStream("src/Accounts.txt");
                    encryption.encrypt(key, fis, fos);
                } catch (Throwable z) {

                    JOptionPane.showMessageDialog(null, z);
                }
            }
        }
    }

    class ViewAllViewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            n_view.switchToViewAllViewPanel(viewAll_view);

            String tempUsername, tempPassword, tempSource;

            accounts.getAccountsArrayUsername().clear();
            accounts.getAccountsArrayPassword().clear();
            accounts.getAccountsArraySource().clear();
            viewAll_view.getModel().setRowCount(0);
            try {
                FileReader fin;
                fin = new FileReader("src/temp.txt");
                Scanner scan = new Scanner(fin);
                while (scan.hasNextLine()) {

                    tempUsername = scan.nextLine();
                    tempPassword = scan.nextLine();
                    tempSource = scan.nextLine();

                    accounts.getAccountsArray().get(0).add(tempUsername);
                    accounts.getAccountsArray().get(1).add(tempPassword);
                    accounts.getAccountsArray().get(2).add(tempSource);

                    viewAll_view.getModel().addRow(new Object[]{tempUsername, tempPassword, tempSource});

                }
                fin.close();
                viewAll_view.setModel(viewAll_view.getModel());

            } catch (FileNotFoundException ex) {

                JOptionPane.showMessageDialog(null, ex);
            } catch (IOException ex) {
            }
        }
    }

    class GenRandUserButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            create_view.getUserName().setText(generate.GenLowerUpperNums(10));
        }
    }

    class HelpButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            help_model = new HelpModel();
            help_frame = new HelpFrame(help_model);
            help_controller = new HelpController(help_model, help_frame);
            help_frame.setVisible(true);

        }
    }

    class GenRandPassButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (create_view.getLower().isSelected() == true && create_view.getUpper().isSelected() == true && create_view.getNumber().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenPass(10));
            } else if (create_view.getLower().isSelected() == true && create_view.getUpper().isSelected() == true && create_view.getNumber().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLowerUpperNums(10));
            } else if (create_view.getLower().isSelected() == true && create_view.getUpper().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLowerUpperSpecial(10));
            } else if (create_view.getLower().isSelected() == true && create_view.getNumber().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLowerNumsSpecial(10));
            } else if (create_view.getUpper().isSelected() == true && create_view.getNumber().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenUpperNumsSpecial(10));
            } else if (create_view.getLower().isSelected() == true && create_view.getNumber().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLowerNums(10));
            } else if (create_view.getLower().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLowerSpecial(10));
            } else if (create_view.getUpper().isSelected() == true && create_view.getNumber().isSelected() == true) {
                create_view.getPassword().setText(generate.GenUpperNums(10));
            } else if (create_view.getUpper().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenUpperSpecial(10));
            } else if (create_view.getNumber().isSelected() == true && create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenNumsSpecial(10));
            } else if (create_view.getLower().isSelected() == true && create_view.getUpper().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLowerUpper(10));
            } else if (create_view.getLower().isSelected() == true) {
                create_view.getPassword().setText(generate.GenLower(10));
            } else if (create_view.getNumber().isSelected() == true) {
                create_view.getPassword().setText(generate.GenNum(10));
            } else if (create_view.getUpper().isSelected() == true) {
                create_view.getPassword().setText(generate.GenUpper(10));
            } else if (create_view.getSpecial().isSelected() == true) {
                create_view.getPassword().setText(generate.GenSpecial(10));
            } else {
                JOptionPane.showMessageDialog(null, "Please select your password criteria");
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
            JOptionPane.showMessageDialog(null, "Not supported yet.");
        }
    }

    public void updateArrayAndTable() {

        String tempUsername, tempPassword, tempSource;
        accounts.getAccountsArrayUsername().clear();
        accounts.getAccountsArrayPassword().clear();
        accounts.getAccountsArraySource().clear();
        viewAll_view.getModel().setRowCount(0);
        try {
            FileReader fin;
            fin = new FileReader("src/temp.txt");
            Scanner scan = new Scanner(fin);
            while (scan.hasNextLine()) {

                tempUsername = scan.nextLine();
                tempPassword = scan.nextLine();
                tempSource = scan.nextLine();

                accounts.getAccountsArray().get(0).add(tempUsername);
                accounts.getAccountsArray().get(1).add(tempPassword);
                accounts.getAccountsArray().get(2).add(tempSource);

                viewAll_view.getModel().addRow(new Object[]{tempUsername, tempPassword, tempSource});
            }
            viewAll_view.setModel(viewAll_view.getModel());
            fin.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
        }
    }

    public void tableToFile(int tempRow) {

        if (viewAll_view.getTable().getSelectedRow() != -1) {
            String tempString = viewAll_view.getSearchArea().getText();
            viewAll_view.getSearchArea().setText("");
            try {
                fout = new FileWriter("src/temp.txt");
                for (int i = 0; i < viewAll_view.getTable().getRowCount(); i++) {
                    for (int j = 0; j < viewAll_view.getTable().getColumnCount(); j++) {
                        if (i != tempRow) {
                            fout.write(viewAll_view.getTable().getValueAt(i, j) + "\n");
                        }
                    }
                }
                viewAll_view.getSearchArea().setText(tempString);
                create_view.getCreateAccount().setText("Account Created");
                fout.close();
                fout.flush();
            } catch (IOException ex) {
            }
        }
    }

}
