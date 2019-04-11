/* NodeQueue.java
    NodeQueue uses a singly linked list
    Tradeoff: unlimited capacity at the expense of more memory used to represent each element
    node class nested within the ArrayQueue class

    Node(E val, Node<E> next)
    E getValue()
    Node<E> getNext()
    void setNext(Node<E> next)

    Instance variables:
      head and tail:: node references
      size keeps track of # of elements

    Attach a "dummy node" to the front of the list to simplify the code (remove special cases)
    Always keep the head reference to the "dummy node" so head.getNext() refers to the first element of the queue or null

    head should ONLY EQUAL tail iff queue is isEmpty
*/

import java.util.NoSuchElementException;

public class NodeQueue<E> implements MyQueue<E>{

    private Node<E> HEAD;
    private Node<E> tail;
    private int size;

    public NodeQueue(){
    HEAD = new Node<E> (null, null);
    tail = HEAD;
    this.size = 0;
    }
    public int size(){
    return size;
    }

    public boolean isEmpty(){
    return size() == 0;
    }

    public boolean add(E val) throws IllegalStateException{
    Node<E> temp = new Node<E>(val, null);
    tail.setNext(temp);
    tail = temp;
    size ++;
    return true;
    }

    public boolean offer(E val){
    return add(val);
    }

    public E remove() throws NoSuchElementException{
    if(isEmpty()) throw new NoSuchElementException("Empty Q");
    E ans = HEAD.getNext().getValue();
    HEAD.setNext(HEAD.getNext().getNext());
    size --;
    if (isEmpty()) tail = HEAD;
    return ans;
    }

    public E poll(){

    if (isEmpty()) return null;
    return remove();
    }

    public E peek(){
    if(isEmpty()) return null;
    return HEAD.getNext().getValue();
    }



    private static class Node<E>{
    private final E VALUE;
    private Node<E> next;


    //constructors

    public Node(E val, Node<E> next){
        VALUE = val;
        this.next= next;
        }
    public E getValue(){
        return VALUE;
    }

    public Node<E> getNext(){
        return next;
    }
    public void setNext(Node<E> next){
        this.next = next;
    }

    }
}
