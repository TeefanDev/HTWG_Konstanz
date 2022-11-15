// PythagorasTree.java

import java.awt.Color;          // color spaces
import java.awt.geom.Point2D;   // distance(), getX(), getY()
import java.util.Random;        // random numbers

/**
 * Aufgabe 5 Rekursion
 *
 * @author Julian Klimek
 * @version 24.02.2022
 */
public class PythagorasTree {

    private static final double BRANCHSIZE = 40;
    private static final double LEAFSIZE = 30;
    private static final float MINWIDTH = 5;
    private static final Color TRUNKCOLOR = Color.RED;
    private static final Color BRANCHCOLOR = Color.ORANGE;
    private static final Color LEAFCOLOR = Color.GREEN;
    private static final double BRANCHANGLE = Math.toRadians(30);
    private static final Random RANDOM = new Random();


    public static void drawTreeRect(Point2D a, Point2D b) {
        drawTreeRect(a, b, false);
    }
    public static void drawTreeRect(Point2D a, Point2D b, final boolean useRandom) {
        double width = a.distance(b), angle = BRANCHANGLE;
        setColor(width);

        // calculate points
        Point2D c = rotateAround(a, b, Math.toRadians(-90));
        Point2D d = rotateAround(b, a, Math.toRadians(+90));
        Point2D e;

        if(useRandom) {
            double r = RANDOM.nextDouble();
            c = lineStretch(b, c, 0.5 + r);
            d = lineStretch(a, d, 0.5 + r);
            angle = Math.toRadians(25 + (10* RANDOM.nextDouble()));
        }

        e = lineStretch(d, rotateAround(c, d, angle), Math.cos(angle));

        // draw rect
        drawLine(a, b);
        drawLine(b, c);
        drawLine(c, d);
        drawLine(d, a);

        // draw sub-rect
        if(width > MINWIDTH) {
            drawTreeRect(d, e, useRandom);
            drawTreeRect(e, c, useRandom);
        }
    }
    private static void drawLine(Point2D a, Point2D b) {
        StdDraw.line(a.getX(), a.getY(), b.getX(), b.getY());
    }

    private static Point2D pointAdd(final Point2D p1, final Point2D p2) {
        return new Point2D.Double(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }
    private static Point2D pointSub(final Point2D p1, final Point2D p2) {
        return new Point2D.Double(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
    private static Point2D pointMul(final Point2D p, final double factor) {
        return new Point2D.Double(
                p.getX() * factor,
                p.getY() * factor
        );
    }

    private static Point2D lineStretch(final Point2D p1, final Point2D p2, final double factor) {
        if(factor == 1)
            return p2;

        return pointAdd(p1, pointMul(pointSub(p2, p1), factor));
    }

    private static Point2D rotateOrigin(final Point2D p,final  double angle) {
        return new Point2D.Double(
                p.getX() * Math.cos(angle) - p.getY() * Math.sin(angle),
                p.getX() * Math.sin(angle) + p.getY() * Math.cos(angle)
        );
    }
    private static Point2D rotateAround(final Point2D p, final Point2D p0, final double angle) {
        return pointAdd(p0, rotateOrigin(pointSub(p, p0), angle));
    }

    private static void setColor(final double width) {
        Color color = TRUNKCOLOR;

        if(width <= LEAFSIZE)
            color = LEAFCOLOR;
        else if(width <= BRANCHSIZE)
            color = BRANCHCOLOR;

        StdDraw.setPenColor(color);
    }

}