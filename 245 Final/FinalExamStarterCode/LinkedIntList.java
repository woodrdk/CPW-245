// Simple first version of LinkedIntList with just a constructor
// and methods for add and toString.
import java.io.*;
import java.util.LinkedList;

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
        LinkedIntList c = new LinkedIntList();
        ListNode listC = c.front;


        if(listB == null){
            return null;
        }
        else{
            int carry = 0;
            while(listA != null || listB != null){
               int a;
               if(listA == null){
                  a = 0;}
               else{
                  a = listA.data;
                  listA = listA.next;
               }
               int numb;
               if(listB == null){
                  numb = 0;}
               else{
                  numb = listB.data;
                  listB = listB.next;
               }
               
               int num = a + numb + carry; //(listA.data + listB.data + carry);
               
               
               if(num > 10){
                  carry = num / 10;
                  num = num % 10;
                 
               }
               else{
                  carry = num / 10;
               }
                     
               if(listC == null){
                  c.add(num);                
               }

//               listA = listA.next;
//               listB = listB.next;
            }
        }
        return c;
    }
}
