import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

class Punto {
    double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

class Linea {
    Punto p1, p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toString() {
        return "Línea desde " + p1 + " hasta " + p2;
    }

    public void dibujaLinea(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine((int) p1.x , (int) p1.y, 
                   (int) p2.x, (int) p2.y);
    }
}

class Circulo {
    Punto centro;
    double radio;

    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public String toString() {
        return "Círculo con centro en " + centro + " y radio " + String.format("%.2f", radio);
    }

    public void dibujaCirculo(Graphics g) {
        g.setColor(Color.BLUE);
        int radioEscalado = (int) radio;
        g.drawOval((int) centro.x, 
                   (int) centro.y, 
                   radioEscalado * 2, radioEscalado * 2);
    }
}

public class Graficos extends JPanel {
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Atributos de punto, línea y círculo
        Punto p1 = new Punto(5, 5);
        Punto p2 = new Punto(5, 5);
        Linea linea = new Linea(p1, p2);
        Circulo circulo = new Circulo(p1, 5);

        // Mostrar información consola
        System.out.println(linea);
        System.out.println(circulo);

        // Dibujar la línea y el círculo
        linea.dibujaLinea(g);
        circulo.dibujaCirculo(g);
    }

    public static void main(String[] args) {
        // Configuración de la ventana
        JFrame ventana = new JFrame("Gráfico de Línea y Círculo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);
        ventana.add(new Graficos());
        ventana.setVisible(true);
    }
}
