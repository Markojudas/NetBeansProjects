/*
Progammer: Jose R Hernandez
Panther ID: 1398700

Class: COP3337 - Computer Programming II
Section: U01
Semester: Summer 2020
Classtime: Online

Project: Project 3
due: July 12, 2020

CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my 
               own and that none of it is the work of any other person.
*/
package app;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
   
    public static void main(String[] args) {
        
            
        int [] answer4 = {1, 1, 2, 15, 131, 1160, 10279, 91089, 807202, 7153171, 
           63389159, 561734856, 682950907, 1163077693, 71344026, -1886883273,
           2095387611, -872152760, -1876028609, 1271956537}; 
       
        int [] answer1 = {1, 1, 2, -3, -29, -108, -243, -179, 1282, 7417, 22871,
           40572, -12023, -405879, -1754238, -4521563, -5531429, 13774852,
           110895797, 388591221};
       
        int [] answer2 = {1, 1, 2, 1, 12, -44, 297, -1689, 10007, -58684,
            345017, -2027154, 11912452, -70000099, 411339437, 1877831777, 1318811834,
            -1860305915, 833755688, -146620168};
       
        int [] answer3 = {1, 1, 2, 5, 8, 4, -11, -17, 35, 152, 161, -254, -968,
           -575, 2813, 7049, 1394, -24047, -45260, 15472};
       
        int [] answer5 = {1, 1, 2, 8, 1, 52, -43, 353, -557, 2578, -5470, 19931,
           -49166, 159697, -425707, 1305737, -3622130, 10792996, -30556483,
           89723036};
       
       boolean correctSelection =false;
       int [] selectedArray = new int[20];
             
       int sequenceSelection;
       
       Scanner in = new Scanner(System.in);
       
       do{
            System.out.println("Please choose a group number between 1 through 5:");
            sequenceSelection = in.nextInt();

            switch (sequenceSelection) {
                case 1:
                    selectedArray = answer1;
                    correctSelection = true;
                    break;
                case 2:
                    selectedArray = answer2;
                    correctSelection = true;
                    break;
                case 3:
                    selectedArray = answer3;
                    correctSelection = true;
                    break;
                case 4:
                    selectedArray = answer4;
                    correctSelection = true;
                     break;
                case 5:
                    selectedArray = answer5;
                    correctSelection = true;
                    break;
                default:
                    System.out.println("WRONG SELECTION\n");
                    correctSelection = false;
                    break;
            }
        }while(!correctSelection);     
        
       generateSequence(sequenceSelection, selectedArray);
    }
    
    public static void generateSequence(int groupSelection, int array[]){
        
               
       int X = 0;
       int Y = 0;
       int Z = 0;
       
       System.out.println();
       System.out.println("==================================================");
       System.out.println("============== GROUP " + groupSelection + " SEQUENCE ==================");
       System.out.println("==================================================");
       System.out.println("");
       
       int [] result = new int[20];
       
       for(int x = -10; x<=10; x++){
           for(int y = -10; y<=10; y++){
               for(int z = -10; z<=10; z++){
                   for(int n = 1; n<=20; n++){
                       result[n-1] = fib(n,x,y,z);
                   }
                   if(Arrays.equals(result, array)){
                       X = x;
                       Y = y;
                       Z = z;
                       for(int i = 0; i < result.length; i++){
                           if(i !=19){
                               System.out.print(result[i] + ", ");
                           }else{
                               System.out.println(result[i]);
                           }
                       }               
                   } 
               }
           }
       }             
      
       System.out.println("\n");
       System.out.println("==================================================");
       System.out.println("============= MULTIPLIERS X, Y, & Z ==============");
       System.out.println("==================================================");
       System.out.println("");
       
       System.out.printf("%s %2d\n", "X:", X);
       System.out.printf("%s %2d\n" ,"Y:", Y);
       System.out.printf("%s %2d\n" , "Z:", Z);
       
    }

    public static int fib(int n, int x, int y, int z){
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 2;
        return x*fib(n-1, x, y, z) + y*fib(n-2, x, y, z) + z*fib(n-3, x, y, z);
    }   
}