package Matematicas;


import javax.swing.*;

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

    public double[][] varianzaVectorBi(double[][] x,double[][] y){
        double[][] matrizC=matrizC(x);
        double varianza=varianza(y,x);
        System.out.println("Varianza    "+varianza);
        double[][] varVector=new double[regresionLineal(y,x).length][1];
        for (int i=0;i<regresionLineal(y,x).length;i++){

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

    public  double Promedio(double[][] Y) {

        double promedioYEstimado=0;
        for(int i=0;i<Y.length;i++) {
            promedioYEstimado=promedioYEstimado+Y[i][0];
        }
        return (promedioYEstimado/Y.length);
    }

    public double varianza(double[][] Y,double[][] X){
        double suma=0;
        double[][] Yestimado=Yestimado(regresionLineal(Y,X),X);
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


    public double sumaCuadrados(double[][] yestimado){
        double resultado=0;
        double promedioYestimado=Promedio(yestimado);
        for (int i=0;i<yestimado.length;i++){
            resultado=resultado+(Math.pow(yestimado[i][0]-promedioYestimado,2));
        }
        return resultado;
    }

    public double[][] limiteSuperior(double[][] x,double[][] y,double talfa){
        double[][] matrizC=matrizC(x);
        double desviacionEstandar=Math.sqrt(varianza(y,x));
        double[][] limites=new double[regresionLineal(y,x).length][1];
        for (int i=0;i<regresionLineal(y,x).length;i++){
            limites[i][0]=regresionLineal(y,x)[i][0]+(talfa*desviacionEstandar*Math.sqrt(matrizC[i][i]));
        }

        return limites;
    }


    public double[][] limiteInferior(double[][] x,double[][] y,double talfa){
        double[][] matrizC=matrizC(x);
        double desviacionEstandar=Math.sqrt(varianza(y,x));

        double[][] limites=new double[regresionLineal(y,x).length][1];
        for (int i=0;i<regresionLineal(y,x).length;i++){
            limites[i][0]=regresionLineal(y,x)[i][0]-(talfa*desviacionEstandar*Math.sqrt(matrizC[i][i]));
        }
        return limites;
    }


    public double[][] valorTEstimado(double[][] x,double[][] y){
        double[][] matrizC=matrizC(x);
        double[][] t=new double[regresionLineal(y,x).length][1];
        double desviacionEstandar=Math.sqrt(varianza(y,x));

        for (int i=0;i<regresionLineal(y,x).length;i++){
            t[i][0]=(regresionLineal(y,x)[i][0])/(desviacionEstandar*Math.sqrt(matrizC[i][i]));
        }
        return t;
    }

    public String[][] pruebaSignificanciaIndividual(double[][] x,double[][] y,double talfa){
        String[][] RechazaH=new String[regresionLineal(y,x).length][1];
        double[][] t=valorTEstimado(x,y);

        for (int i=0;i<regresionLineal(y,x).length;i++){
            if (Math.abs(t[i][0])>talfa){
                RechazaH[i][0]="Se rechaza H0 =====>  Bi=Bi0";
            }else{
                RechazaH[i][0]="Se acepta H0 =====>  Bi!=Bi0";
            }
        }
        return RechazaH;
    }

    public double[][] datosdouble(int[][] datos){
        double[][] datosdouble=new double[datos.length][1];

        for (int i=0;i<datos.length;i++){
            datosdouble[i][0]=(double) datos[i][0];
        }
        return datosdouble;
    }

    public double[][] deltaY(double[][] y){
        double[][] delta=new double[y.length-1][1];
        for(int i=0;i<y.length;i++){
                delta[i][0]=(double) y[i+1][0]-y[i][0];
                System.out.println(delta[i][0]);
        }
        return delta;
    }

    public double[][] Y_1(double[][] y){
        double[][] y_1=new double[y.length-1][1];
        for(int i=0;i<y.length;i++){
            y_1[i][0]=y[i+1][0];
        }
        return y_1;
    }


    public double[][] autoregresion(double[][] y,int n){
        double[][] y_t_n=new double[y.length-n][n];
        for (int i=0;i<y_t_n.length;i++){
            for (int j=0;j<n;j++){
                y_t_n[i][j]=y[i+j][0];
            }
        }
        return y_t_n;
    }


    public double[][] y_n(double[][] y,int n){
        double[][] y_n=new double[y.length-n][1];
        for (int i=0;i<y_n.length;i++){
                y_n[i][0]=y[i+n][0];
        }
        return y_n;
    }

}
