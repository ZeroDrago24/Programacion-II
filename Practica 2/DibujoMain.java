import javax.swing.*;
import java.awt.*;

class Punto {
    public float x, y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

class Linea {
    public Punto p1, p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toString() {
        return "Línea desde " + p1 + " hasta " + p2;
    }
}

class Circulo {
    public Punto centro;
    public float radio;

    public Circulo(Punto c, float r) {
        this.centro = c;
        this.radio = r;
    }

    public String toString() {
        return "Círculo con centro en " + centro + " y radio " + String.format("%.2f", radio);
    }
}
 
class Dibujo extends JPanel {
    private Linea linea;
    private Circulo circulo;

    public Dibujo(Linea linea, Circulo circulo) {
        this.linea = linea;
        this.circulo = circulo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

         
        g.drawLine((int) linea.p1.x * 50 + 100, (int) linea.p1.y * 50 + 100, 
                   (int) linea.p2.x * 50 + 100, (int) linea.p2.y * 50 + 100);

         
        g.setColor(Color.RED);
        int radioEscalado = (int) circulo.radio * 50;
        g.drawOval((int) circulo.centro.x * 50 + 100 - radioEscalado, 
                   (int) circulo.centro.y * 50 + 100 - radioEscalado, 
                   radioEscalado * 2, radioEscalado * 2);
    }
}
 
public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(0.0f, 3.0f);
        Punto p2 = new Punto(4.0f, 7.0f);
        Linea linea = new Linea(p1, p2);
        Circulo circulo = new Circulo(p1, 5.0f);

        // Crear la ventana
        JFrame frame = new JFrame("Dibujo en Java");
        Dibujo dibujo = new Dibujo(linea, circulo);
        frame.add(dibujo);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
