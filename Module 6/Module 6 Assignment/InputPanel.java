import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
    
    private JLabel convert_from_label;
    private JRadioButton is_celsius, is_fahrenheit;
    private JTextField temp_input;
    GridBagConstraints gbc;

    public InputPanel() {

        // Apply the layout and initialize the GridBagConstrainst gbc.
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Field.
        temp_input = new JTextField(10);
        
        // Radio buttons
        convert_from_label = new JLabel("<html><i>Converting from:</i><br> </html>");
        is_celsius = new JRadioButton("Celsius",null,true);
        is_fahrenheit = new JRadioButton("Farenheit");

        // ButtonGroup for the radio buttons.
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(is_celsius);
        radioGroup.add(is_fahrenheit);

        // Panel to format radio buttons to the same line.
        JPanel radioLinePanel = new JPanel();
        radioLinePanel.add(convert_from_label);
        radioLinePanel.add(is_celsius);
        radioLinePanel.add(is_fahrenheit);

        // Adds the components to the InputPanel's JPanel.
        add_gbc(temp_input, 0, 0, 2);
        add_gbc(convert_from_label, 0, 1, 1);
        add_gbc(is_celsius, 1, 1, 1);
        add_gbc(is_fahrenheit, 1, 2, 1);
        
    }
    // Applies the gbc constraints to a given component and adds it to the panel.
    public void add_gbc(Component component, int x, int y, int width) {
        gbc.gridwidth = width;
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }
    // Returns the state of radio button C selection.
    public Boolean converting_from_c() {
        return is_celsius.isSelected();
    }
    // Returns the String text of the temp_input field.
    public String get_temp_input() {
        return temp_input.getText();
    }
}