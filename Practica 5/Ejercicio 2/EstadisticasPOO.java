import java.util.Scanner;
import java.util.Locale;

class Estadisticas {
    private double[] numeros;

    public Estadisticas(double[] numeros) {
        this.numeros = numeros;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double suma = 0;
        for (double num : numeros) {
            suma += Math.pow(num - promedio, 2);
        }
        return Math.sqrt(suma / (numeros.length - 1));
    }
}

public class EstadisticasPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Punto como separador decimal

        System.out.println("Ingrese 10 números:");
        double[] numeros = new double[10];

        for (int i = 0; i < 10; i++) {
            if (scanner.hasNextDouble()) {
                numeros[i] = scanner.nextDouble();
            } else {
                System.out.println("Error: Entrada inválida, ingrese solo números.");
                scanner.next(); 
                i--; 
            }
        }

        Estadisticas estadisticas = new Estadisticas(numeros);

        System.out.printf("El promedio es %.2f%n", estadisticas.calcularPromedio());
        System.out.printf("La desviación estándar es %.5f%n", estadisticas.calcularDesviacion());

        scanner.close();
    }
}

