public class CPW245_FinalExam {
    public static void main( String[] args ) {
        LinkedIntList a = new LinkedIntList();
        LinkedIntList b = new LinkedIntList();
        
        int first =       1234567;
        int second =    123456789;
        // expected sum 124691356
        
        while ( first > 0 ) {
            a.add( first % 10 );
            first /= 10;
        }
        
        while ( second > 0 ) {
            b.add( second % 10 );
            second /= 10;
        }
        
        LinkedIntList c = a.add(b);
        
        System.out.println( a );
        System.out.println( b );
        System.out.println( c );
        
        
        // MinStack stack = new MinStack();
        // stack.push( 7 );
        // stack.push( 5 );
        // stack.push( 8 );
        // stack.push( 3 );
        // stack.push( 6 );
        // stack.push( 2 );
        
        // System.out.println();
        // System.out.println( "MinStack Test:" );
        // while( !stack.isEmpty() ) {
        //    int min = stack.min();
        //    int data = stack.pop();
            
       //     System.out.println( "value = " + data 
       //                       + ", min = " + min );
       // }
        
        
       // EXTRA CREDIT 
       // Algoritm to make a binary tree from a sorted array
       
       // start by splitting the array in half and finding the middle value 
       // make the middle value the root
       // take the first half of the array and recursively call it and add it to root.left
       // take the second half of the array and recursively call it and add it to root.right
       // return root
    }
}