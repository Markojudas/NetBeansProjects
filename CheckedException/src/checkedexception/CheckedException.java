package checkedexception;

import java.io.*;

public class CheckedException {

    public static void main(String[] args) throws IOException {
        
        try{
        FileReader file = new FileReader("C:\\test\\a.txt");
        BufferedReader fileInput = new BufferedReader(file);
        
        for(int counter = 0; counter <3; counter++){
            System.out.println(fileInput.readLine());
            
            fileInput.close();            
        }
        
        }catch(FileNotFoundException e){
                e.printStackTrace();
                }
        
        
        
    }
    
}
