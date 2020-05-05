import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;



public class CambioClimatico {


    public static void main(String[] args) {
    Double [][]Y;
    Double [][]x;



    String fileName = "datos.xlsx";
    //CreateExcel(fileName, data);
    Y=ReadExcel(fileName,2,42,1);
    x=ReadExcel(fileName,0,42,19);
        for (int i=0;i<  x.length;i++){
            for (int j=0;j<x[0].length;j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
//    for (int i=0;i<  Y.length;i++){
//        for (int j=0;j<Y[0].length;j++){
//            System.out.print(Y[i][j]+" ");
//        }
//        System.out.println();
//    }

    //OverwriteExcel(fileName, data);
    }

    private static void CreateExcel(String fileName, String[] data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Hoja prueba");

        for (int j = 0; j < 2; j++) {// 2 por el Encabezado y la linea de informacion
            XSSFRow row = sheet.createRow(j);
            for (int i = 0; i < data.length; i++) {// Tantos loops como info en el arreglo
                XSSFCell cell = row.createCell(i);
                if (j == 0) {
                    cell.setCellValue("#" + i);
                } else {
                    cell.setCellValue(data[i]);
                }
            }
        }

        try {
            FileOutputStream fos = null;
            File file;

            file = new File(fileName);
            fos = new FileOutputStream(file);

            workbook.write(fos);
            workbook.close();
            fos.close();
            System.out.println("Finalizado");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static Double[][] ReadExcel(String fileName,int k,int m,int n){
        Double[][] Y1 = new Double[m][n];

        try {
            InputStream myFile = new FileInputStream(new File(fileName));
            XSSFWorkbook wb = new XSSFWorkbook(myFile);


            XSSFSheet sheet = wb.getSheetAt(k);

            XSSFCell cell;
            XSSFRow row;

            System.out.println("Apunto de entrar a loops");

            System.out.println("" + sheet.getLastRowNum());

            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    Y1[i][j] = cell.getNumericCellValue();

//                    System.out.println("Valor: " + cell.getNumericCellValue());
                }
            }
            System.out.println("Finalizado");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return Y1;
    }

    private static void OverwriteExcel(String fileName, String[] data) {
        try {
            InputStream inp = new FileInputStream(new File(fileName));
            XSSFWorkbook oldWorkbook = new XSSFWorkbook(inp);

            XSSFSheet oldSheet = oldWorkbook.getSheetAt(0);

            XSSFRow oldRow;

            oldRow = oldSheet.createRow(oldSheet.getLastRowNum() + 1);
            for (int i = 0; i < data.length; i++) {// Tantos loops como info en el arreglo
                XSSFCell cell = oldRow.createCell(i);
                cell.setCellValue(data[i]);
            }

            FileOutputStream fos = null;
            File file;

            file = new File(fileName);
            fos = new FileOutputStream(file);

            oldWorkbook.write(fos);
            oldWorkbook.close();
            fos.close();

            System.out.println("Finalizado");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}

