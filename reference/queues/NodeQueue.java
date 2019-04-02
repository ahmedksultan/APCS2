/* NodeQueue uses a singly linked list
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

public class NodeQueue {
  
}
