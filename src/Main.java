import Matriz.Matriz;

public class Main {
     public static void main(String[] args) {
         double[][] x= {{1,10,3,1},{1,5,1.5,1},{1,10,1,1},{1,20,2,1},{1,15,4,1},{1,10,2,1}};
         Matriz matriz=new Matriz(x.length,x[0].length,x);
         matriz.showMatriz();

    }
}
