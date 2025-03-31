class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D sumar(Vector3D otro) {
        return new Vector3D(this.x + otro.x, this.y + otro.y, this.z + otro.z);
    }

    public Vector3D multiplicar(double escalar) {
        return new Vector3D(this.x * escalar, this.y * escalar, this.z * escalar);
    }

    public double norma() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalizar() {
        double norma = this.norma();
        return (norma == 0) ? new Vector3D(0, 0, 0) : new Vector3D(x / norma, y / norma, z / norma);
    }

    public double productoEscalar(Vector3D otro) {
        return this.x * otro.x + this.y * otro.y + this.z * otro.z;
    }

    public Vector3D productoVectorial(Vector3D otro) {
        return new Vector3D(
            this.y * otro.z - this.z * otro.y,
            this.z * otro.x - this.x * otro.z,
            this.x * otro.y - this.y * otro.x
        );
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(2, 4, 6);

        System.out.println("Suma de vectores: " + v1.sumar(v2));
        System.out.println("Multiplicación por escalar: " + v1.multiplicar(3));
        System.out.println("Norma del vector: " + v1.norma());
        System.out.println("Vector normalizado: " + v1.normalizar());
        System.out.println("Producto escalar: " + v1.productoEscalar(v2));
        System.out.println("Producto vectorial: " + v1.productoVectorial(v2));
    }
}
