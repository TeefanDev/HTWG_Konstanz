import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelefonBuchEinfuegenPanel extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -5612608240409486295L;

    private TelefonBuch telBuch;
    private TelefonBuchGUI tbGUI;
    private JTextField tfEinfuegenName;
    private JTextField tfEinfuegenZusatz;
    private JTextField tfEinfuegenTelNr;
    private JButton buttonEinfuegen;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb, TelefonBuchGUI tbGUI) {
        this.telBuch = tb;
        this.tbGUI = tbGUI;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(new JLabel("Name"));
        panel1.add(new JLabel("Zusatz"));
        panel1.add(new JLabel("TelefonNummer"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        tfEinfuegenName = new JTextField("", 20);
        panel2.add(tfEinfuegenName);
        tfEinfuegenZusatz = new JTextField("", 20);
        panel2.add(tfEinfuegenZusatz);
        tfEinfuegenTelNr = new JTextField("", 20);
        panel2.add(tfEinfuegenTelNr);

        Border border = BorderFactory.createTitledBorder("Einfuegen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        buttonEinfuegen = new JButton("Einfuegen");
        this.add(buttonEinfuegen);
        buttonEinfuegen.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        boolean succes;
        if (e.getSource() == buttonEinfuegen) {
            // Check Name for not Valid Input
            if (!tfEinfuegenName.getText().matches("(\\w+\\s?[-.]*\\s?)*")) {
                JOptionPane.showMessageDialog(this,
                        "No Valid Input (allowed are: letters, numbers, -_.).");
                return;
            }
            // Check TelNr for not valid Input
            if (!tfEinfuegenTelNr.getText().matches(
                    "[0-9]+\\s?[-/_]?\\s?[0-9]+")) {
                JOptionPane.showMessageDialog(this,
                        "No Valid Input (allowed are: numbers, -_/).");
                return;
            }
            // Try to insert in telBuch
            succes = telBuch.insert(tfEinfuegenName.getText(),
                    tfEinfuegenZusatz.getText(), tfEinfuegenTelNr.getText());
            tbGUI.refreshAusgabe();
            if (!succes) {
                JOptionPane.showMessageDialog(this,
                        "Entry is already existing.");
            }
        }
    }
}
