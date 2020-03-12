package Matriz;

public class Matriz {

	int numberRows;
	int numberColumns;
	double[][] matrizDouble = new double[numberRows][numberColumns];
	int[][] matrizInt = new int[numberRows][numberColumns];

	public Matriz(int numberRows, int numberColumns, double[][] matrizDouble) {
		this.numberRows = numberRows;
		this.numberColumns = numberColumns;
		this.matrizDouble = matrizDouble;
	}

	public Matriz(int numberRows, int numberColumns, int[][] matrizInt) {
		this.numberRows = numberRows;
		this.numberColumns = numberColumns;
		this.matrizInt = matrizInt;
	}

	public Matriz() {
	}

	public int getNumberRows() {
		return numberRows;
	}

	public void setNumberRows(int numberRows) {
		this.numberRows = numberRows;
	}

	public int getNumberColumns() {
		return numberColumns;
	}

	public void setNumberColumns(int numberColumns) {
		this.numberColumns = numberColumns;
	}

	public double[][] getMatrizDouble() {
		return matrizDouble;
	}

	public void setMatrizDouble(double[][] matrizDouble) {
		this.matrizDouble = matrizDouble;
	}

	public int[][] getMatrizInt() {
		return matrizInt;
	}

	public void setMatrizInt(int[][] matrizInt) {
		this.matrizInt = matrizInt;
	}


	public void mostrarMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public double[][] transpuestaMatriz(double[][] matriz) {

		double[][] transposedResult = new double[getMatrizDouble()[0].length][getMatrizDouble().length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				transposedResult[j][i] = matriz[i][j];
			}
		}
		return transposedResult;
	}

	public double[][] multiplicacionMatriz(double[][] matriz1, double[][] matriz2) {
		double[][] multiplicationResult = new double[matriz1.length][matriz2[0].length];
		if (matriz1[0].length == matriz2.length) {

		} else {
			throw new RuntimeException("No se puede multiplicar las matrices");
		}

		return multiplicationResult;
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
					int contador=0,ii=0,jj=j;
					while (contador<matriz2.length){
							multiplicacion=multiplicacion*matriz2[ii][jj];
						System.out.println("Se multiplicara la posicion ["+ii+" , "+jj+"]");
							ii++;
							jj++;
							contador++;
					}
					suma1=suma1+multiplicacion;
				}

			System.out.println("RESTAS: \n");
				for(int j=0;j<matriz2.length;j++){
					double multiplicacion=1;
					int contador=0,ii=matriz.length-1,jj=j;
					while (contador<matriz2.length){
						multiplicacion=multiplicacion*matriz2[ii][jj];
						System.out.println("Se multiplicara la posicion ["+ii+" , "+jj+"] con valor: "+matriz2[ii][jj]);
						ii--;
						jj++;
						contador++;
					}
					suma2=suma2+multiplicacion;
					System.out.println(suma2);
				}

		}else {
			throw new RuntimeException("La matriz no es cuadrada");
		}
		return suma1-suma2;
	}




}