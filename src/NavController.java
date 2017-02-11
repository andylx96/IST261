
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public NavController(NavModel n_model, NavView n_view) {
        this.n_model = n_model;
        this.n_view = n_view;

        c_view = new CreateView();
        masterLogin_view = new MasterLoginView();
        g = new GeneratePass();

        n_view.addOptionsButtonListener(new MasterLoginViewListener());

        masterLogin_view.addMasterLoginListener(new MasterPassButtonListener());

    }

    class MainButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Pass a Main View object to our Navigation View
            n_view.switchToMainPanel(c_view);
        }
    }

    class MasterLoginViewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Pass a Main View object to our Navigation View
            n_view.switchToMasterLoginViewPanel(masterLogin_view);
        }
    }

    class CreateAccountButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            c_view.getCreateAccount().setText("Done");
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
//         // print the newly read employee records
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

                n_view.nVpanel.getMenu().getOptionsButton().setVisible(false);
                n_view.nVpanel.getMenu().getMainButton().setVisible(true);
                n_view.nVpanel.getMenu().getInstructionsButton().setVisible(true);
                n_view.nVpanel.getMenu().getHighScoreButton().setVisible(true);
                n_view.nVpanel.getMenu().getCreditsButton().setVisible(true);

            masterLogin_view.getLoginStatus().setText("Logged In");
                
            }else {
            masterLogin_view.getLoginStatus().setText("Error, Wronge Password or Username");
            }
            

        }

    }

}
