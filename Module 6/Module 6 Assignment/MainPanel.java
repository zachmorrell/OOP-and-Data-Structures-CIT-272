import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public MainPanel() {
        // Set the layout to Border layout for styling purposes.
        setLayout(new BorderLayout());
        // Initialize input_panel as the instance is needed for the output_panel.
        InputPanel input_panel = new InputPanel();
        // Add input_panel to the JPanel.
        add(input_panel, BorderLayout.CENTER);
        // Add output_panel with the input_panel instance for data retrieval.
        add(new OutputPanel(input_panel), BorderLayout.SOUTH);
    }
}