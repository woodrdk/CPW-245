import java.io.File;
import java.util.Scanner;
import java.util.*;

// Robert Wood Jr
// 7/16/18
// CPW 245
// Programming Assignment #2
// Stack & Queue
//
// This assignment will reinforce your understanding of Stacks.
// It will calculate size of files in a directory.

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
       
        Stack<Integer> FileStack = new Stack<Integer>();
        long size = 0;
        File[] files = file.listFiles();
        for(int i = 0; i < files.length; i++){
           FileStack.push(files[i]); // addd dir to stack
        }
        while(!FileStack.empty()){
            File temp = FileStack.pop();// remove item from stack into temp
            if(temp.isfile()){
               size += temp.length;
            }            
            else{
               // add all the files and subdirectories under the temp into the stack
            }
        }
        return size;
        
}
    
    public static long getSizeQueue( File file ) {
        long size = 0;
        
        // TODO: implement method from Handout
        
        return size;
    }
}