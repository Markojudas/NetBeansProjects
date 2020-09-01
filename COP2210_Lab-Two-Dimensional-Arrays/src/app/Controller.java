//=============================================================================
// PROGRAMMER: Dzmitry Yabkevich
// PANTHER ID: 6228303
//
// CLASS: COP2210
// SECTION: U06
// SEMESTER: Spring 2020
// CLASSTIME: T/TH 5:00-6:15 pm
//
// Project: Lab 6 - Arrays
// DUE: March 31, 2020 11:59 pm
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this 
// work is my own and that none of it is the work of any other person.
//=============================================================================
package app;

import java.util.Arrays;

public class Controller {

    public static void main(String[] args) {
        
        String array[][] = new String[10][15];
        
        System.out.println("");
        System.out.println("============================================" +
                           "============================================" +
                           "==================");
        System.out.println("Step 2:");
        System.out.println("============================================" +
                           "============================================" +
                           "==================");
        System.out.println("");
      
        arrayFramePatternFillWithDigits(array);
        printTwoDimensionalArray(array);
        
        System.out.println("");
        System.out.println("============================================" +
                           "============================================" +
                           "==================");
        System.out.println("Step 3:");
        System.out.println("============================================" +
                           "============================================" +
                           "==================");
        System.out.println("");
        
        arrayFramePatternAddLetters(array);
        printTwoDimensionalArray(array);
        
        System.out.println("");
    
    }
    
    public static void arrayFramePatternFillWithDigits(String[][] theArray) {
        
        int rows = theArray.length;
        int columns = theArray[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if (i == rows/2-1 ||
                    i == rows/2 ||
                    j == columns/2 ||
                    j == columns/2+1) {
                    theArray[i][j] = "1";
                }
                else {
                    theArray[i][j] = "0";
                }
            }
        }
    }
    
    public static void arrayFramePatternAddLetters(String[][] theArray) {
    
        int rows = theArray.length;
        int columns = theArray[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if (theArray[i][j].equals("0") && i<4 && j>8) {
                    theArray[i][j] = "H";
                }
                else if (theArray[i][j].equals("0") && i>5 && j<7) {
                    theArray[i][j] = "M";
                }
            }
        }
    }
        
    public static void printTwoDimensionalArray(String[][] theArray) {
        
        /*for(String[] aRow: theArray) {
            System.out.println(Arrays.toString(aRow));
        }*/
        
        int rows = theArray.length;
        int columns = theArray[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                System.out.print(theArray[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}