import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloPanel extends JPanel {// implements ActionListener {
    private JLabel message;
    private JButton activate, clear;
    private JTextField input;

    public HelloPanel() {
        ButtonListener buttonListener = new ButtonListener();

        message = new JLabel("Hello, CIT 272");
        input = new JTextField();
        input.setColumns(23);
        activate = new JButton("Change Text");
        activate.addActionListener(buttonListener);

        clear = new JButton("Clear");
        clear.addActionListener(buttonListener);

        message.setFont(getFont().deriveFont(30.0f));
        add(message);
        add(input);
        add(activate);
        add(clear);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println(arg0);
            System.out.print("\nAction: " + arg0.getID() + " : " + arg0.getActionCommand() + " : " + arg0.getModifiers() + "\n");
            switch (arg0.getActionCommand()) {
                case "Change Text":
                    setMessage(input.getText());
                    break;
                case "Clear":
                    input.setText("");
            
                default:
                    System.out.println("Unregistered Action Performed: " + arg0.getActionCommand());
                    break;
            }
        }

    }

    /*@Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.print("\nAction: " + arg0.getID() + "\n");
        switch (arg0.getID()) {
            case 1001:
                setMessage(input.getText());
                break;
        
            default:
                System.out.println("Unregistered Action Performed: " + arg0.getID());
                break;
        }
    }
    */
}
