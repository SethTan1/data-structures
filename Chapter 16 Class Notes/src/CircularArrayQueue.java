import java.util.NoSuchElementException;

/**
    An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
    private Object[] elements;
    //private data
    private int head, tail, currentSize;


    /**
        Constructs an empty queue.
    */
    public CircularArrayQueue(){
        final int INITIAL_SIZE = 5;
        elements = new Object[INITIAL_SIZE];
        int head, tail, currentSize = 0;
    }





    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty(){
        return currentSize == 0;
    }



    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object obj){
        currentSize ++;
        elements[tail] = obj;
        tail++;
        tail %= elements.length;

    }




    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove(){
        if (empty()){
            throw new NoSuchElementException();
        }
        Object obj = elements[head];
        head ++;
        head %= elements.length;
        currentSize--;
        
        return obj;
    }




    /**
        Grows the element array if the current size equals the capacity.
    */
    private void growIfNecessary()
    {
        
        if(this.currentSize == this.elements.length)
        {
            Object[] newElements = new Object[2 * this.elements.length];
            for(int i = 0; i < this.elements.length; i++)
            {
                newElements[i] = this.elements[(head + i) % this.elements.length];
            }
            this.elements = newElements;
            this.head = 0;
            this.tail = this.currentSize;
        }
        
    }




}//CircularArrayQueue
