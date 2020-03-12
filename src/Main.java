import Matriz.Matriz;

public class Main {
     public static void main(String[] args) {
         double[][] x= {{1,11,3,1},{1,5,1.5,2},{1,10,1,1},{1,20,2,1}};
         double[][] x2= {{3,10,5},{1,5,4},{2,3,8}};

         Matriz matriz=new Matriz();
        // matriz.showMatriz();

         System.out.println("MAtrix inicial es: ");
         matriz.mostrarMatriz(x2);
         System.out.println("El determinante de la matriz es: "+matriz.determinanteMatriz(x));
         //matriz.mostrarMatriz();

        // System.out.println("El determinante es: "+matriz.determinanteMatriz(x2));

    }
}
