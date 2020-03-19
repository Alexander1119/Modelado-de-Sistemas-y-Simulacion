import Matriz.Matriz;

public class Main {
     public static void main(String[] args) {
         double[][] x= {{1,11,3,1},{1,5,1.5,2},{1,10,1,1},{1,20,2,1}};
         double[][] x2= {{3,10,5},{1,5,4},{2,3,8}};
         double[][] x3= {{3,4,-1},{1,0,3},{2,5,-4}};
         double[][] x4= {{4,4,-1},{1,1,3},{2,5,-3}};

         Matriz matriz=new Matriz();

         matriz.metodoFadeva(x3);
         matriz.mostrarMatriz(matriz.metodoFadeva(x3));

    }
}
