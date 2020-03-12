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


	public void showMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public double[][] transposedMatriz(double[][] matriz) {

		double[][] transposedResult = new double[getMatrizDouble()[0].length][getMatrizDouble().length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				transposedResult[j][i] = matriz[i][j];
			}
		}
		return transposedResult;
	}


}