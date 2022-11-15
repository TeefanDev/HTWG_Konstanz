import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelefonBuchMenuBar extends JMenuBar implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -8157705136640526129L;

    private TelefonBuch telBuch;
    private TelefonBuchGUI tbGUI;
    private JMenu data = new JMenu("Datei");
    private JMenuItem telBookRead;
    private JMenuItem telBookWrite;
    private JMenuItem telBookExit;

    public TelefonBuchMenuBar(TelefonBuch tb, TelefonBuchGUI tbGUI) {
        this.telBuch = tb;
        this.tbGUI = tbGUI;

        // Constructing Menu data
        telBookRead = new JMenuItem("TelefonBuch lesen ...");
        telBookRead.setMnemonic(KeyEvent.VK_O);
        telBookRead.addActionListener(this);
        data.add(telBookRead);

        telBookWrite = new JMenuItem("TelefonBuch speichern ...");
        telBookWrite.setMnemonic(KeyEvent.VK_S);
        telBookWrite.addActionListener(this);
        data.add(telBookWrite);

        data.addSeparator();

        telBookExit = new JMenuItem("Telefonbuch beenden");
        telBookExit.addActionListener(this);
        data.add(telBookExit);

        this.add(data);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));

        if (e.getSource() == telBookRead) {
            int sucess = chooser.showOpenDialog(this);
            if (sucess == JFileChooser.APPROVE_OPTION) {
                telBuch.read(chooser.getSelectedFile());
                tbGUI.refreshAusgabe();
            }
        } else if (e.getSource() == telBookWrite) {
            int sucess = chooser.showSaveDialog(this);
            if (sucess == JFileChooser.APPROVE_OPTION) {
                telBuch.save(chooser.getSelectedFile());
            }
        } else if (e.getSource() == telBookExit) {
            int exit = JOptionPane.showConfirmDialog(this,
                    "Do you really want to exit?", "Exit Dialog",
                    JOptionPane.YES_NO_OPTION);
            if (exit == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else if (exit == JOptionPane.NO_OPTION) {
                return;
            }
        }
    }
}
