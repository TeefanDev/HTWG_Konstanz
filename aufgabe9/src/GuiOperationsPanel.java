import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * @author Stefan Ptacek
 * @version 23.05.2022
 */
public class GuiOperationsPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 8526929421286359972L;

    MainFrame mainFrame;

    JPanel operations;
    JButton addition;
    JButton multiplication;
    JButton substraction;
    JButton division;
    JButton sinus;
    JButton cosinus;
    JButton xToPowY;
    JButton logTwo;

    public GuiOperationsPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        addition = new JButton("+");
        multiplication = new JButton("*");
        substraction = new JButton("-");
        division = new JButton("/");
        sinus = new JButton("sin");
        cosinus = new JButton("cos");
        xToPowY = new JButton("x^y");
        logTwo = new JButton("log2");

        addition.addActionListener(this);
        multiplication.addActionListener(this);
        substraction.addActionListener(this);
        division.addActionListener(this);
        sinus.addActionListener(this);
        cosinus.addActionListener(this);
        xToPowY.addActionListener(this);
        logTwo.addActionListener(this);

        setLayout(new GridLayout(2, 4));
        add(addition);
        add(multiplication);
        add(substraction);
        add(division);
        add(sinus);
        add(cosinus);
        add(xToPowY);
        add(logTwo);

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField operand1 = mainFrame.operanden.getOperandX();
        JTextField operand2 = mainFrame.operanden.getOperandY();
        boolean isRad = mainFrame.checkboxes.getIsRad();
        double op1;
        double op2;
        double result = 0;

        try {
            op1 = Calc.toDouble(operand1.getText());
        } catch (IllegalArgumentException x) {
            operand1.setText("Illegal Argument: Ignored");
            return;
        }
        try {
            if (e.getSource() == sinus) {
                result = Calc.sinus(op1, isRad);
                mainFrame.operanden.getOperandY().setText("");
                mainFrame.operanden.getResultat().setText(Double.toString(result));
                return;
            } else if (e.getSource() == cosinus) {
                result = Calc.cosinus(op1, isRad);
                mainFrame.operanden.getOperandY().setText("");
                mainFrame.operanden.getResultat().setText(Double.toString(result));
                return;
            } else if (e.getSource() == logTwo) {
                if(op1 < 0) {
                    throw new ArithmeticException("log_2 kleiner 0");
                }
                result = Calc.logTwo(op1);
                mainFrame.operanden.getOperandY().setText("");
                mainFrame.operanden.getResultat().setText(Double.toString(result));
                return;
            }
            }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }

        try {
            op2 = Calc.toDouble(operand2.getText());
        } catch (IllegalArgumentException x) {
            //operand2.setText("Illegal Argument: Ignored");
            System.out.println("Illegal Argument: Ignored");
            return;
        }
        try {
            if (e.getSource() == addition) {
                result = Calc.addition(op1, op2);
            } else if (e.getSource() == multiplication) {
                result = Calc.multiplication(op1, op2);
            } else if (e.getSource() == substraction) {
                result = Calc.substraction(op1, op2);
            } else if (e.getSource() == division) {
                if (op2 == 0) {
                    throw new ArithmeticException("division druch 0");
                }
                result = Calc.division(op1, op2);
            } else if (e.getSource() == xToPowY) {
                result = Calc.xToPowY(op1, op2);
            }
            mainFrame.operanden.getResultat().setText(Double.toString(result));
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        }
}
