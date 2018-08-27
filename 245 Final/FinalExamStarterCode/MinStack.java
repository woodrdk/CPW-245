import java.util.*;

public class MinStack {
    private ArrayList<Integer> data;
    private ArrayList<Integer> min;    
    private int minVal = 10000;
    public MinStack() {
        data = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }
    
    public void push( int a ) {
        
        data.add( a );
        // added this code
        if(a < minVal){
            min.add(a);
            minVal = a;
        }
        else {
            min.add(minVal);
        }
        // -^-^-^-^-^-^-^-^-^-^-^
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
        // Changed return to proper
        return min.remove( min.size() - 1 );
    }
    
    public boolean isEmpty() {
        return data.size() == 0;
    }
}