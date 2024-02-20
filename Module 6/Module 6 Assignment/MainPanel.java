import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    GridBagConstraints gbc;

    public MainPanel() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        InputPanel input_panel = new InputPanel();
        add_gbc(input_panel,0,0);
        add_gbc(new OutputPanel(input_panel),0,1);
    }    

    public void add_gbc(Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }
}