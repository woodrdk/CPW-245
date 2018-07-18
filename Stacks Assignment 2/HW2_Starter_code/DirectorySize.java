import java.io.File;
import java.util.Scanner;
import java.util.*;
// Robert Wood Jr
// 7/16/18
// CPW 245
// Assignment #2 Stack & Queue
// This assignment will calculate size of files in a directory.

public class DirectorySize {
    public static void main( String[] args ) {
        System.out.print( "Enter a directory or file: " );
        Scanner input = new Scanner( System.in );
        File directory = new File( input.nextLine() );
        
        System.out.println( getSizeRecursive( directory )
                          + " bytes" );
        System.out.println( getSizeStack( directory )
                          + " bytes" ); 
        System.out.println( getSizeQueue( directory )
                          + " bytes" );
    }
    
    public static long getSizeRecursive( File file ) {
        long size = 0;
        if ( file.isDirectory() ) {
            File[] files = file.listFiles();
            for ( int i = 0; files != null && i < files.length; i++ ) {
                size += getSizeRecursive( files[ i ] );
            }
        }
        else {
            size += file.length();
        }
        return size;
    }
    
    public static long getSizeStack( File file ) {
       
        Stack<File> fileStack = new Stack<File>();
        long size = 0;
        fileStack.push(file);
        while(!fileStack.isEmpty()){
            File temp = fileStack.pop();
            if(temp.isFile()){
               size += temp.length();
            }            
            else{
               File [] leftOvers = temp.listFiles();
               for(int z = 0; z < leftOvers.length; z++){
                  fileStack.push(leftOvers[z]);
               }
            }           
        }
        return size;
}
    
    public static long getSizeQueue( File file ) {
        Queue<File> FileQueue = new LinkedList<File>();
        long size = 0;
        FileQueue.add(file);
        while(!FileQueue.isEmpty()){
            File temp = FileQueue.remove();
            if(temp.isFile()){
               size += temp.length();
            }            
            else{
               File [] qLeftOvers = temp.listFiles();
               for(int z = 0; z < qLeftOvers.length; z++){
                  FileQueue.add(qLeftOvers[z]);
               }
            }           
        }
        return size;
    }
}