public class Calc {

    public static boolean isValid(String x) {
        if (x.matches("[0-9]*.[0-9]*|[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static double toDouble(String x) {
        if (isValid(x)) {
            return Double.parseDouble(x);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static double addition(double x, double y) {
        return (x + y);
    }

    public static double multiplication(double x, double y) {
        return (x * y);
    }

    public static double substraction(double x, double y) {
        return (x - y);
    }

    public static double division(double x, double y) {
        return (x / y);
    }

    public static double sinus(double x, boolean rad) {
        if (rad) {
            return Math.sin(x);
        } else {
            return Math.sin(Math.toRadians(x));
        }
    }

    public static double cosinus(double x, boolean rad) {
        if (rad) {
            return Math.cos(x);
        } else {
            return Math.cos(Math.toRadians(x));
        }
    }

    public static double xToPowY(double x, double y) {
        return Math.pow(x, y);
    }

    public static double logTwo(double x) {
        return Math.log(x) / Math.log(2);
    }
}
