import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/*
 *  This application creates a GUI used to convert temperatures.
 *  Author: Zachary Morrell
 *  Class: 272 OOP and Data Structures
 *  Date 2/20/24
 *  Professor Jeremy Doolin
 */
public class Main {
    final static int app_width = 275;
    final static int app_height = 230;
    public static void main(String[] args) {
        // Creates the frame with the title Temp Converter.
        JFrame window = new JFrame("Temp Converter");
        // Killes process on applicatoin close.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sizes the application.
        window.setPreferredSize(new Dimension(app_width, app_height));
        // Disable resizing to keep proper layout.
        window.setResizable(false);
        // Adds the TempConversionPanel to the JFrame.
        window.getContentPane().add(new MainPanel());
        // Builds the application package to display the changes made.
        window.pack();
        // Centers the application's location on opening.
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(screen.width / 2 - window.getSize().width/2 - (app_width / 2), screen.height / 2 - window.getSize().height / 2 - (app_height / 2));
        // Makes application visible.
        window.setVisible(true);
    }
}