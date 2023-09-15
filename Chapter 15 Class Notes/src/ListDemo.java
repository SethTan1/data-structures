import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can populate a list.  */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        // The list is currently: TNPG
        /* 
         * The list iterator method creates a new list iterator
         * that is positioned at the front of the list
         * The '|' represents the iterator position
         */

         ListIterator<String> iterator = staff.listIterator(); // |TNPG
         
        /* The next method advances the iterator over the next element in the list. */
        iterator.next(); // T|NPG
        
        /* next method returns the element that the iterator is passing */
        String avenger = iterator.next(); // TN|PG
        System.out.println(avenger);
        System.out.println("Expected: Natasha");

        /* add method inserts an element at the iterator position 
         * The iterator is then positioned AFFTER the element that was added
         */
        iterator.add("Bruce"); // TNB|PG
        iterator.add("Rocket"); // TNBR|PG

        /* 
         * remove method removes the element returned by the last call
         * to next or previous
         * remove method can ONLY be called after calliing next or previous
         * it cannot be called right now because only add was called
         */
        iterator.next(); // TNBRP|G
        iterator.remove(); // TNBR|G
        System.out.println(staff);

        /* set method updates the element returned by the last call to next or previous */
        iterator.previous(); // TNB|RG
        iterator.set("Scott"); // TNB|SG
        System.out.println(staff);
        
        /* hasnext method is used to determine if there is a next node after the iterator */
        iterator = staff.listIterator(); // resets the iterator // |TMNSG
        while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")) {
                iterator.remove();              // T|BSG
            }
        }                                       // TBSG
    
        /* Enhanced for loops work with linked lists */
        for (String n : staff){
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Expected: Tony Bruce Scott Gamora");
        
        /*
         * ConcurrentModificationException
         * 
         * Cannot modify a linked list while also using an iterator
         * Unless you use the iterator to do so
         */
        /* 
        iterator = staff.listIterator();
        while (iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Scott")){
                //staff.remove("Scott");
            }
        }
        System.out.println(staff);
        */

        /*
         * ConcurrentModificationException
         */
        for (String n : staff){
            if (n.equals("Scott")){
                staff.add("Rocket");
            }
        }
    }
}
