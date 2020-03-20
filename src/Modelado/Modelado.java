package Modelado;

import Matriz.Matriz;

import java.util.ArrayList;

public class Modelado {

    Matriz matriz;
    public double[][] regresionLineal(double[][] y,double[][] x){
         Matriz matriz=new Matriz();
         double[][] Betai;
         double[][] XXt_1=matriz.metodoFadeva(matriz.multiplicacionMatriz(matriz.transpuestaMatriz(x),x));
         double[][] XtY=matriz.multiplicacionMatriz(matriz.transpuestaMatriz(x),y);
         Betai=matriz.multiplicacionMatriz(XXt_1,XtY);
         return Betai;
    }

    public double[][] varianzaVectorBi(double[][] matrizC,double[][] vectorBi,double varianza){

        double[][] varVector=new double[vectorBi.length][1];
        for (int i=0;i<vectorBi.length;i++){
            varVector[i][0]=varianza*matrizC[i][i];
        }
        return varVector;
    }

    public double[][] Yestimado(double[][] alfai,double[][] x){
        double[][] resultado=new double[x.length][1];
        for(int i=0;i<x.length;i++){
            double suma=alfai[0][0];
           // String cadena=suma+" ";
            for(int j=1;j<alfai.length;j++) {
                suma=suma+alfai[j][0]*x[i][j];
              //  cadena+=" "+suma+" ";
            }
            //System.out.println("numero "+i+": "+cadena+" = " +suma);
            resultado[i][0]=suma;
        }
        return resultado;
    }

    public  double Promedio(double[] Y) {

        double promedioYEstimado=0;
        for(int i=0;i<Y.length;i++) {
            promedioYEstimado=promedioYEstimado+Y[i];
        }
        return (promedioYEstimado/Y.length);
    }

    public double varianza(double[][] Y,double[][] Yestimado,double[][] X){
        double suma=0;
        for (int i=0;i<Y.length;i++){
            suma=suma+(Math.pow(Y[i][0]-Yestimado[i][0],2));
        }
        suma=(suma/(X.length-X[0].length-1));
        return suma;
    }
    public double[][] matrizC(double[][] x){
        Matriz matriz=new Matriz();
        return matriz.metodoFadeva(matriz.multiplicacionMatriz(matriz.transpuestaMatriz(x),x));

    }

}
