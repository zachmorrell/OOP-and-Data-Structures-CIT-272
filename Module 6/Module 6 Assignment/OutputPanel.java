import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OutputPanel extends JPanel {
    private JButton convert_button;
    private JLabel c_label, f_label, k_label;
    private InputPanel input_panel;
    private Boolean c_to_f = true;
    GridBagConstraints gbc;

    public OutputPanel(InputPanel input_panel) {

        this.input_panel = input_panel;
        
        // set layout and initialize GridBagConstraints gbc.
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        // Labels initialization.
        c_label = new JLabel("Celsius: ");
        f_label = new JLabel("Fahrenheit: ");
        k_label = new JLabel("Kelvin: ");
        
        // Button initialization.
        convert_button = new JButton("Convert");
        convert_button.addActionListener(new ButtonListener());

        // add_gbc function to apply gbc constrains then add to the panel.
        add_gbc(convert_button,1,0);
        add_gbc(c_label,1,1);
        add_gbc(f_label,1,2);
        add_gbc(k_label,1,3);
    }

    // Temperature conversion handling.
    public Double[] get_temp_conversions(Double temp_input) {
        // Double array to store the results.
        Double[] results = new Double[3];
            if(c_to_f) {
                // Temperature conversion C -> F, K.
                // input is already Celsius.
                results[0] = temp_input;
                // Celsius to Fahrenheit conversion.
                results[1] = temp_input * ((double) 9/5) + 32;
                // Celsius to Kelvin conversion.
                results[2] = (temp_input + 273.15);
            } else {
                // Temperature Conversion F -> C, K.
                // Fahrenheit to Celsius conversion.
                results[0] = (temp_input - 32) * (double) 5/9;
                // Input is already Fahrenheit.
                results[1] = temp_input;
                // Fahrenheit to Kalvin.
                results[2] = results[0] + 273.15;
            }
        return results;
    }
    
    // Applies GridBagConstraints to Components, then adds them to the Panel.
    public void add_gbc(Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }

    // Function fo setting the temperatures from the, passed, Double temperatures array.
    private void set_labels(Double[] temperatures) {
            c_label.setText("Celsius: " + String.valueOf(temperatures[0]));
            f_label.setText("Fahrenheit: " + String.valueOf(temperatures[1]));
            k_label.setText("Kelvin: " + String.valueOf(temperatures[2]));
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get radio button selection.
            c_to_f = input_panel.converting_from_c();
            try {
                // Get temperature input.
                Double temp_input = Double.parseDouble(input_panel.get_temp_input());
                // Perform conversion.
                Double[] temperatures = get_temp_conversions(temp_input);
                // Set labels.
                set_labels(temperatures);                
            } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "The input text must be an integer value", "Error: Incorrect Input", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }
}