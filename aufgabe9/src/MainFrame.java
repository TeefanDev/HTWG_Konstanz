import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Stefan Ptacek
 * @version 23.05.2022
 */
public class MainFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = -1102749501298414850L;

    // Frame Dimension
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int BORDER = 15;

    public GuiOperandenPanel operanden;
    public GuiCheckboxesPanel checkboxes;
    public GuiOperationsPanel operations;

    private JPanel mainPanel;

    // Clear Panel
    private JPanel clear;
    private JButton clearButton;

    public MainFrame() {

        setTitle("Taschenrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Operanden Panel
        operanden = new GuiOperandenPanel(this);
        // Checkboxes Panel
        checkboxes = new GuiCheckboxesPanel(this);
        // Operations Panel
        operations = new GuiOperationsPanel(this);

        // Clear Panel
        clear = new JPanel();
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        clear.add(clearButton);

        // Make MainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(operanden);
        mainPanel.add(checkboxes);
        mainPanel.add(operations);
        mainPanel.add(clear);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER,
                BORDER, BORDER));
        setContentPane(mainPanel);

        // MainPanel options
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        // pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            operanden.getOperandX().setText("");
            operanden.getOperandY().setText("");
            operanden.getResultat().setText("");
        }

    }
}
