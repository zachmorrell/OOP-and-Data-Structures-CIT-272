//import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TempConversionPanel extends JPanel {
    private JButton convert;
    private JLabel cLabel, fLabel, kLabel, appInfoLabel, convertFromLabel;
    private JRadioButton isCelsius, isFahrenheit;
    private JTextField tempInput;

    public TempConversionPanel() {
        setLayout(new FlowLayout());
        /*
            --- Input Field ---
         */
        tempInput = new JTextField(20);
        /*
            --- Labels ---
         */
        appInfoLabel = new JLabel("<html>This Program is to convert from either Celsius or<br>Farenheit to Celsius, Farenheit, and Kelvin.</html>");
        convertFromLabel = new JLabel("<html><i>Converting from:</i><br> </html>");
        cLabel = new JLabel("Celsius: ");
        fLabel = new JLabel("Fahrenheit Selected: ");
        kLabel = new JLabel("Kelvin: ");
        // Line Break Label
        JLabel lineBreak = new JLabel();
        lineBreak.setPreferredSize(new Dimension(300, 0));
        /*
            --- Radio Buttons ---
         */
        isCelsius = new JRadioButton("Celsius");
        isCelsius.setSelected(true);
        isFahrenheit = new JRadioButton("Farenheit");

        // ButtonGroup for the radio buttons.
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(isCelsius);
        radioGroup.add(isFahrenheit);

        // Panel to format radio buttons to the same line.
        JPanel radioLinePanel = new JPanel();
        radioLinePanel.add(convertFromLabel);
        radioLinePanel.add(isCelsius);
        radioLinePanel.add(isFahrenheit);

        /*
            --- Button ---
         */
        convert = new JButton("Convert");
        ButtonListener buttonListener = new ButtonListener();
        convert.addActionListener(buttonListener);

        // Adding swing components to JFrame.
        add(appInfoLabel);
        add(tempInput);
        add(radioLinePanel);
        add(convert);
        add(lineBreak);
        add(cLabel);
        add(fLabel);
        add(kLabel);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {                
                Double temp = Double.valueOf(tempInput.getText());
                if(isCelsius.isSelected()) {
                    // Displays C values with temperature conversion.
                    cLabel.setText("Celsius: " + String.valueOf(temp));
                    fLabel.setText("Fahrenheit: " + String.valueOf(cToF(temp)));
                    kLabel.setText("Kelvin: " + String.valueOf(cToK(temp)));
                } else {
                    //Display F values after temprature conversion.
                    cLabel.setText("Celsius: " + String.valueOf(fToC(temp)));
                    fLabel.setText("Fahrenheit: " + String.valueOf(temp));
                    kLabel.setText("Kelvin: " + String.valueOf(fToK(temp)));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a numeric value representing the temperature.", "Alert", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    // Returns Fahrenheit converted to Celsius.
    private Double fToC(Double temp) {
        return (temp - 32) * (double) 5/9;
    }
    // Returns Celsius converted to Fahrenheit.
    private Double cToF(Double temp) {
        return temp * ((double) 9/5) + 32;
    }
    // Returns Fahrenheit converted to Kelvin.
    private Double fToK(Double temp) {
        return (temp - 32) * (double) 5/9 + 273.15;
    }
    // Returns Celsius converted to Kelvin.
    private Double cToK(Double temp) {
        return temp + 273.15;
    }
}