import java.text.DecimalFormat;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] coordCartesianas() {
        return new double[]{x, y};
    }

    public double[] coordPolares() {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.toDegrees(Math.atan2(y, x));
        return new double[]{r, theta};
    }

    @Override
    public String toString() {
        return "Punto(x=" + x + ", y=" + y + ")";
    }

    public static void main(String[] args) {
        Punto p = new Punto(7, 9);
        System.out.println(p);

        double[] cartesianas = p.coordCartesianas();
        System.out.println("Cartesianas: (" + cartesianas[0] + ", " + cartesianas[1] + ")");

        double[] polares = p.coordPolares();
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Polares: (r=" + df.format(polares[0]) + ", theta=" + df.format(polares[1]) + "°)");
    }
}
