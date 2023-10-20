import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
    private Node first;

    /**
     * Constructs an empty stack.
    */
    public LinkedListStack()
    {
        first = null;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */
    public void push(Object element){
        Node newnode = new Node();
        newnode.data = element;
        newnode.next = first;
        first = newnode;
    }





    /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public Object pop(){
        if(empty()){
            throw new NoSuchElementException();
        }
        Object obj = first.data;
        first = first.next;

        return obj;
    }







    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */
    public boolean empty(){
        /* 
        if (first == null)return true; 
        return false;
        */
        return first == null;
    }

    static class Node
    {
        public Object data;
        public Node next;
    }
}
