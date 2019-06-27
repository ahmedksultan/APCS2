/* ----- NODE DEQUE ---
  unlimited capacity
  O(1) performance for all Deque operations
  we will use a doubly linked list
  each node stores:
    value
    two links — referring to previous and next
*/

public class NodeDeque<E> {

  private final DNode<E> HEAD, TAIL;
  private int size;

  public NodeDeque() {
    HEAD = new DNode<E>(null, null, null);
    HEAD.setNext(new DNode<E>(null, HEAD, null));
    TAIL = HEAD.getNext();
    size = 0;
  }

  public void addFirst(E value) {
    DNode<E> temp = new DNode<E>(value, HEAD, HEAD.getNext());
    HEAD.getNext().setPrevious(temp);
    HEAD.setNext(temp);
    size++;
  }

  public void addLast(E value) {
    DNode<E> temp = new DNode<E>(value, TAIL.getPrevious(), TAIL);
    TAIL.getPrevious().setNext(temp);
    TAIL.setPrevious(temp);
    size++;
  }

  public E getFirst() throws EmptyDequeException {
    if (size == 0) {
      throw new EmptyDequeException("Error! Empty DEQUE!");
    }
    return HEAD.getNext().getValue();
  }

  public E getLast() throws EmptyDequeException {
    if (size == 0) {
      throw new EmptyDequeException("Error! Empty DEQUE!");
    }
    return TAIL.getPrevious().getValue();
  }

  public E removeFirst() throws EmptyDequeException {
    if (size == 0) {
      throw new EmptyDequeException("Error! Empty DEQUE!");
    }
    DNode<E> temp = HEAD.getNext();
    HEAD.setNext(temp.getNext());
    temp.getNext().setPrevious(HEAD);
    size--;

    //clearing out the removed node
    E ans = temp.getValue();
    temp = null;
    return ans;
  }

  public E removeLast() throws EmptyDequeException {
    if (size == 0) {
      throw new EmptyDequeException("Error! Empty DEQUE!");
    }
    DNode<E> temp = TAIL.getPrevious();
    TAIL.setPrevious(temp.getPrevious());
    temp.getPrevious().setNext(TAIL);
    size--;

    //clearing out removed node
    E ans = temp.getValue();
    temp = null;
    return ans;
  }

  public String toString() {
    String ans = "[";
    for(DNode<E> x = HEAD.getNext(); x.getNext() != null; x = x.getNext()) {
      ans = ans + x.getValue() + ",";
    }
    if (ans.length() > 1) {
      ans = ans.substring(0, ans.length() - 1);
    }
    return ans + "]";
  }

  public static void main (String[] args) {
    DNode<Integer> p = new DNode<Integer>(1, null, null);
    p.setNext(new DNode<Integer>(2, p, null));

    /*
    System.out.print(p.getValue());
    System.out.print(p.getNext().getValue());
    System.out.print(p.getNext().getValue());
    System.out.println(p.getValue());
    for (DNode<Integer> x = p; x != null; x = x.getNext()){
      System.out.println(x.getValue());
    }
    for (DNode<Integer> x = p.getNext(); x != null; x = x.getPrevious()) {
      System.out.println(x.getValue());
    }
    */

    NodeDeque<Integer> test = new NodeDeque<Integer>();
    System.out.println(test);
    for (int i = 0; i < 10; i++) {
      test.addFirst(i);
    }
    System.out.println(test);

    System.out.println(test.getFirst());
    test.removeFirst();
    System.out.println(test);
    System.out.println(test.getLast());
    test.removeLast();
    System.out.println(test);
  }

  //////////////////////////////////////////////////////////////////////////

  private static class DNode<E> {
    //java convention - constant values in ALL CAPS
    private final E VALUE;
    private DNode<E> previous, next;

    public DNode(E val, DNode<E> prev, DNode<E> next) {
      VALUE = val;
      previous = prev;
      this.next = next;
    }

    //ACCESSOR METHODS
    public E getValue() {
      return VALUE;
    }
    public DNode<E> getNext() {
      return next;
    }
    public DNode<E> getPrevious() {
      return previous;
    }

    //MUTATOR METHODS
    public void setNext(DNode<E> x) {
      next = x;
    }
    public void setPrevious(DNode<E> x) {
      previous = x;
    }
  }

}
