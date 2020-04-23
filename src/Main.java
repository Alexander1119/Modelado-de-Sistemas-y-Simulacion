import Matematicas.Matriz;
import Matematicas.Modelado;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String args[]) {
//        double[][] y = {{72},{63},{65},{68},{78},{64},{56},{59},{60},{85},{67},{61},{65},{79},{61},{52},{65}};
//        double[][] x= {{1,10,3,1},{1,5,1.5,1},{1,10,1,1},{1,20,2,1},{1,15,4,1},{1,10,2,1},{1,6,0,0},{1,25,1,1},{1,30,2,1},{1,10,1,1},{1,10,1,1},{1,20,1,1},{1,20,0.5,1},{1,20,2,1},{1,30,0.5,1},{1,20,1,0},{1,10,1,1}};

        Modelado modelado = new Modelado();
        Matriz matriz = new Matriz();
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

//        double[][] y_t_n=modelado.autoregresionDesintegradaY(y,3);
//        double[][] y_n=modelado.y_n(modelado.autoregresiondesintegradaX(y,1),3);
//        matriz.mostrarMatriz(modelado.agregarColaMatriz(y,y_n));

//
//        System.out.println("Los ai son:");
//        double[][] ai=modelado.regresionLineal(y_n,y_t_n);
//        matriz.mostrarMatriz(ai);


//        System.out.println("\n Los gamai son:");
//        double[][] gamai=modelado.gamai(y_t_n,y_n);
//        matriz.mostrarMatriz(gamai);
//
//
//        System.out.println("\nMatriz mas un dato pronosticado:");
//        double[][] matrizmasundato=modelado.pronostico(gamai,y_n,3);
//        matriz.mostrarMatriz(matrizmasundato);
//


        double[][] y ={{20},{27},{22},{24},{28},{33},{40},{42},{48},{52},{50},{47},{58},{67},{77},{73},{72},{80},{83},{80},{90}};

//        matriz.mostrarMatriz( modelado.pronosticar(y,3,10));


        double[][] X = {
                {10,3.06,1.34,8.48,28},
                {15,3.19,1.44,9.16,35},
                {20,3.3,1.54,9.9,37},
                {25,3.4,1.71,11.02,36},
                {34,3.48,1.89,11.64,29},
                {27,3.6,1.99,12.73,47},
                {28,3.68,2.22,13.88,50},
                {40, 3.72, 2.43, 14.5, 35},
                {37,3.92,2.43,15.47,33},
                {36,4.15,2.31,16.61,40},
                {32,4.35,2.39,17.4,38},
                {30,4.37,2.63,18.83,37},
                {36,4.59,2.69,20.62,56},
                {41,5.23,3.35,23.76,88},
                {45,6.04,2.81,26.52,62},
                {48, 6.36, 3.38, 27.45, 51},
                {49, 7.04, 3.14, 30.28, 29},
                {53, 7.81, 3.14, 25.4, 22},
                {57, 8.09, 6.19, 28.84, 38},
                {66, 9.24, 6.69, 34.36, 41}};


        double[][] Y = {{359.27, 102.96, 578.49},
                {415.76, 114.38, 650.86},
                {435.11, 118.23, 684.87},
                {440.17, 120.45, 680.47},
                {410.66, 116.25, 642.19},
                {530.33, 140.27, 787.41},
                {557.15, 143.84, 818.06},
                {472.8, 128.2, 712.16},
                {471.76, 126.65, 722.23},
                {538.3, 141.05, 811.44},
                {547.76, 143.71, 816.36},
                {539, 142.37, 807.78},
                {677.6, 173.13, 983.53},
                {943.85, 223.21, 1292.99},
                {893.42, 198.64, 1179.64},
                {871, 191.89, 1134.78},
                {793.93, 181.27, 1053.16},
                {850.36, 180.56, 1085.91},
                {967.42, 208.24, 1246.99},
                {1102.61, 235.43, 1401.94}};







        System.out.println("PI");
        matriz.mostrarMatriz(modelado.PiEstimado(X,Y));

        System.out.println("Y estimado");
        matriz.mostrarMatriz(matriz.multiplicacionMatriz(X,modelado.PiEstimado(X,Y)));

        System.out.println("primera ecuacion ");
        matriz.mostrarMatriz(modelado.regresionLineal(modelado.yy(Y,1),modelado.primeraecuacion(X,Y)));

        System.out.println("segunda ecuacion ");
        matriz.mostrarMatriz(modelado.regresionLineal(modelado.yy(Y,2),modelado.segundaecuacion(X,Y)));

        System.out.println("tercera ecuacion ");
        matriz.mostrarMatriz(modelado.regresionLineal(modelado.yy(Y,3),modelado.terceraecuacion(X,Y)));
//-------------------------------------------------------------------------------------------------------------
//        System.out.println("media de Y");
//        matriz.mostrarMatriz(modelado.mediaMatrizY(X,Y));
//
//        System.out.println("varianza de Y");
//        matriz.mostrarMatriz(modelado.varianzaMatrizY(X,Y));
//
//
//        System.out.println("Error: ");
//        matriz.mostrarMatriz(modelado.errorV(X,Y));
//
//        System.out.println("Ultimos datos  y1");
//        matriz.mostrarMatriz(modelado.pronosticarYi(modelado.sacarYi(Y,1),X,10,1));




    }

}


