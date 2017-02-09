
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NavController {

    NavModel n_model;
    NavView n_view;
    //Instance Variables for Options Model, View, and Controller

    // TODO: Create instances of your MainModel and MainController once you implement them
    
    CreateView c_view;
    MasterLoginView masterLogin_view;

    public NavController(NavModel n_model, NavView n_view) {
        this.n_model = n_model;
        this.n_view = n_view;

        c_view = new CreateView();
        masterLogin_view = new MasterLoginView();

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

            c_view.getPassword().setText("Random Password");
        }

    }
    class MasterPassButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        
        n_view.addMainButtonListener(new MainButtonListener());
        c_view.addCreateAccountListener(new CreateAccountButtonListener());
        c_view.addgenRandPassAccountListener(new GenRandPassButtonListener());
        
        }

    }
    

}
