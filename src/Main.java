import Matriz.Matriz;
import Modelado.Modelado;

public class Main {
     public static void main(String[] args) {

         double[][] y = {{72},{63},{65},{68},{78},{64},{56},{59},{60},{85},{67},{61},{65},{79},{61},{52},{65}};
         double[][] x= {{1,10,3,1},{1,5,1.5,1},{1,10,1,1},{1,20,2,1},{1,15,4,1},{1,10,2,1},{1,6,0,0},{1,25,1,1},{1,30,2,1},{1,10,1,1},{1,10,1,1},{1,20,1,1},{1,20,0.5,1},{1,20,2,1},{1,30,0.5,1},{1,20,1,0},{1,10,1,1}};
         double[][] prueba={{2,5,8},{44,75,2},{4,127,7}};
         Matriz matriz=new Matriz();


          Modelado modelado=new Modelado();
         matriz.mostrarMatriz(modelado.regresionLineal(y,x));
//         System.out.println("MAtriz C");
//          matriz.mostrarMatriz(modelado.matrizC(x));
//
//          matriz.mostrarMatriz(modelado.matrizC(x));

//           matriz.mostrarMatriz(matriz.metodoFadeva(prueba));
//

//         System.out.println("DAtos de Y");
//        matriz.mostrarMatriz(y);
//
         System.out.println("Datos Y estimado");
        matriz.mostrarMatriz(modelado.Yestimado(modelado.regresionLineal(y,x),x));
    }
}
