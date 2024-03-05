import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MainPanel extends JPanel {

        // Instance of GUICalculator for passing focus.
        GUICalculator guiCalculator;

        // Arrays for the button labels and buttons.
        final String[] button_labels = {"AC", "<=", "/", "*", "7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "^", "00", "0", "=" };
        JButton[] button = new JButton[button_labels.length];

        // Expression string and label.
        String expression = "0";
        JLabel gui_expression = new JLabel(expression);

        GridBagConstraints gbc;

    MainPanel(GUICalculator guiCalculator) {

        // Set the instance of the GUICalculator to pass focus for the key listener.
        this.guiCalculator = guiCalculator;

        // Set and initialize layout properties.
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add the GUI expression label to the JPanel using Grid Bag Constraints.
        add_gbc(gui_expression, 0, 0, 4);

        // Initialize the button listener class defined below.
        ButtonListener buttonListener = new ButtonListener();

        /*
         Loop through the button array:
            Initialize buttons with the text being equal to the labels.
            Add action listeners to the buttons.
            Add to the JPanel using grid bag constraints.
        */
        for (int i = 0; i < button.length; i++){
            button[i] = new JButton(button_labels[i]);
            button[i].addActionListener(buttonListener);
            add_gbc(button[i], get_column(i), get_row(i+1), 1);
        }
    }

    // Returns the row for a button.
    private int get_row(int i) {
        // i/4 rounded up.
        return (int) Math.ceil((double) i / 4);
    }
    
    // Returns the column for a button.
    private int get_column(int i){
        return i%4;
    }

    // Applies the gbc constraints to a given component and adds it to the panel.
    public void add_gbc(Component component, int x, int y, int width) {
        gbc.gridwidth = width;
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }

    // Modifies the expression based on button or key pressed.
    public void handle_button_press(String s) {
        try {
            switch (s) {
                // Backspace
                case "<=":
                    backspace();               
                    break;
                // All Clear
                case "AC":
                    expression = "0";
                    break;
                // Operators
                case "/":
                case "*":
                case "-":
                case "+":
                case "^":
                    handle_operator(s);
                    break;
                // Equals
                case "=":
                    calculate_expression();
                    break;
                // Zero handling, not supporting doubles currently and 10 + 01 is annoying to look at.
                case "0":
                case "00":
                    if (!last_char_space()) {
                        expression += (expression.equals("0") ? "" : s);
                    }
                    break;
                default:
                    if(!isNumeric(s)) {
                        System.out.println("Not a number");
                        break;
                    }
                    expression = (expression.equals("0") ? s : expression + s);
            }
            gui_expression.setText(expression);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    private void handle_operator(String s) {
        // If a space is present than an operator is present, remove it.
        if(last_char_space()) {
            backspace();
        }
        expression += " " + s + " ";
    }

    // Removes the last number or operator used.
    private void backspace() {
        if(expression.length() > 1) {
            // If last action was an operator, then places = 3(operator) , else 1(number).
            int places = (last_char_space()) ? 3 : 1;
            // Substring to remove the number places from the string.
            expression = expression.substring(0, expression.length() - places);
        } else {
            expression = "0";
        }
    }

    // Will eventually handle calculating the expression.
    private void calculate_expression() {
        System.out.println(expression);
    }

    // Returns true if the last character of the expression is a space (operator used last).
    private boolean last_char_space() {
        String last_char = String.valueOf(expression.charAt(expression.length()-1));
        return last_char.equals(" ");
    }

    // Used for input validation on keyboard presses.
    private boolean isNumeric(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Class used to handle the buttons pressed.
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            handle_button_press(e.getActionCommand());
            // Give focus back to the GUICalculator instance so it'll continue to handle key presses.
            guiCalculator.getFocus();
        }
    }
}