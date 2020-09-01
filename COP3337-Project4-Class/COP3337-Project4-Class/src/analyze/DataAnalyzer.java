package analyze;

import app.ExecutionInfo;
import java.util.ArrayList;

public class DataAnalyzer {
    
    private ArrayList<ExecutionInfo> data; 

    public DataAnalyzer() {
        
        data = new ArrayList<>();
    }

    public ArrayList<ExecutionInfo> getData() {
        return data;
    }
    
    public void findGrowthRate(){
          System.out.println("");
          
         System.out.println("-------------------------------------------------");
         System.out.println("Data Analyzer Growth Rate");
         System.out.println("-------------------------------------------------");
         
         // your output format must match mine
         // look at the video for see the out format
         // the exponent value is e^x = total method class   
         // you need to find the x... do not over think it use the Math class 
         // YOU PUT YOUR CODE HERE
         
         //Jose: I did both enhanced and regular for loop, not sure which one you wanted..
         //I commented out the regular one (vol 1 of my assignment) 
         
         for(ExecutionInfo growthRate : data){
             int index = growthRate.getFibIndex();
             int value = growthRate.getFibValue();
             double calls = growthRate.getTotalMethodCalls();
             
             System.out.printf("%-7s %-3d %-10s %-10d %-5s %-10d %-10s %-10.3f\n", "Index:",
                     index, "FibValue:", value, "Calls:", (int)calls, "Exponent:", Math.log(calls));
            }
         
         /*                          
         for(int i = 1; i<=data.size(); i++){
             
             System.out.printf("%-7s %-3d %-10s %-10d %-5s %-10d %-10s %-10.3f\n", "Index:",
                     data.get(i-1).getFibIndex(), "FibValue:", data.get(i-1).getFibValue(),
                     "Calls:", (int)data.get(i-1).getTotalMethodCalls(),
                     "Exponent:", Math.log(data.get(i-1).getTotalMethodCalls()));
       
         }
         */

    }
    
}// end class
