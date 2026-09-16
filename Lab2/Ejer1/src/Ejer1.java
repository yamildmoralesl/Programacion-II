class MiPunto {
    private double x;
    private double y;

    public MiPunto() {
        this(0.0, 0.0);
    }

    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distancia(MiPunto p) {
        return distancia(p.getX(), p.getY());
    }

    public double distancia(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
}

public class Ejer1 {
    public static void main(String[] args) {
        MiPunto p1 = new MiPunto();
        MiPunto p2 = new MiPunto(10.0, 30.5);

        System.out.println("Punto 1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Punto 2: (" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("Distancia de p1 a p2: " + p1.distancia(p2));
        System.out.println("Distancia de p1 a coordenadas (10, 30.5): " + p1.distancia(10.0, 30.5));
    }
}