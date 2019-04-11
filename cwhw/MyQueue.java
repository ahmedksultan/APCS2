import java.util.NoSuchElementException;

public interface MyQueue<E>{

    boolean add(E val)  throws IllegalStateException ; // when at capacity
    boolean offer(E val); // inserts E into queue if space available
    E peek();   // returns the head of the queue or null if empty
    E poll();   // removes and returns the head of the queue or null
    E remove() throws NoSuchElementException;

    // removes and returns the head of the queue
    int size() ;
    boolean isEmpty() ;

}
