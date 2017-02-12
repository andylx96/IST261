
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComboBox;

public class NavController {

    NavModel n_model;
    NavView n_view;
    //Instance Variables for Options Model, View, and Controller

    // TODO: Create instances of your MainModel and MainController once you implement them
    CreateView c_view;
    MasterLoginView masterLogin_view;
    GeneratePass g;
    ArrayList<Accounts> accountsArray;
    Accounts masterAccount;
    SearchView search_view;
    FileWriter fout;

    public NavController(NavModel n_model, NavView n_view) {
        this.n_model = n_model;
        this.n_view = n_view;

        c_view = new CreateView();
        masterLogin_view = new MasterLoginView();
        g = new GeneratePass();
        search_view = new SearchView();

        n_view.addOptionsButtonListener(new MasterLoginViewListener());

        search_view.getFindButton().addActionListener(new FindButtonListener());
        masterLogin_view.addMasterLoginListener(new MasterPassButtonListener());

    }

    class MainButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Pass a Main View object to our Navigation View
            n_view.switchToMainPanel(c_view);
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

//            search_view.setAccounts(new JComboBox(search_view.getAccountsArray().get(0).toArray()));
//            System.out.println(search_view.getAccountsArray().get(0));
//            search_view.addNewCombo(new JComboBox(search_view.getAccountsArray().get(0).toArray()));
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
            int selected = search_view.accounts.getSelectedIndex();
            search_view.getPasswords().setText(search_view.getAccountsArrayPassword().get(selected));
            search_view.getSource().setText(search_view.getAccountsArraySource().get(selected));
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

//            String username = "", password = "", source = "";
//            try {
//                FileReader fin = new FileReader("src/Accounts.txt");
//                Scanner scan = new Scanner(fin);
//
//                username = scan.nextLine();
//                password = scan.nextLine();
//                source = scan.nextLine();
//
//            } catch (FileNotFoundException ex) {
//                System.out.println("LoginNot Found");
//            }
        }
    }

    class GenRandPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            c_view.getPassword().setText(g.GenPass(10));
        }

    }

    class MasterPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String masterUsername, masterPassword, masterDomain;

//            masterAccount = new Account();
//      Employee[] staff = new Employee[3];
//      staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
//      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//      staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
//
//      // save all employee records to the file employee.dat
//      try (PrintWriter out = new PrintWriter("employee.dat", "UTF-8"))
//      {         
//         writeData(staff, out);
//      }
//      
            // retrieve all records into a new array
//      try (Scanner in = new Scanner(
//            new FileInputStream("employee.dat"), "UTF-8"))
//      {
//         Employee[] newStaff = readData(in);
//
//       c  // print the newly read employee records
//         for (Employee e : newStaff)
//            System.out.println(e);
//      }
            String username = "", password = "";
            try {
                FileReader fin = new FileReader("src/MasterLogin.txt");
                Scanner scan = new Scanner(fin);

                username = scan.nextLine();
                password = scan.nextLine();

            } catch (FileNotFoundException ex) {
                System.out.println("LoginNot Found");
            }

            if (masterLogin_view.getUserName().getText().equalsIgnoreCase(username) && masterLogin_view.getPassword().getText().equalsIgnoreCase(password)) {

                n_view.addMainButtonListener(new MainButtonListener());
                c_view.addCreateAccountListener(new CreateAccountButtonListener());
                c_view.addgenRandPassAccountListener(new GenRandPassButtonListener());
                n_view.addSearchButtonListener(new SearchButtonListener());

                n_view.nVpanel.getMenu().getOptionsButton().setVisible(false);
                n_view.nVpanel.getMenu().getMainButton().setVisible(true);
                n_view.nVpanel.getMenu().getInstructionsButton().setVisible(true);
                n_view.nVpanel.getMenu().getHighScoreButton().setVisible(true);
                n_view.nVpanel.getMenu().getSearchButton().setVisible(true);

                masterLogin_view.getLoginStatus().setText("Logged In");

            } else {
                masterLogin_view.getLoginStatus().setText("Error, Wronge Password or Username");
            }

        }

    }

}
