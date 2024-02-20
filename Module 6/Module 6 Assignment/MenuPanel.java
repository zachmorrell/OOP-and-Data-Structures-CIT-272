import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    JDialog dialog;
    JMenuBar menu_bar;
    JMenuItem about, exit;
    InteractionListener interactionListener;

    public MenuPanel() {
        // setLayout to GridLayout for styling purposes.
        setLayout(new GridLayout(1,2));

        //Initialize menu_bar.
        menu_bar = new JMenuBar();

        // Initialize JMenus for File and Help menus.
        JMenu file_menu = new JMenu("File");
        JMenu help_menu = new JMenu("Help");

        // Initialize the action listener for actions performed.
        interactionListener = new InteractionListener();
        about = new JMenuItem("About");
        about.addActionListener(interactionListener);
        exit = new JMenuItem("Exit");
        exit.addActionListener(interactionListener);

        // Adds the menu items to their menus.
        help_menu.add(about);
        file_menu.add(exit);

        // Adds the File and Help menus to the menu bar.
        menu_bar.add(file_menu);
        menu_bar.add(help_menu);

        // Adds the menu bar to the main frame.
        add(menu_bar);
    }

    // Function is responsible for creating and displaying the JDialog for the about menu item.
    private void display_about(){
        // Dimensions for dialog box.
        int app_width = 400;
        int app_height = 165;

        // JDialog initilize and applying preferences.
        dialog = new JDialog(new JFrame(), "About", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(400,165);
        dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Centers the application's location on opening.
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(screen.width / 2 - dialog.getSize().width/2 - (app_width / 2), screen.height / 2 - dialog.getSize().height / 2 - (app_height / 2));

        // Create and initialize button.
        JButton ok = new JButton("Ok");
        ok.setSize(30,30);
        ok.addActionListener(interactionListener);

        // Add Components to dialog.
        dialog.add(new JLabel("Zachary Morrell"));
        dialog.add(new JLabel("CIT 272 - Object Oriented Programming and Data Structuers"));
        dialog.add(new JLabel("<html>A temperature conversion calculator to convert from either<br> Celsius or Farenheit to Celsius, Fahrenheit, and Kelvin.<html>"));
        dialog.add(ok);

        // Set JDialogs visibility to true.
        dialog.setVisible(true);
    }

    private class InteractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                switch (e.getActionCommand()) {
                    case "About":
                        // Open a Dialog with required information.
                        display_about();
                    break;
                    case "Exit":
                        // Terminates the program.
                        System.exit(0);
                    break;
                    case "Ok":
                        // Destroys and frees up resources used by the dialog panel.
                        dialog.dispose();
                    break;
                    default:
                        System.out.println("Unknown button clicked " + e.getActionCommand());
                        break;
                }
            } catch (Exception exception) {
                System.out.println("An unknown error has occured." + exception);
            }
        }
    }
}