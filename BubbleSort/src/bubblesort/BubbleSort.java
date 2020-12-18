package bubblesort;

/*
Udemy Code
Bubble Sort: the elements "bubble" to one of the ends of the array as they are sorted

* Performance degrades quickly as the partion grows
* As the algorithm progresses it creates two partions: sorted and unsorted partions
* it starts by first assigning a border to the last index of the unsorted partion and i = 0, traverse starting at the left of the array (i) [0] and compares it against [1]
* if it is greater we swap them, otherwise we leave it as it is
* then we compare [1] vs [2] and so forth
* at the end of the first traversal the greatest element is at its correct partion.
* at this point we change the border correspondingly and repeat the algorithm.

* This is a in-place algorithm we don't have to creat temp arrays
* This is quadratic time complexity O(n^2)
*/

public class BubbleSort {

    public static void main(String[] args) {
       
        int[] intArray = {20, 35, -15, 7, 55, 11, -22};
        
        //printing unsorted array
        
        System.out.println("==================================================");
        System.out.println("UNSORTED ARRAY");
        System.out.println("==================================================\n");
        printArray(intArray);
        System.out.println();
        
        //implementing ascending sorted order
        
        for (int lastUnSortedIndex = intArray.length -1; lastUnSortedIndex > 0; lastUnSortedIndex--){
            //the algorithm goes from index[6] at the first traversal; [5] the following and so forth
            for (int i= 0; i < lastUnSortedIndex; i++){
                //at this point  we want to swap the elements if the element on the left [i] is greater than then element from the right [i + 1] 
                if(intArray[i] > intArray[i + 1]){
                    swap(intArray, i, i + 1);
                }
            }
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
