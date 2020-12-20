package app;

/*
Selection Sort:
Divides the array into sorted and unsorted partions
Traverse the array searching the largest element in the US partion
When found we swap it into the last element in the US partion
At that point it will be in the sorted position.
the sorted partion grows from right to left

lastUnsortedIndex = array.length - 1 - this is the lsat index of the unsorted partion
i = 1 - index used to the traverse the array from left to right
largest = 0 - index of the largest element in the unsorted partion
After the each traversal we decrement lastUnsortedIndex by 1 and reset i and largest variable

* in-place algorithm: does not require a temp array
*Tc = O(n^2) quadratic
*unstable algorithm
*does not reqyure as much swapping as bubbleSort

*/

public class Main {

    public static void main(String[] args) {
 
        int[] intArray = {20, 35, -15, 7, 55, 11, -22};
        
        //printing unsorted array
        
        System.out.println("==================================================");
        System.out.println("UNSORTED ARRAY");
        System.out.println("==================================================\n");
        printArray(intArray);
        System.out.println();

        for (int lastUnSortedIndex = intArray.length - 1; lastUnSortedIndex > 0; lastUnSortedIndex--){
            
            //starts at the beginning of the array and compares it with with index 1
            //if the element at index 1 is larger than the element at index 0 then we update the largest
            //with the element at index 1 and swap it with the lastUnsortedIndex 
            int largest = 0;
            
            //we gotta compare it with every position
            for(int i = 1; i <= lastUnSortedIndex; i++){
                if(intArray[i] > intArray[largest]){
                    largest = i;                    
                }
            }
            
            swap(intArray, largest, lastUnSortedIndex);
                       
        }
        
                //print sorted array
        System.out.println("==================================================");
        System.out.println("SORTED ARRAY");
        System.out.println("==================================================\n");
        printArray(intArray);
        System.out.println();
        
        
    }
    
    public static void swap(int[] array, int i, int j){
        //i = the variable used to traverse the array from left to right (the left that increments)
        //j = the variable that points to the last index of the unsorted partion (the right that decrements)
        
        //first we check if i = j; if so there's nothing to swap. 
        if(i == j){
            return;
        }
       //otherwise...
       
       //we first saved the element on [i] on a temp variable
       //then we assigned the element on j on [i]
       //then we assign temp (original element on [i]) on [j], the greatest element
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
        
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
