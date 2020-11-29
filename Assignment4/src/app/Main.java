/*
Programmer: Jose R Hernandez
Course: Data Structures COP3530 RVC 1208
Instructor: Joclyn Smith
Assignment 4: Merge Sort

This program implements the Merge Sort algorithm to sort an unsorted algorithm.
It first prints out the unsorted algorithm and then it calls the mergeSort()
method and printing the now sorted array.

the Merge Sort algorithm is divided in 2 methods:

1st: Divides the array into left and right partitions
until each one has only 1 element. A partition with 1 element is already sorted as it is the only element in the array.
This is done recursively.

2nd: It merges the sorted arrays in the proper order 
*/

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
    //1st method for the merge sort algorithm
    public static void mergeSort(int[] input, int start, int end){
        
        //if the array only has 1 element then nothing needs to be done.
        //this is also works as the base case of the recursion
        if (end - start < 2){
            return;
        }
        
        //recursively dividing the array into partitions, left and right
        //Left is from the start to the mid; the mid is one more than the index
        //Right is from the mid to the end; the end is one more than the index
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        merge(input, start, mid, end);

    }
    //Method to compare using a temp array to hold the value
    //it then copies the value into the the main array once they are in their
    //proper sorted order.
    public static void merge(int[] input, int start, int mid, int end){
        
        //if element left of the mid is less than the mid then it's already sorted
        if (input[mid - 1] <= input[mid]){
            return;
        }
        //if not using variables i and j to hold the start and the mid for comparison
        //using also a tempIndex variable to keep track of the indexes. 
        //initializing a temp Array big enough to hold the indexes we are handling
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        //this is where populate the temp array. While 
        //the Start variable is less than the Mid AND if the mid is less than the End
        //it determines if the element at index Start is less or equal to the element
        //in index Mid; if so the tempIndex in the temp array is populated with the input
        //of Start; if not with the input of Mid. i and j are incremented accordingly
        //to keep traversing.
        while ( i < mid && j < end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        
        //here we are copying/updating the array with the sorted elements
        //doing the actual merging of the broken left & right partitions.
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

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
