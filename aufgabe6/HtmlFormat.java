//HtmlFormat.java
package aufgabe6;

import java.io.PrintWriter;

/**
 * HtmlFormat schreibt in die neue Htmldatei.
 * @author Stefan Ptacek
 * @version 17.01.2022
 */
public final class HtmlFormat {
    /**
     * standart konstruktor.
     */
    private HtmlFormat() { }
    /**
     * @param ausgabe
     * @param namen
     * @param leistungen
     */
    public static void ausgeben(
        PrintWriter ausgabe,
        String[] namen,
        LeistungsListe leistungen
    ) {

        ausgabe.println(
            "<!DOCTYPE html>\n"
            + "<html lang=\"de\">\n"
            + "<head>\n"
            + "<meta charset=\"utf-8\">\n"
            + "<meta name=\"viewport\" content=\"width=device-width, "
            + "initial-scale=1.0\">\n"
            + "<style>\n"
            + "table { width:100%; }\n"
            + "th { text-align:left; }\n"
            + "</style>\n"
            + "<title>Notenspiegel</title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h1>Notenspiegel f&uuml;r"
        );

        for (String name : namen) {
            ausgabe.println(name);
        }

        ausgabe.println(
            "</h1>\n"
            + "<hr>\n"
            + "<table>\n"
            + "<tr><th>Fach:</th><th>Art:</th><th>Note:</th></tr>"
        );

        for (Leistung leistung : leistungen) {
            ausgabe.println(
                "<tr><td"
                + (leistung.istBestanden() ? "" : " style=\"color:red\"")
                + ">"
                + leistung.getFach()
                + "</td><td>"
                + (leistung.istBenotet() ? "L" : "S")
                + "</td><td>"
                + leistung.getNoteInWorten()
                + (leistung.istBenotet() ? " (" + leistung.getNote() + ")" : "")
                + "</td></tr>"
            );
        }
        ausgabe.println(
            "</table>\n"
            + "<hr>\n"
            + "L = Leistungsnachweis, S = Schein\n"
            + "</body>\n"
            + "</html>"
        );
    }
}
