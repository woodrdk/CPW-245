// Simple first version of LinkedIntList with just a constructor
// and methods for add and toString.

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }
    
    public LinkedIntList add( LinkedIntList b ) {
        ListNode listA = front;
        ListNode listB = b.front;
        
        LinkedIntList c = b; //b;
        ListNode listC = c.front;
        // do a while loop and add b data to c that way?
 //       while(listB != null){
 //           listC.data = listB.data;
 //           listB = listB.next;
 //       }


        if(listB == null){
            return null;
        }
        else{
            int carry = 0;
            while(listA != null){ // change the listB to ListC.data 
//             need to  stop altering B
               listB.data = (listA.data + listB.data + carry);
               //listC.data = add(listA.data + listB.data + carry);
               
               if(listB.data > 10 ){
                  listB.data = listB.data % 10;
                  carry = 1; 
               }
               else{
                  carry = 0;
               }
               listA = listA.next;
               listB = listB.next;
               listC = listC.next;
            }
        }
        
        return c;
    }
    
}
