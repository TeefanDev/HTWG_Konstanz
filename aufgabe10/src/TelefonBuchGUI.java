import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelefonBuchGUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -4616161686945847592L;

    private TelefonBuch telBuch;
    private JTextArea taAusgabe;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();

        // Menuleiste einbauen:
        JMenuBar menuBar = new TelefonBuchMenuBar(telBuch, this);
        this.setJMenuBar(menuBar);

        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und SuchenLoeschenPanel einbauen:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel telBuchEinfuegen = new TelefonBuchEinfuegenPanel(telBuch, this);
        mainPanel.add(telBuchEinfuegen);

        JPanel telBuchSuchen = new TelefonBuchSuchenLoeschenPanel(telBuch, this);
        mainPanel.add(telBuchSuchen);

        // AusgabeTextFeld
        JPanel ausgabePanel = new JPanel();
        ausgabePanel.setBorder(BorderFactory.createTitledBorder("Ausgabe"));
        taAusgabe = new JTextArea(20, 50);
        taAusgabe.setEditable(false);
        ausgabePanel.add(taAusgabe);
        JScrollPane scrollPane = new JScrollPane(taAusgabe);
        ausgabePanel.add(scrollPane);

        mainPanel.add(ausgabePanel);

        this.setContentPane(mainPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.pack();
        this.setVisible(true);

        // Close Operations
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int exit = JOptionPane.showConfirmDialog(frame,
                        "Do you really want to exit?", "Exit Dialog",
                        JOptionPane.YES_NO_OPTION);
                if (exit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (exit == JOptionPane.NO_OPTION) {
                    return;
                }
            }
        });
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    }

    public void setAusgabe(String s) {
        if(s != null){
            taAusgabe.setText(s);
        } else {
            taAusgabe.setText("");
        }
    }

    public void setAusgabe(List<String> s) {
        StringBuilder sb = new StringBuilder();
        for (String i : s) {
            sb.append(i + "\n");
        }
        taAusgabe.setText(sb.toString());
    }

    public void refreshAusgabe() {
        setAusgabe(telBuch.getList());
    }
}
