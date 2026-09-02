import java.util.Scanner;

class Estadistica {
    private double[] datos;

    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double suma = 0;
        for (int i = 0; i < this.datos.length; i++) {
            suma += this.datos[i];
        }
        return suma / this.datos.length;
    }

    public double desviacion() {
        double media = this.promedio();
        double sumatoriaCuadrados = 0;
        
        for (int i = 0; i < this.datos.length; i++) {
            sumatoriaCuadrados += Math.pow(this.datos[i] - media, 2);
        }
        
        return Math.sqrt(sumatoriaCuadrados / (this.datos.length - 1));
    }
}

public class TestEstadistica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double[] numeros = new double[10];
        
        System.out.print("Ingrese 10 números: ");
        for (int i = 0; i < 10; i++) {
            numeros[i] = teclado.nextDouble();
        }
        
        Estadistica estadistica = new Estadistica(numeros);
        
        System.out.printf("El promedio es %.2f\n", estadistica.promedio());
        System.out.printf("La desviacion estandard es %.5f\n", estadistica.desviacion());
        
        teclado.close();
    }
}