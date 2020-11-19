package app;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        
        BinarySearch num = new BinarySearch();
        Scanner in = new Scanner(System.in);
        
        
        int arr[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 60};
        
        int n = arr.length;
        
        System.out.println("Which number would you like to look for?: ");
        int x = in.nextInt();
        
        int result = num.binarySearch(arr, x);
        
        if(result == -1){
            System.out.println("Element was not found");
        }else{
            System.out.println("Element was found at index: " + result);
        }
    }
    
}
