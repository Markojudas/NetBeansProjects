/*
Programmer: Jose R Hernandez
Course: Data Structures - COP3530 RVC 1208
Instructor: Joslyn Smith
Semester: Fall 2020

Assignment: Extra Credit - Quick Sort

This program implements a quick sort algorithm. This is a divide and conquer algorithm.
It uses a pivot element to partion the array into two parts. The elements less
than the pivot to the left and the greater elements to the right; the pivot will be placed at the correct index.
Eventually all the elements will be the pivot so evey element will be in its correct sorted position.

This algorithm happens in-place; using the same array without having to create temporary arrays like merge sort.
Since the algorithm repeatedly partions the array into two halves the average time complexity is 0(nlogn), average. The worst case would be 0(n^2)
depending on input data being sorted and the choice of pivot. This program, though it choses the first index of the array and the subarrays (left/right of the pivot)
it still is 0(nlogn) as it places the pivot in its correct index partitioning or dividing the array into 2 each time until all elements are sorted. 
*/

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

        //if more elements; figure out the pivot correct and sorted index
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex); // left sub-array
        quickSort(input, pivotIndex + 1, end); // right sub-array
    }
    //this method does the partitioning and sorting
    //the pivot is the first element on the array/sub-array
    //it checks (j, right to left) until it finds an element less than the pivot and sets the pivot to that index.
    //it also checks (i, left to right) until it finds an element that is greater than the pivot
    //the pivot will be in its right index and then it will check the left and right partitions
    //repeating the process.
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
