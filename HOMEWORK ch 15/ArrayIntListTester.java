public class ArrayIntListTester {
    public static void main(String[] args) {
        // construct and print list
        int[] data = {5, 19, 0, 2, 4, 0, 13, 85, -8, 0, 23};
        ArrayIntList list = new ArrayIntList();
        for (int n : data) {
            list.add(n);
        }
        System.out.println("list = " + list);
        
        int[] data2 = { 42, 12, 7, -4};
        ArrayIntList list2 = new ArrayIntList();
        for (int n : data2) {
            list2.add(n);
        }
        System.out.println("list2 = " + list2);
        
        list.addAll(list2);
        System.out.println("after addAll, list = " + list);
        
        // should return true
        System.out.println("containsAll: " + list.containsAll(list2) );
        
        // should return false
        ArrayIntList list4 = new ArrayIntList();
        list4.add(100);
        System.out.println("containsAll: " + list.containsAll(list4) );
        
        ArrayIntList list3 = new ArrayIntList();
        for (int n : data2) {
            list3.add(n);
        }
        // should return true
        System.out.println("list2 equals list3: " + list2.equals(list3) );
        
        // should return 9
        System.out.println("list lastIndexOf(0): " + list.lastIndexOf(0)); 
    }
}