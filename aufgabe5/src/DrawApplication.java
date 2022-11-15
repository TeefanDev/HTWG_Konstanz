// DrawApplication.java

import java.awt.geom.Point2D;

/**
 * Aufgabe 5 Rekursion
 *
 * @author Julian Klimek
 * @version 24.02.2022
 */
public final class DrawApplication {

    public static void main(String[] args) {
        // set scale of the coordinate system
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, 600);

        //PythagorasTree.drawTreeRect(new Point2D.Double(350, 0), new Point2D.Double(450, 0), false);
        PythagorasTree.drawTreeRect(new Point2D.Double(350, 0), new Point2D.Double(450, 0), true);
    }
}
