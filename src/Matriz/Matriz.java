package Matriz;

import java.text.DecimalFormat;

public class Matriz {



	public Matriz() {
	}

	public void mostrarMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print((matriz[i][j]) + "   ");			}
			System.out.println();
		}
	}

	public double[][] transpuestaMatriz(double[][] matriz) {

		double[][] transposedResult = new double[matriz[0].length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				transposedResult[j][i] = matriz[i][j];
			}
		}
		return transposedResult;
	}

	public double[][] multiplicacionMatriz(double[][] matriz1, double[][] matriz2) {
		double[][] multiplicationResultado = new double[matriz1.length][matriz2[0].length];
		if (matriz1[0].length == matriz2.length) {
			for (int i=0;i<matriz1.length;i++) {
				for (int j=0;j<matriz2[0].length;j++) {
					for (int k=0;k<matriz1[0].length;k++) {
						multiplicationResultado[i][j]+=matriz1[i][k]*matriz2[k][j];
					}
				}
			}
		} else {
			throw new RuntimeException("No se puede multiplicar las matrices");
		}
		return multiplicationResultado;
	}


	public double determinanteMatriz(double[][] matriz){
		double determinante=0;
		double suma1=0,suma2=0;
		double[][] matriz2=new double[matriz.length][matriz.length+matriz.length-1];

		if (matriz.length==matriz[0].length){
			for (int i=0;i<matriz2.length;i++){
				for (int j=0;j<matriz2[0].length;j++){
					if (j>=matriz[0].length){
						matriz2[i][j]=matriz[i][j-matriz.length];
					}if (j<matriz[0].length){
						matriz2[i][j]=matriz[i][j];
					}
				}
			}
			System.out.println("La matriz es cuadrada");
				for (int j=0;j<matriz2.length;j++){
					double multiplicacion=1;
					double multiplicacion2=1;
					int contador=0,ii=0,jj=j,iii=matriz.length-1;
					while (contador<matriz2.length){
							multiplicacion=multiplicacion*matriz2[ii][jj];
							multiplicacion2=multiplicacion2*matriz2[iii][jj];
							ii++;
							iii--;
							jj++;
							contador++;
					}
					suma1=suma1+multiplicacion;
					suma2=suma2+multiplicacion2;
				}

		}else {
			throw new RuntimeException("La matriz no es cuadrada");
		}
		return suma1-suma2;
	}


	public double[][] metodoFadeva(double[][] matrizA){

		int iteraciones=1;
		double[][] inversa;
		double[][] A1=matrizA;
		double Q1=Q_sumatrazaMetodoFadeva(A1,iteraciones);
		double[][] B1=B1(Q1,A1);
		double[][] Bn_1=new double[matrizA.length][matrizA.length];
		while (!cerosMatriz(B1)){
			Bn_1=B1;
			iteraciones++;
			A1=multiplicacionMatriz(matrizA,B1);
			Q1=Q_sumatrazaMetodoFadeva(A1,iteraciones);
			B1=B1(Q1,A1);
//			System.out.println(iteraciones);
//			mostrarMatriz(A1);
//			System.out.println(Q1);
//			mostrarMatriz(B1);
//			System.out.println("Matriz Bn-1 es: ");
//			mostrarMatriz(Bn_1);
		}
		inversa=QxI(1/Q1,Bn_1);

		return inversa;
	}

	private double[][] B1(double Qn,double[][] An){
		//double[][] Bn=new double[A.length][A.length];
		double[][] Bn=new double[An.length][An.length];
		Bn=restaMatrices(An,QxI(Qn,matrizIdentidad(An.length)));
		return Bn;
	}

	public double[][] QxI(double Q,double[][] identidad){
		double[][] QxI=new double[identidad.length][identidad.length];
		for (int i=0;i<identidad.length;i++){
			for (int j=0;j<identidad[0].length;j++){
				QxI[i][j]=Q*identidad[i][j];
			}
		}
		return QxI;
	}

	private double Q_sumatrazaMetodoFadeva(double[][] An,int den){
		double Q=0;
		for (int i=0;i<An.length;i++){
			for (int j=0;j<An.length;j++){
				if (i==j){
					Q=Q+An[i][i];
				}
			}
		}

		return Q/den;
	}

	private double[][] matrizIdentidad(int tamaño){
		double[][] identidad=new double[tamaño][tamaño];
		for (int i=0;i<tamaño;i++){
			for (int j=0;j<tamaño;j++){
				if (i==j){
					identidad[i][j]=1;
				}else {
					identidad[i][j]=0;
				}
			}
		}

		return identidad;
	}
	public boolean cerosMatriz(double[][] matriz){
		boolean ceros=true;
		for (int i=0;i<matriz.length;i++){
			for (int j=0;j<matriz[0].length;j++){
				if (matriz[i][j]!=0){
					ceros=false;
				}
			}
		}
		return ceros;
	}

	public double[][] restaMatrices(double[][] matriz,double[][] matriz2){
		double[][] resultado=new double[matriz.length][matriz[0].length];
		for (int i=0;i<resultado.length;i++){
			for (int j=0;j<resultado[0].length;j++){
				resultado[i][j]=matriz[i][j]-matriz2[i][j];
			}
		}
		return resultado;
	}

}