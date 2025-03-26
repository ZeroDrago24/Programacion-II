import java.util.Scanner;
import java.util.Locale;

public class EstadisticasModular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Uso del punto como separador decimal

        System.out.println("Ingrese 10 números:");
        double[] numeros = new double[10];

        for (int i = 0; i < 10; i++) {
            if (scanner.hasNextDouble()) {
                numeros[i] = scanner.nextDouble();
            } else {
                System.out.println("Error: Entrada inválida, ingrese solo números.");
                scanner.next(); 
                i--; // Pedir de nuevo el número
            }
        }

        double promedio = calcularPromedio(numeros);
        double desviacion = calcularDesviacion(numeros, promedio);

        System.out.printf("El promedio es %.2f%n", promedio);
        System.out.printf("La desviación estándar es %.5f%n", desviacion);

        scanner.close();
    }

    public static double calcularPromedio(double[] datos) {
        double suma = 0;
        for (double num : datos) {
            suma += num;
        }
        return suma / datos.length;
    }

    public static double calcularDesviacion(double[] datos, double promedio) {
        double suma = 0;
        for (double num : datos) {
            suma += Math.pow(num - promedio, 2);
        }
        return Math.sqrt(suma / (datos.length - 1));
    }
}
