import java.util.Scanner;

public class EcuacionCuadraticaModular {
    public static double getDiscriminante(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double getRaiz1(double a, double b, double discriminante) {
        return (-b + Math.sqrt(discriminante)) / (2 * a);
    }

    public static double getRaiz2(double a, double b, double discriminante) {
        return (-b - Math.sqrt(discriminante)) / (2 * a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        sc.close();

        double discriminante = getDiscriminante(a, b, c);

        if (discriminante > 0) {
            System.out.printf("La ecuación tiene dos raíces %.5f y %.5f%n",
                    getRaiz1(a, b, discriminante), getRaiz2(a, b, discriminante));
        } else if (discriminante == 0) {
            System.out.printf("La ecuación tiene una raíz %.5f%n", -b / (2 * a));
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }
    }
}
