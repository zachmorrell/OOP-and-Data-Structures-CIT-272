import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GUICalculator {
    final static int app_width = 250;
    final static int app_height = 250;
    MainPanel main_j_panel;
    JFrame jFrame;

    public GUICalculator() {

        jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setPreferredSize(new Dimension(app_width,app_height));

        // Centers the application's location on opening.
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(screen.width / 2 - jFrame.getSize().width/2 - (app_width / 2), screen.height / 2 - jFrame.getSize().height / 2 - (app_height / 2));

        // Initialize and add JPanel to the JFrame.
        main_j_panel = new MainPanel(this);
        jFrame.getContentPane().add(main_j_panel);

        // Builds the application package to display the changes made.
        jFrame.pack();
        jFrame.setVisible(true);

        // Gives focus so that keylistener will work.
        jFrame.requestFocusInWindow();
        jFrame.addKeyListener(new GUIKeyListener());
    }
    public static void main(String[] args) {
        // Create an instance of GUICalculator to implement addKeyListener.
        new GUICalculator();
    }

    public void getFocus() {
        jFrame.requestFocusInWindow();
    }

    private class GUIKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            String key_char;
            switch (e.getKeyChar()) {

                case KeyEvent.VK_BACK_SPACE:
                    key_char = "<=";
                    break;

                case KeyEvent.VK_ENTER:
                    key_char = "=";
                    break;

                default:
                    key_char = String.valueOf(e.getKeyChar());
                    break;
            }

            main_j_panel.handle_button_press(key_char);
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    
        
    }

}
