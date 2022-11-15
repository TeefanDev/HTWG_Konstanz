import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelefonBuchSuchenLoeschenPanel extends JPanel implements
        ActionListener {

    TelefonBuch telBuch;
    TelefonBuchGUI tbGUI;
    JTextField tfName;
    JTextField tfZusatz;
    JComboBox<String> cbChoose;
    JButton anwenden;

    /**
     *
     */
    private static final long serialVersionUID = -595790106857714598L;

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb, TelefonBuchGUI tbGUI) {
        this.telBuch = tb;
        this.tbGUI = tbGUI;

        JPanel panel1 = new JPanel(new GridLayout(2, 1));
        panel1.add(new JLabel("Name"));
        panel1.add(new JLabel("Zusatz"));

        JPanel panel2 = new JPanel(new GridLayout(2, 1));
        tfName = new JTextField("", 15);
        panel2.add(tfName);
        tfZusatz = new JTextField("", 15);
        panel2.add(tfZusatz);

        String[] possibleChoice = { "Exakte Suche", "Prefix Suche", "Loeschen" };
        cbChoose = new JComboBox<String>(possibleChoice);
        cbChoose.setSelectedIndex(0);

        anwenden = new JButton("Anwenden");
        anwenden.addActionListener(this);

        Border border = BorderFactory.createTitledBorder("Suchen/Loeschen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        this.add(cbChoose);
        this.add(anwenden);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == anwenden) {
            if (cbChoose.getSelectedIndex() == 0) {
                String entry = telBuch.exactSearch(tfName.getText(),
                        tfZusatz.getText());
                tbGUI.setAusgabe(entry);
            } else if (cbChoose.getSelectedIndex() == 1) {
                List<String> entrys = telBuch.prefixSearch(tfName.getText());
                tbGUI.setAusgabe(entrys);
            } else if (cbChoose.getSelectedIndex() == 2) {
                boolean sucess = telBuch.remove(tfName.getText(),
                        tfZusatz.getText());
                tbGUI.refreshAusgabe();
                if (!sucess) {
                    JOptionPane.showMessageDialog(this,
                            "Entry is not existing.");
                }
            }
        }
    }
}
