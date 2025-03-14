public class FiguraGeometrica {
    double area(double radio){
        return Math.PI*radio*radio;
    }
    double area(double base, double altura){
        return base*altura;
    }
    double area(double base, double altura, boolean esTriangulo){
        return (base*altura)/2;
    }
    double area(double BaseMayor, double BaseMenor, double altura){
        return ((BaseMayor*BaseMenor)/2)*altura;
    }
    double area(double Perimetro, double apotema, String poligono){
        return ((Perimetro*apotema)/2);
    }
public static void main (String [] args) {
    FiguraGeometrica f1 = new FiguraGeometrica();
    FiguraGeometrica f2 = new FiguraGeometrica();
    FiguraGeometrica f3 = new FiguraGeometrica();
    FiguraGeometrica f4 = new FiguraGeometrica();
    FiguraGeometrica f5 = new FiguraGeometrica();

    System.out.println("Circulo "+f1.area(1));
    System.out.println("Rectangulo "+f2.area(2,3));
    System.out.println("Triangulo "+f3.area(5,6,true));
    System.out.println("Trapecio "+f4.area(4,3,2));
    System.out.println("Poligono "+f5.area(5,7,"poligono"));
}
}
