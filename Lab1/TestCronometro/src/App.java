// Clase del objeto (sin la palabra "public")
class Cronometro {
    private long inicia;
    private long finaliza;

    public Cronometro() {
        this.inicia = System.currentTimeMillis();
    }

    public long getInicia() {
        return this.inicia;
    }

    public long getFinaliza() {
        return this.finaliza;
    }

    public void inicia() {
        this.inicia = System.currentTimeMillis();
    }

    public void detener() {
        this.finaliza = System.currentTimeMillis();
    }

    public long lapsoDeTiempo() {
        return this.finaliza - this.inicia;
    }
}

// Clase principal con el main (esta sí lleva "public")
public class TestCronometro {
    public static void main(String[] args) {
        int[] numeros = new int[100000];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 100000);
        }

        System.out.println("Iniciando la ordenacion de 100,000 numeros...");
        Cronometro cronometro = new Cronometro();

        for (int i = 0; i < numeros.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[minimo]) {
                    minimo = j;
                }
            }
            int auxiliar = numeros[minimo];
            numeros[minimo] = numeros[i];
            numeros[i] = auxiliar;
        }

        cronometro.detener();
        System.out.println("Ordenacion finalizada.");
        System.out.println("Tiempo de ejecucion: " + cronometro.lapsoDeTiempo() + " milisegundos.");
    }
}