public interface MyQueue {
  int size();
  boolean isEmpty();
  boolean add(E val) throws IllegalStateException;
  boolean offer(E val);
  E peek();
  E poll();
  E remove() throws NoSuchElementException;
}
