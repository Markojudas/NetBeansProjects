package app;

public class TestMemoryCell {
    
    public static void main( String [] args){
        
        MemoryCell m = new MemoryCell();
        
        m.write( "37" );
        String val = (String) m.read();
        System.out.println( "Contents are: " + val + "\n");
        
        System.out.println("=================================================");
        System.out.println("WrapperDemo");
        System.out.println("=================================================");
        System.out.println("");
        
        MemoryCell n = new MemoryCell();
        
        n.write(new Integer(47));
        Integer wrapperVal = (Integer) m.read();
        int val1 = wrapperVal.intValue();
        System.out.println("Contents are: " + val1);
      
    }
    
}
