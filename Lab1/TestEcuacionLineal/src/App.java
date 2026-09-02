import java.util.Scanner;

class EcuacionLineal {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean tieneSolucion() {
        return (this.a * this.d - this.b * this.c) != 0;
    }

    public double getX() {
        return (this.e * this.d - this.b * this.f) / (this.a * this.d - this.b * this.c);
    }

    public double getY() {
        return (this.a * this.f - this.e * this.c) / (this.a * this.d - this.b * this.c);
    }
}

public class TestEcuacionLineal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese a, b, c, d, e, f: ");
        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        double c = teclado.nextDouble();
        double d = teclado.nextDouble();
        double e = teclado.nextDouble();
        double f = teclado.nextDouble();
        
        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);
        
        if (ecuacion.tieneSolucion()) {
            System.out.println("x = " + ecuacion.getX() + ", y = " + ecuacion.getY());
        } else {
            System.out.println("La ecuacion no tiene solucion");
        }
        
        teclado.close();
    }
}