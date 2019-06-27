public class LinkedList<E> {

    private DNode<E> header, trailer;  // dummy (sentinel) nodes
    private int size;

    // constructor: instantiates an empty LinkedList object
    public LinkedList(){
	     header = new DNode<E>(null, null, null);
	     trailer = new DNode<E>(null,header, null);
	     header.setNext(trailer);
	     size  = 0;
    }

    public int size(){
	     return size;
    }

    public boolean isEmpty(){
	     return size == 0;
    }

    // returns true if v is not the header node
    public boolean hasPrevious(DNode<E> v){
    	return (v.getPrevious() != null);
    }

    // returns true if v is not the trailer node
    public boolean hasNext(DNode<E> v){
      return (v.getNext() != null);
    }

    public DNode<E> getFirst() throws IllegalStateException {
	     if (isEmpty()) {
         throw new IllegalStateException("empty list");
  	     return null;
       }
       return header.getNext();
    }

    public DNode<E> getLast() throws IllegalStateException{
      if (isEmpty()) {
        throw new IllegalStateException("empty list");
        return null;
      }
      return trailer.getPrevious();
    }

    // returns the node that comes directly before the current node.
    public DNode<E> getPrevious(DNode <E> current) throws IllegalArgumentException {
	     if (current.getPrevious().getValue() == null) {
         throw new IllegalArgumentException("no element previous");
         return null;
       }
       return current.getPrevious();
    }

    // returns the node that comes directly after the current node.
    public DNode<E> getNext(DNode<E> current) throws IllegalArgumentException {
      if (current.getNext().getValue() == null) {
        throw new IllegalArgumentException("no element next");
        return null;
      }
      return current.getNext();
    }

    // inserts node a before node b.
    // An exception is thrown if b is the header
    public void addBefore(DNode<E> b, DNode<E> a){
      if (b.getPrevious() == null) {
        return;
      }
      p = b.getPrevious();
      p.setNext(a);
      a.setPrevious(p);
      a.setNext(b);
      b.setPrevious(a);
    }

    // inserts node a after node b
    // throw exception if b is the trailer node
    public void addAfter(DNode<E> a, DNode<E> b){
      b.setNext(a.getNext());
      a.getNext().setPrevious(b);
      a.setNext(b);
      b.setPrevious(a);
      size++;
    }

    // *************************** Exercise *******************************
    public void addFirst(DNode<E> current){
	return;
    }
    // *************************** Exercise *******************************
    public void addFirst(E value){
	     addFirst(new DNode<E>(value, null, null));
    }

    public void addLast(DNode<E> node){
      p = trailer.getPrevious();
      p.setNext(node);
      node.setPrevious(p);
      trailer.setPrevious(node);
      node.setNext(trailer);
      size++;
    }

    // *************************** Exercise *******************************
    //*******************************************************************
    //precondition: v != null and is a node in the list
    //postconditon: removes the node v refers to.
    //              Throws exception if v is header or trailer.
    public void remove(DNode<E> v){
	     v.getPrevious().setNext(v.getNext());
       v.getNext().setPrevious(v.getPrevious());
       v.setNext(null);
       v.setPrevious(null);
       size--;
    }

    public String toString(){
    	String ans = "";
    	DNode current = header.getNext();
    	while (current != trailer){
    	    ans += current.getValue() + ", ";
    	    current = current.getNext();
    	}
    	int len = ans.length();
    	if (len > 0) ans = ans.substring(0,len - 2);
    	ans = "[" + ans + " ]";
    	return ans;
    }



    public static void main(String [] args){
	LinkedList<Integer> L = new LinkedList<Integer>();

        System.out.println("L : " + L);
        for (int i = 0; i < 10; i++){
            L.addFirst(i);
            System.out.println("add " + i + " : " + L);
        }
    }

}
