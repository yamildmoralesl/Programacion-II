class AlgebraVectorial {
    private double[] a;
    private double[] b;

    public AlgebraVectorial() {
        this.a = new double[]{0.0, 0.0, 0.0};
        this.b = new double[]{0.0, 0.0, 0.0};
    }

    public AlgebraVectorial(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }

    public static double magnitud(double[] v) {
        return Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
    }

    public static double prodEscalar(double[] a, double[] b) {
        return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
    }

    public static double[] prodCruz(double[] a, double[] b) {
        return new double[]{
            a[1] * b[2] - a[2] * b[1],
            a[2] * b[0] - a[0] * b[2],
            a[0] * b[1] - a[1] * b[0]
        };
    }

    public boolean perpendicular(double[] a, double[] b) {
        double[] suma = {a[0] + b[0], a[1] + b[1], a[2] + b[2]};
        double[] resta = {a[0] - b[0], a[1] - b[1], a[2] - b[2]};
        return Math.abs(magnitud(suma) - magnitud(resta)) < 1e-6;
    }

    public boolean perpendicular(double modAmB, double modBmA) {
        return Math.abs(modAmB - modBmA) < 1e-6;
    }

    public boolean perpendicular(double prodEscalar) {
        return Math.abs(prodEscalar) < 1e-6;
    }

    public boolean perpendicular(double[] a, double[] b, boolean esPitagoras) {
        double[] suma = {a[0] + b[0], a[1] + b[1], a[2] + b[2]};
        double magSumaCuad = Math.pow(magnitud(suma), 2);
        double magACuadPlusBCuad = Math.pow(magnitud(a), 2) + Math.pow(magnitud(b), 2);
        return Math.abs(magSumaCuad - magACuadPlusBCuad) < 1e-6;
    }

    public boolean paralela(double[] a, double[] b, double r) {
        return Math.abs(a[0] - r * b[0]) < 1e-6 &&
               Math.abs(a[1] - r * b[1]) < 1e-6 &&
               Math.abs(a[2] - r * b[2]) < 1e-6;
    }

    public boolean paralela(double[] prodCruz) {
        return magnitud(prodCruz) < 1e-6;
    }

    public double[] proyeccion_de_a_sobre_b(double[] a, double[] b) {
        double esc = prodEscalar(a, b) / Math.pow(magnitud(b), 2);
        return new double[]{esc * b[0], esc * b[1], esc * b[2]};
    }

    public double componente_de_a_en_b(double[] a, double[] b) {
        return prodEscalar(a, b) / magnitud(b);
    }
}

public class Ejer2 {
    public static void main(String[] args) {
        double[] a = {1.0, 0.0, 0.0};
        double[] b = {0.0, 1.0, 0.0};

        AlgebraVectorial av1 = new AlgebraVectorial();
        AlgebraVectorial av2 = new AlgebraVectorial(a, b);

        System.out.println("a) Perpendicular (|a+b|=|a-b|): " + av2.perpendicular(a, b));
        
        double[] amb = {a[0] - b[0], a[1] - b[1], a[2] - b[2]};
        double[] bma = {b[0] - a[0], b[1] - a[1], b[2] - a[2]};
        System.out.println("b) Perpendicular (|a-b|=|b-a|): " + av2.perpendicular(AlgebraVectorial.magnitud(amb), AlgebraVectorial.magnitud(bma)));
        
        System.out.println("c) Perpendicular (a.b = 0): " + av2.perpendicular(AlgebraVectorial.prodEscalar(a, b)));
        System.out.println("d) Perpendicular (Pitágoras): " + av2.perpendicular(a, b, true));

        double[] p = {2.0, 0.0, 0.0};
        double[] q = {1.0, 0.0, 0.0};
        System.out.println("e) Paralela (a = r*b): " + av2.paralela(p, q, 2.0));
        System.out.println("f) Paralela (a x b = 0): " + av2.paralela(AlgebraVectorial.prodCruz(p, q)));

        double[] proy = av2.proyeccion_de_a_sobre_b(a, b);
        System.out.println("g) Proyección: (" + proy[0] + ", " + proy[1] + ", " + proy[2] + ")");
        System.out.println("h) Componente: " + av2.componente_de_a_en_b(a, b));
    }
}