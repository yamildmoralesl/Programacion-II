import java.util.Scanner;

class EcuacionCuadratica {
    private double a;
    private double b;
    private double c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public double getRaiz1() {
        double discriminante = getDiscriminante();
        if (discriminante < 0) {
            return 0;
        }
        return (-this.b + Math.sqrt(discriminante)) / (2 * this.a);
    }

    public double getRaiz2() {
        double discriminante = getDiscriminante();
        if (discriminante < 0) {
            return 0;
        }
        return (-this.b - Math.sqrt(discriminante)) / (2 * this.a);
    }
}

public class TestEcuacionCuadratica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese a, b, c: ");
        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        double c = teclado.nextDouble();
        
        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        double discriminante = ecuacion.getDiscriminante();
        
        if (discriminante > 0) {
            System.out.println("La ecuacion tiene dos raices " + ecuacion.getRaiz1() + " y " + ecuacion.getRaiz2());
        } else if (discriminante == 0) {
            System.out.println("La ecuacion tiene una raiz " + ecuacion.getRaiz1());
        } else {
            System.out.println("La ecuacion no tiene raices reales");
        }
        
        teclado.close();
    }
}