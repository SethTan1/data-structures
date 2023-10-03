import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3, "Water children"));
        toDo.add(new WorkOrder(2, "make dinner"));
        toDo.add(new WorkOrder(7, "eat dinner"));
        toDo.add(new WorkOrder(0, "feed turtles plastic straws"));

        System.out.println(toDo);// objects are not stored in priority order
        while (toDo.size() > 0)System.out.println(toDo.remove());
    }
}
