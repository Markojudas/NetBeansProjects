/*
Insertion Sort

It divides the array into sorted and unsorted partions
The sorted partion grows from left to right.

It starts by saying that element [0] is in the sorted position and if it's of length one, it is already sorted (1 element)
The right of it is the unsorted partion. First unsorted field is [1]

Each iteration we take the first element in the unsorted partion and we inserted into the sorted partion increasing the sorted partion by 1.
at the end of iteration (first) the 2 elements are sorted.

We compare the value we're inserting with the values in the sorted partion (traversing the sorted partion from right to left)
Look for a value less/equal than we're trying to insert. If so, we found the correct place and insert.

*in-place algorithm : does not require a temp array
*stable algorithm
*Tc = quadratic O(n^2)

Note: no swap method as we're shifting

*/
package app;

public class Main {

    public static void main(String[] args) {
        
        int[] intArray = {20, 35, -15, 7, 55, 11, -22};
        
        //printing unsorted array
        
        System.out.println("==================================================");
        System.out.println("UNSORTED ARRAY");
        System.out.println("==================================================\n");
        printArray(intArray);
        System.out.println();
        
        //traversing the unsorted partition from left to right
        for (int firstUnSortedIndex = 1; firstUnSortedIndex < intArray.length; firstUnSortedIndex++){
            
            int newElement = intArray[firstUnSortedIndex];
            
            int i;
            
            //traversing the sorted partition from right to left
            for(i = firstUnSortedIndex; i > 0 && intArray[i - 1] > newElement; i--){
                intArray[i] = intArray[i - 1];   //if the element at [i - 1] is greater than [i] we shift the element to right.
            }
            
            intArray[i] = newElement;
        }
        
                //print sorted array
        System.out.println("==================================================");
        System.out.println("SORTED ARRAY");
        System.out.println("==================================================\n");
        printArray(intArray);
        System.out.println();        
       
    }
    
    
    
    public static void printArray(int[] array){
        
        for(int i = 0; i < array.length; i++){
            if(i != array.length - 1){
                System.out.print(array[i] + ", ");
            }else{
                System.out.print(array[i] + ". ");
            }
        }               
    }      
    
}
