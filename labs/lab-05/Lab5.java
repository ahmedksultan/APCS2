import java.util.Stack;
import java.util.ArrayList;

public class Lab5 {
  //WHEN WORKING WITH STACKS: left to right is bottom to top!
  public static void main(String[] args) {
    Stack<String> test = new Stack<String>();
    /* testing stack basics stuff below
    for (int i = 0; i < 10; i++) {
      test.push("" + i);
      System.out.println(test);
    }
    System.out.println(test.indexOf("4"));
    */
    
    //testing with letters
    test.push("Q");
    test.push("B");
    test.push("M");
    test.push("A");
    test.push("R");
    test.push("Z");
    System.out.println(" ");
    System.out.println(test);
    roll(test, 5, 4);
    System.out.println(test);
  }

  //PART 1 - roll(stack, n, k)
  public static void roll(Stack<String> stack, int n, int k)  {
    //handling bad cases: negatives, if n is bigger than stack size, etc.
    if (n < 0 || k < 0 || n > stack.size()) {
      throw new RuntimeException("argument out of range");
    }
    ArrayList<String> temp = new ArrayList<String>();
    int items = 0;
    //this part does k rotations.
    for (int r = 0; r < k; r++) {
      //takes n items of the stack, pops off.
      while (items != n) {
        temp.add(stack.pop());
        items++;
      }
      stack.push(temp.get(0));
      for (int i = temp.size() - 1; i >= 1; i--) {
        stack.push(temp.get(i));
      }
      temp.clear();
      items = 0;
    }
  }
}
