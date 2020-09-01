
package app;

public class SelectionProblem {

    public static void main(String[] args) {
        
        //Define the array, N, kthElement, k, startTime,
        //endTime, and runTime varibables
        
        //the array
        int array[];
        
        //variable to hold the size of the array
        int MAX = 10001, KthElement;
        
        //to hold the start, end and run time
        //of the algorithm for different array size
        long startTime, endTime, runTime;
        
        //Display the informatuon what is being
        //performed
        System.out.println("For different N values " + 
                "find the K'th element in the array.");
        System.out.println("Here k = N/2");
        
        //Table Creation 
        System.out.println("-------------------------------------------------");
        System.out.printf("%s %25s %15s \n", "N Value", "Run Times(milliSeconds)",
                           "k'th Element");
        System.out.println("-------------------------------------------------");
        
        //initializing the array; using a loop
        for (int N= 500; N < MAX; N = N + 500)
        {
            //initializing the array
            array = new int[N];
            //populating the array with random numbers
            for (int j = 0; j < N; j++)
            {
                array[j] = (int) (Math.random() * N + 1);                
            }
            
            //Start the clock
            startTime = System.currentTimeMillis();
            
            //sort the elements by calling the bullbleSort method
            
            KthElement = bubbleSort(array);
            
            endTime = System.currentTimeMillis();
            
            runTime = (endTime - startTime);
            
            System.out.printf("%5d %15d %22d \n", N, runTime, KthElement);
        }
        
        System.out.println("---------------------------------------------");      
    }
    
    //bubbleSort() to sort the array in decreasing order
    //and returns the k'th position value
    public static int bubbleSort (int[] array)
    {
        //traverse the array
        for (int i = 0; i < array.length; i++)
        {
            //loop through each element in the array
            for (int j = 0; j < (array.length - 1); ++j)
            {
                //if the element at index j is
                //lesser than index at j+1 then
                //swap the element
                if(array[j] < array[j + 1])
                {
                    swap(array, j, j+1);
                }
            }     
        }
        
        int k = array.length / 2;
        
        int kthPosition = array[k];
        
        return kthPosition;
             
    }
    
    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
