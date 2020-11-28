package app;

public class Main {
    
    static int[] intArray = { 50, 80, 70, 15, 20, 10, 90, 65, 45 };

    public static void main(String[] args) {

        System.out.println("=========================================================================================");
        System.out.println("PRINTING ORIGINAL UNSORTED ARRAY");
        System.out.println("=========================================================================================");
        printArray();
        System.out.println();


        System.out.println("=========================================================================================");
        System.out.println("SORTING THE ARRAY USING MERGE SORT ALGORITHM");
        System.out.println("=========================================================================================");

        mergeSort(intArray, 0, intArray.length);
        printArray();
        System.out.println();
                
    }


    public static void mergeSort(int[] input, int start, int end){

        if (end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        merge(input, start, mid, end);

    }

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

    public static void merge(int[] input, int start, int mid, int end){

        if (input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while ( i < mid && j < end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }              
    
}
