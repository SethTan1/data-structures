import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
        this.first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst(){
        if (first == null){
            throw new NoSuchElementException();
        }
        return first;
    }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst(){
        if (first == null){
            throw new NoSuchElementException();
        }
        Object element = first.data;
        first = first.next;
        return element;
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element){
        if (first == null){
            throw new NoSuchElementException();
        }
        Node newnode = new Node();
        newnode.data = element;
        newnode.next = first;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }


    //Class Node
    static class Node{
        public Object data;
        public Node next;
    }

    class LinkedListIterator implements ListIterator
    {
      //private data
      private Node position;
      private Node previous;
      private boolean isAfterNext;
        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            previous = position;
            isAfterNext = true;

            if (position == null){
                position = first;
            }
            else
                position = position.next;
        
            return position.data;
            
            
        }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext(){
            // check if the list is empty
            if (position == null){
                return first != null;
            }
            if (position.next == null)return false;
            return true;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element){
            if (position == null){ // check if the iterator is at the beginning and reuse the code
                addFirst(element);
                position = first;
            }
            else{
                Node newnode = new Node();
                newnode.data = element;
                newnode.next = position.next;
                position.next = newnode; 
                position = newnode;   
            }
            isAfterNext = false;
        }





        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove(){
            if (!isAfterNext){
                throw new IllegalStateException();
            }
            
            if (position == null){
                removeFirst();
                position = null;
            }
            else{
                previous.next = position.next;
                position = previous;
            }
            isAfterNext = false;
        }






        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element){
            if (!isAfterNext){
                throw new IllegalStateException();
            }
            else{
                position.data = element;
            }
        }



    }//LinkedListIterator
}//LinkedList
