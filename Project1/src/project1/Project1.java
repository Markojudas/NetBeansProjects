//=============================================================================
// PROGRAMMER: Jose R Hernandez
// PANTHER ID: 1398700
//
// CLASS: COP337 - Computer Programming II
// SECTION: RVDC 1205
// SEMESTER: Summer 2020
// CLASSTIME: Online
//
// Project: Project 1
// DUE: 5/24/2020
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this
//                work is my own and that none of it is the work of any other person.
//=============================================================================
package project1;

//--------------------------------------------------
// Imports
//--------------------------------------------------
import java.io.*;
import java.util.*;

public class Project1 {

    public static void main(String[] args){

        // The name of the file to open.
        // notice that the StockPrice_X_Data.txt is in the data package
        String fileName = "src/data/Stock_Data.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //PUT CODE HERE
            ArrayList<Double> x_stockPrices = new ArrayList<Double>();
            ArrayList<Double> ge_stockPrices = new ArrayList<Double>();
            ArrayList<Double> appl_stockPrices = new ArrayList<Double>();
            ArrayList<Double> goog_stockPrices = new ArrayList<Double>();
            ArrayList<Double> f_stockPrices = new ArrayList<Double>();

            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                x_stockPrices.add(Double.parseDouble(data[1]));
                ge_stockPrices.add(Double.parseDouble(data[2]));
                appl_stockPrices.add(Double.parseDouble(data[3]));
                goog_stockPrices.add(Double.parseDouble(data[4]));
                f_stockPrices.add(Double.parseDouble(data[5]));
            }

            // Always close files.
            bufferedReader.close();
            
            //ArrayList that store correlation values against the other stocks
            ArrayList<Double> xCorrelations = new ArrayList<Double>();
            xCorrelations.add(findCorrelation(x_stockPrices, x_stockPrices));
            xCorrelations.add(findCorrelation(x_stockPrices, ge_stockPrices));
            xCorrelations.add(findCorrelation(x_stockPrices, appl_stockPrices));
            xCorrelations.add(findCorrelation(x_stockPrices, goog_stockPrices));
            xCorrelations.add(findCorrelation(x_stockPrices, f_stockPrices));

            ArrayList<Double> geCorrelations = new ArrayList<Double>();
            geCorrelations.add(findCorrelation(ge_stockPrices, x_stockPrices));
            geCorrelations.add(findCorrelation(ge_stockPrices, ge_stockPrices));
            geCorrelations.add(findCorrelation(ge_stockPrices, appl_stockPrices));
            geCorrelations.add(findCorrelation(ge_stockPrices, goog_stockPrices));
            geCorrelations.add(findCorrelation(ge_stockPrices, f_stockPrices));

            ArrayList<Double> applCorrelations = new ArrayList<Double>();
            applCorrelations.add(findCorrelation(appl_stockPrices, x_stockPrices));
            applCorrelations.add(findCorrelation(appl_stockPrices, ge_stockPrices));
            applCorrelations.add(findCorrelation(appl_stockPrices, appl_stockPrices));
            applCorrelations.add(findCorrelation(appl_stockPrices, goog_stockPrices));
            applCorrelations.add(findCorrelation(appl_stockPrices, f_stockPrices));

            ArrayList<Double> googCorrelations = new ArrayList<Double>();
            googCorrelations.add(findCorrelation(goog_stockPrices, x_stockPrices));
            googCorrelations.add(findCorrelation(goog_stockPrices, ge_stockPrices));
            googCorrelations.add(findCorrelation(goog_stockPrices, appl_stockPrices));
            googCorrelations.add(findCorrelation(goog_stockPrices, goog_stockPrices));
            googCorrelations.add(findCorrelation(goog_stockPrices, f_stockPrices));

            ArrayList<Double> fCorrelations = new ArrayList<Double>();
            fCorrelations.add(findCorrelation(f_stockPrices, x_stockPrices));
            fCorrelations.add(findCorrelation(f_stockPrices, ge_stockPrices));
            fCorrelations.add(findCorrelation(f_stockPrices, appl_stockPrices));
            fCorrelations.add(findCorrelation(f_stockPrices, goog_stockPrices));
            fCorrelations.add(findCorrelation(f_stockPrices, f_stockPrices));
           
            
           //2D ArrayList that stores all the stock correlations
            ArrayList<ArrayList<Double>> correlationMatrix = new ArrayList<ArrayList<Double>>();
            
            correlationMatrix.add(xCorrelations);
            correlationMatrix.add(geCorrelations);
            correlationMatrix.add(applCorrelations);                                                                                                            
            correlationMatrix.add(googCorrelations);
            correlationMatrix.add(fCorrelations);
           
            //printing out the correlation matrix
            int n = correlationMatrix.size();
           
            for (int i=0; i<n; i++){
               System.out.println(correlationMatrix.get(i));
                     }
      
            // handle errors if they arise```````````````````````````
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }//end try

    }// end main()

//------------------------------------------------------------------------------
// helper functions/
//------------------------------------------------------------------------------
    public static double findAverage(ArrayList<Double> prices) {

        double average;
        int n = prices.size();

        //PUT CODE HERE
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += prices.get(i);
        }
        average = sum / n;

        return average;
    }//end findAverage()

    //--------------------------------------------------------------------------
    public static double findStandardDeviation(ArrayList<Double> prices) {

        double stdDev;
        int n = prices.size();
        double sum = 0.0;
        double average = findAverage(prices);

        //PUT CODE HERE
        for (int i = 0; i < n; i++) {
            double value = Math.pow((prices.get(i) - average), 2);
            sum += value;
        }
        double secondValue = sum / (n - 1);
        stdDev = Math.sqrt(secondValue);
        return stdDev;
    }//end findStandardDeviation()

    //--------------------------------------------------------------------------
    public static double findCorrelation(ArrayList<Double> firstPrices, ArrayList<Double> secondPrices) {

        double xBar = findAverage(firstPrices);
        double yBar = findAverage(secondPrices);
        double stdDevX = findStandardDeviation(firstPrices);
        double stdDevY = findStandardDeviation(secondPrices);
        double sum = 0.0;
        int n = firstPrices.size();
        //PUT CODE HERE
        for (int i = 0; i < n; i++) {
            double value = (firstPrices.get(i) - xBar) * (secondPrices.get(i) - yBar);
            sum += value;
        }
        double correlation = 1.0 / (n - 1) * (sum / (stdDevX * stdDevY));
        correlation = Math.round(correlation * 100.0) / 100.0;

        return correlation;
    }//end findCorrelation()
                                        
    //--------------------------------------------------------------------------
   
}
                                      