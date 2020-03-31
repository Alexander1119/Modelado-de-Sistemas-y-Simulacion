import Matematicas.Matriz;
import Matematicas.Modelado;
import Matematicas.Probabilidad;

public class Main {

    public static void main(String args[]){
//        double[][] y = {{72},{63},{65},{68},{78},{64},{56},{59},{60},{85},{67},{61},{65},{79},{61},{52},{65}};
//        double[][] x= {{1,10,3,1},{1,5,1.5,1},{1,10,1,1},{1,20,2,1},{1,15,4,1},{1,10,2,1},{1,6,0,0},{1,25,1,1},{1,30,2,1},{1,10,1,1},{1,10,1,1},{1,20,1,1},{1,20,0.5,1},{1,20,2,1},{1,30,0.5,1},{1,20,1,0},{1,10,1,1}};
//
//
        Modelado modelado=new Modelado();
        Matriz matriz=new Matriz();
//
//        System.out.println("Bi");
//        matriz.mostrarMatriz(modelado.regresionLineal(y,x));
//        System.out.println("Varianzas de Bi");
//        matriz.mostrarMatriz(modelado.varianzaVectorBi(x,y));
//
//        double talfa=3.634;
//        System.out.println("Limite de confianza superior");
//        matriz.mostrarMatriz(modelado.limiteInferior(x,y,talfa));
//
//        System.out.println("Limite de confianza inferior");
//        matriz.mostrarMatriz(modelado.limiteSuperior(x,y,talfa));
//
//        System.out.println("Valores t estimado");
//        matriz.mostrarMatriz(modelado.valorTEstimado(x,y));
//
//        System.out.println("Prueba de significancia individual ");
//        matriz.mostrarMatrizString(modelado.pruebaSignificanciaIndividual(x,y,talfa));














//        double STC=modelado.sumaCuadrados(y);
//        double SEC=modelado.sumaCuadrados(modelado.Yestimado(modelado.regresionLineal(y,x),x));
//        double SRC=STC-SEC;
//        double Ft=2.668;
//        double F=(SEC/(x[0].length-2))/(SRC/(x.length-(x[0].length-1)));
//
//
//        System.out.println("F hallado "+F);
//        System.out.println("Fde tablas "+Ft);
//        if (F>Ft){
//            System.out.println("Se rechaza H0");
//        }else {
//            System.out.println("Se acepta H0");
//        }

        double[][] y ={{20},{27},{22},{24},{28},{33},{40},{42},{48},{52},{50},{47},{58},{67},{77},{73},{72},{80},{83},{80},{90}};
//        double[][] deltaY=modelado.deltaY(y);
//        double[][] Y_1=modelado.Y_1(y);
        //matriz.mostrarMatriz(y);
//        matriz.mostrarMatriz(deltaY);
//        matriz.mostrarMatriz(Y_1);
        double[][] y_n=modelado.y_n(y,3);
        double[][] y_t_n=modelado.autoregresion(y,3);
        matriz.mostrarMatriz(y_n);
        matriz.mostrarMatriz(y_t_n);
        matriz.mostrarMatriz(modelado.regresionLineal(y_n,y_t_n));

    }
}
