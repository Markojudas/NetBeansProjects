package app;

import java.awt.Rectangle;
import java.awt.Shape;

public class FindMaxDemo {
    
    /**
     * Return max item in arr/
     * Precondition: arr.length > 0
     * @param <AnyType>
     * @param arr
     * @return 
     */
    
    public static <AnyType extends Comparable<? super AnyType>>
         AnyType findMax( AnyType [] arr)
    {
        int maxIndex = 0;
        
        for( int i = 1; i < arr.length; i++)
            if( arr[ i ].compareTo( arr[ maxIndex ]) > 0)
                maxIndex = i;
        
        return arr[ maxIndex ];
    }

    /**
     * Test findMax on Shape and String objects.
     * @param args 
     */
    
    public static void main(String[] args) 
    {
        Shape [ ] sh1 = { new Circle(2.0),
                          new Square(3.0),
                          new Rectangle(3.0, 4.0)};
        
        String [ ] st1 = {"Joe", "Bob", "Bill", "Zeke" };
        
        System.out.println( findMax( sh1 ) );
        System.out.println( findMax( st1 ) );
     
    }

    private static boolean findMax(Shape[] sh1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
