import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Hello World!");        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define the Size of the JFrame and the locations.
        window.setPreferredSize(new Dimension(300,300));
        window.setLocation(new Point(800, 400));

        // Gets the HelloPanel class and places it in the FJrame.
        window.getContentPane().add(new HelloPanel());

        // Pack the changes together for the JFrame.
        window.pack();
        window.setVisible(true);
    }
}