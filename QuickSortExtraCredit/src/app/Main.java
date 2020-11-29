package app;

public class Main {
    
    static int[] intArray = { 9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9 };
    
    public static void main(String[] args) {

        System.out.println("=========================================================================================");
        System.out.println("PRINTING ORIGINAL UNSORTED ARRAY");
        System.out.println("=========================================================================================");
        printArray();
        System.out.println();


        System.out.println("=========================================================================================");
        System.out.println("SORTING THE ARRAY USING QUICK SORT ALGORITHM");
        System.out.println("=========================================================================================");

        quickSort(intArray, 0, intArray.length);
        printArray();
        System.out.println();        
    }
    
    public static void quickSort(int[] input, int start, int end){
        //check if end - start < 2; if so we're dealing with 1 element array - already sorted
        if (end - start < 2){
            return;
        }

        //if more elements; figure out the pivot index
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex); // left sub-array
        quickSort(input, pivotIndex + 1, end); // right sub-array
    }

    public static int partition (int[] input, int start, int end){
        //this is using the first element as the pivot
        int pivot = input[start]; //depending of array and sub-arrays
        int i = start; //traversing from left to right
        int j = end; //traversing from right to left

        while(i < j) {

            //NOTE: empty loop body as an exit
            while(i < j && input[--j] >= pivot);
            if (i < j){
                //we found the element less than the pivot
                input[i] = input[j];
            }

            //look for elements greater than the pivot
            //EMPTY LOOP as an exit
            while(i < j && input[++i] <= pivot);
            //we found the element greater than the pivot
            if (i < j) {
                input[j] = input[i];
            }

        }
        //storing the pivot; the value of j
        //returning the index where we are storing the pivot
        input[j] = pivot;
        return j;
    }
        
    //simple printArray() method to print the array
    //I have added an if-else statement for display purposes    
    public static void printArray(){

        System.out.print("{ ");
        for (int i = 0; i < intArray.length; i++){
            int j = intArray[i];

            if(i != (intArray.length - 1)){
                System.out.print(j + ", ");
            }
            else{
                System.out.print(j);
            }
        }
        System.out.println(" }");

    }    
    
}
