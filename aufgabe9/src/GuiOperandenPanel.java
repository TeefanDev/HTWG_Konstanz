import java.awt.GridLayout;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * @author Stefan Ptacek
 * @version 23.05.2022
 */
public class GuiOperandenPanel extends JPanel {

    private static final long serialVersionUID = -2098227150889282282L;

    MainFrame mainFrame;

    private JLabel operandXLabel;
    private JTextField operandX;
    private JLabel operandYLabel;
    private JTextField operandY;
    private JLabel resultatLabel;
    private JTextField resultat;

    public GuiOperandenPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        operandXLabel = new JLabel("Operand x");
        operandX = new JTextField("", 10);
        operandYLabel = new JLabel("Operand y");
        operandY = new JTextField("", 10);
        resultatLabel = new JLabel("Resultat");
        resultat = new JTextField("", 10);
        resultat.setEditable(false);
        resultat.setLocale(Locale.US);

        setLayout(new GridLayout(3, 2));
        add(operandXLabel);
        add(operandX);
        add(operandYLabel);
        add(operandY);
        add(resultatLabel);
        add(resultat);

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    }

    public JTextField getOperandX() {
        return operandX;
    }

    public JTextField getOperandY() {
        return operandY;
    }

    public JTextField getResultat() {
        return resultat;
    }
}
