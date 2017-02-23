
import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JTable;

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

            File file = new File("src/MasterLogin.txt");
            file.delete();

            System.out.println("deleted");

            n_view.switchToCreateMasterLoginViewPanel(createMasterLogin_view);
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
            int tempCounter = 0;
            viewAll_view.getModel().setRowCount(0);
            try {
                FileReader fin = new FileReader("src/Accounts.txt");
                Scanner scan = new Scanner(fin);
//                Object[][] tempObject = new Object[100][3];
                while (scan.hasNextLine()) {

                    tempUsername = scan.nextLine();
                    tempPassword = scan.nextLine();
                    tempSource = scan.nextLine();

                    search_view.getAccountsArray().get(0).add(tempUsername);
                    search_view.getAccountsArray().get(1).add(tempPassword);
                    search_view.getAccountsArray().get(2).add(tempSource);

//                    tempObject = new Object[search_view.getAccountsArray().size()][3];
                    viewAll_view.getModel().addRow(new Object[]{tempUsername, tempPassword, tempSource});
                    
                    tempCounter++;
                }
                viewAll_view.setTable(new JTable(viewAll_view.getModel()));
                viewAll_view.updateTableView(viewAll_view.getTable());
//                viewAll_view.setData(tempObject);
            } catch (FileNotFoundException ex) {
                System.out.println("InfoNotFound");
            }
        }
    }

    class GenRandPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (c_view.getLower().isSelected() == true) {
                c_view.getPassword().setText(g.GenLower(10));
            } else if (c_view.getUpper().isSelected() == true) {
                c_view.getPassword().setText(g.GenUpper(10));
            } else if (c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(g.GenNum(10));
            } else if (c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerUpper(10));
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
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerUpperNums(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getUpper().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerUpperSpecial(10));
            } else if (c_view.getLower().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenLowerNumsSpecial(10));
            } else if (c_view.getUpper().isSelected() == true && c_view.getNumber().isSelected() == true && c_view.getSpecial().isSelected() == true) {
                c_view.getPassword().setText(g.GenUpperNumsSpecial(10));
            } else {
                c_view.getPassword().setText(g.GenPass(10));
            }
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
                masterLogin_view.getLoginStatus().setText("Error, Wronge Password or Username");
                try {
                    FileReader fin = new FileReader("src/MasterLogin.txt");
                } catch (FileNotFoundException ex) {
                    masterLogin_view.loginStatus.setText("Account Not Found");
                }
            }

        }

    }

}
