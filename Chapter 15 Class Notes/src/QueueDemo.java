import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // create a print queue of strings using linked list

        Queue<String> jobs = new LinkedList<>();
        jobs.add("Joe: Quarter 2 Expense Report");
        jobs.add("Kathy: Top Secret Document");
        
        System.out.println("Printing: "+jobs.remove());

        jobs.add("Kathy: Really Top Secret Document");
        jobs.add("Joe: Grocery List");
        jobs.add("Kathy: Can I get fired for this?");

        System.out.println("Printing: "+jobs.remove());

        jobs.add("Boss: Kathy Termination letter");
        
        /* 
        for (String s : jobs){
            System.out.println("Printing: "+s);
            
        }
        */

        while (jobs.size() > 0){
            System.out.println("Printing: "+jobs.remove());
        }

        
    }
}
