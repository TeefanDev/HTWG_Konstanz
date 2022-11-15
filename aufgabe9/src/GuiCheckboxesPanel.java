import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Stefan Ptacek
 * @version 23.05.2022
 */
public class GuiCheckboxesPanel extends JPanel implements ActionListener,
        ItemListener {

    private static final long serialVersionUID = -5023871578492331270L;
    private MainFrame mainFrame;
    private JRadioButton deg;
    private JRadioButton rad;
    private JCheckBox hellesFenster;
    private boolean isRad;

    public GuiCheckboxesPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        deg = new JRadioButton("Deg");
        rad = new JRadioButton("Rad");
        hellesFenster = new JCheckBox("Daylight Mode");
        hellesFenster.setSelected(true);

        ButtonGroup degSin = new ButtonGroup();
        degSin.add(deg);
        degSin.add(rad);
        deg.setSelected(true);

        rad.addActionListener(this);
        deg.addActionListener(this);
        hellesFenster.addItemListener(this);

        setLayout(new GridLayout(1, 3));
        add(deg);
        add(rad);
        add(hellesFenster);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rad) {
            isRad = true;
        } else if (e.getSource() == deg) {
            isRad = false;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            mainFrame.operanden.getOperandX().setBackground(Color.WHITE);
            mainFrame.operanden.getOperandY().setBackground(Color.WHITE);
            mainFrame.operanden.getResultat().setBackground(Color.WHITE);
            mainFrame.operanden.getOperandX().setForeground(Color.BLACK);
            mainFrame.operanden.getOperandY().setForeground(Color.BLACK);
            mainFrame.operanden.getResultat().setForeground(Color.BLACK);
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            mainFrame.operanden.getOperandX().setBackground(Color.BLACK);
            mainFrame.operanden.getOperandY().setBackground(Color.BLACK);
            mainFrame.operanden.getResultat().setBackground(Color.BLACK);
            mainFrame.operanden.getOperandX().setForeground(Color.YELLOW);
            mainFrame.operanden.getOperandY().setForeground(Color.YELLOW);
            mainFrame.operanden.getResultat().setForeground(Color.YELLOW);
        }
    }

    public boolean getIsRad() {
        return isRad;
    }
}
