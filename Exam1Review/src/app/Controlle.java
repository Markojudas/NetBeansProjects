package app;

public class Controlle {

    public static void main(String[] args) {
        
        System.out.println(convert(4));        
    }
    
    public static String convert(int n){
        if (n == 0){
            return "";                        
        }
        System.out.println("n: " + n);
        
        return convert(n/2) + "" + (n%2);
    }    
}
