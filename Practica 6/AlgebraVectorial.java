class AlgebraVectorial {
    private double x, y, z;


    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double norma() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double productoPunto(AlgebraVectorial otro) {
        return x * otro.x + y * otro.y + z * otro.z;
    }

    public AlgebraVectorial productoCruz(AlgebraVectorial otro) {
        return new AlgebraVectorial(
            y * otro.z - z * otro.y,
            z * otro.x - x * otro.z,
            x * otro.y - y * otro.x
        );
    }

    public boolean esPerpendicular(AlgebraVectorial otro) {
        return this.productoPunto(otro) == 0;
    }

    public boolean esParalelo(AlgebraVectorial otro) {
        AlgebraVectorial cruz = this.productoCruz(otro);
        return cruz.x == 0 && cruz.y == 0 && cruz.z == 0;
    }

    public AlgebraVectorial proyeccionSobre(AlgebraVectorial otro) {
        double factor = this.productoPunto(otro) / (otro.norma() * otro.norma());
        return new AlgebraVectorial(otro.x * factor, otro.y * factor, otro.z * factor);
    }

    public double componenteSobre(AlgebraVectorial otro) {
        return this.productoPunto(otro) / otro.norma();
    }

    public static void main(String[] args) {
        AlgebraVectorial v1 = new AlgebraVectorial(1, 2, 3);
        AlgebraVectorial v2 = new AlgebraVectorial(2, 4, 6);

        System.out.println("Perpendiculares: " + v1.esPerpendicular(v2));
        System.out.println("Paralelos: " + v1.esParalelo(v2));
        System.out.println("Proyección de v1 sobre v2: " + v1.proyeccionSobre(v2).x + ", " +
                v1.proyeccionSobre(v2).y + ", " + v1.proyeccionSobre(v2).z);
        System.out.println("Componente de v1 en v2: " + v1.componenteSobre(v2));
    }
}
