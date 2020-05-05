import java.util.Scanner;

public class Poisson {
    public static void main(String[] args) {
        double land,cantidad;
        System.out.println("Poisson");
        Scanner entra = new Scanner (System.in);

        Scanner cant = new Scanner (System.in);
        land =entra.nextDouble();
        cantidad = cant.nextDouble();
        int n=0;
        for (int i=0; i<=cantidad; i++){
            n = getPoisson(land);
            System.out.println("  " + n);
        }
    }

    public static int getPoisson (double lambda){
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do{
            k++;
            p *= Math.random();
        } while (p > L);
        return k-1;
    }


}
