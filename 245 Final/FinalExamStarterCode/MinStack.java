import java.util.*;

public class MinStack {
    private ArrayList<Integer> data;
    
    
    public MinStack() {
        data = new ArrayList<Integer>();
       
    }
    
    public void push( int a ) {
        
        data.add( a );
    }
    
    public int pop() {
        if ( data.size() <= 0 ) {
            throw new IllegalStateException();
        }
        
        return data.remove( data.size() - 1 );
    }
    
    public int size() {
        return data.size();
    }
    
    public int min() {
        // Change me!
        return 0;
    }
    
    public boolean isEmpty() {
        return data.size() == 0;
    }
}