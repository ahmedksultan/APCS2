import java.util.Queue;

public class ArrayQueue<E> implements MyQueue<E> {
  private E[] queue;
  private int head, tail;
  private final int MAX_CAPACITY;

  public ArrayQueue(int cap) {
    queue = (E[])(new Object[cap+1]);
  }

  @Override
  public String toString() {
    String ans = "[";
    for (E x: ArrayQueue) {
      if (x == null) break;
      ans += x + ", ";
    }
    ans += "]";
    return ans;
  }
}
