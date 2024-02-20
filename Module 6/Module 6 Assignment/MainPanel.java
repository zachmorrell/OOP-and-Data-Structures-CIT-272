import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    GridBagConstraints gbc;

    public MainPanel() {
        setLayout(new BorderLayout());
        MenuPanel menu_panel = new MenuPanel();
        add(menu_panel, BorderLayout.NORTH);
        InputPanel input_panel = new InputPanel();
        add(input_panel, BorderLayout.CENTER);
        add(new OutputPanel(input_panel), BorderLayout.SOUTH);
    }
}