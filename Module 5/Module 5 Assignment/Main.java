import java.awt.Dimension;
import javax.swing.JFrame;
/*
 *  This application creates a GUI used to convert temperatures.
 *  Author: Zachary Morrell
 *  Class: 272 OOP and Data Structures
 *  Date 2/12/24
 *  Professor Jeremy Doolin
 */
public class Main {

    public static void main(String[] args) {
        // Creates the frame with the title Temp Converter.
        JFrame window = new JFrame("Temp Converter");
        // Killes process on applicatoin close.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sizes the application.
        window.setPreferredSize(new Dimension(300, 235));
        // Removes user ability to resize, due to layout.
        window.setResizable(false);
        // Adds the TempConversionPanel to the JFrame.
        window.getContentPane().add(new TempConversionPanel());
        // Builds the application package to display the changes made.
        window.pack();
        // Makes application visible.
        window.setVisible(true);
    }
}
