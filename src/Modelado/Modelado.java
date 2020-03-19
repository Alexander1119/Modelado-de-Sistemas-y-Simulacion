package Modelado;

import Matriz.Matriz;

public class Modelado {




    public double[][] regresionLineal(double[][] y,double[][] x){
         Matriz matriz=new Matriz();
         double[][] Betai;
         double[][] XXt_1=matriz.metodoFadeva(matriz.multiplicacionMatriz(matriz.transpuestaMatriz(x),x));
         double[][] XtY=matriz.multiplicacionMatriz(matriz.transpuestaMatriz(x),y);
         Betai=matriz.multiplicacionMatriz(XXt_1,XtY);
         return Betai;
    }
}
