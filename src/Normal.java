import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Scanner;

public class Normal {

    public static void main(String[] args) {

        double sig = 12;
        double media =10;
        double []dats=new double [100];
        double ax=(6*sig)/100;

//        for (int j=0;j<100;j++){
            double rand=Math.random();
            double sum =0;

            double i=0;


            while(sum<rand) {

                sum=sum+ax*(Math.pow(2*Math.PI*sig*sig, -0.5)*Math.exp(-0.5*Math.pow((i*ax-media)/sig, 2)));
                i++;

            }
            System.out.println(i*ax);
//            datos[j]=i*ax;
//
//        }

//        System.out.println("Ulala");
//        double a=-5,b=10;
//        double[][] va=new double[100][1];
//        for (int i=0; i<100;i++){
//            double rand = (Math.random()) ;
//            va[i][0]=a+rand*(b-a);
//
//        }
//        for (int x=0;x<va.length;x++){
//            System.out.println(va[x][0]);
//        }
        System.out.println("Ulala 2.0");
        double land;
        System.out.println ("Landa please:");



        Scanner entra = new Scanner (System.in); //Creación de un objeto Scanner

        land =entra.nextDouble();

        double[][] ve=new double[100][1];
        for (int j=0; j<100;j++){
            double rand1 = (Math.random());
            ve[j][0]=-land*Math.log(1-rand);

        }
        for (int x=0;x<ve.length;x++){
            System.out.println(ve[x][0]);
        }






        JFreeChart grafic = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for(int j=0;j<ve.length;j++){
            datos.addValue(ve[j][0],"Grafica 1","a"+i);
        }
        grafic = ChartFactory.createBarChart("Grafico 1","Eje X","Eje Y",datos, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel cPanel = new ChartPanel(grafic);
        JFrame info = new JFrame("Grafic");
        info.setSize(1200,900);
        info.getContentPane().add(cPanel);
        info.setVisible(true);

    }

    public float weibull(float alfa, float beta){
        float u = (float) Math.random();
        float x = (float) Math.pow(-Math.log(u)*Math.pow(beta, alfa), 1/alfa);
        return x;
    }
//    private double mean = 0.0, sigma = 1.0;
//    XYDataset dataset = initDataset();
//    private static XYDataset initDataset(){
//        Function2D normal = new NormalDistributionFunction2D(mean, sigma);
//        XYDataset dataset = DatasetUtilities.sampleFunction2D(normal, -5.0, 5.0, 100, "Normal");
//        return dataset;
//    }

}
