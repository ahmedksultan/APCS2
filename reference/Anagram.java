import java.util.*;
import java.util.ArrayList;

public class Anagram {

  public static void main(String[] args) {
    String test1 = "earth";
    String test2 = "heart";
    String test3 = "thursday";
    String test4 = "beans";

    System.out.println(isAnagramLOG(test1, test2)); //true
    System.out.println(isAnagramLOG(test1, test3)); //false
    System.out.println(isAnagramLOG(test1, test4)); //false
  }

  //O(N log N)
  public static boolean isAnagramLOG(String a, String b) {
    if (a.length() == b.length()) {
      int length = a.length();

      String[] seta = new String[length];
      String[] setb = new String[length];

      for (int i = 0; i < a.length(); i++) {
        seta[i] = a.substring(i, i+1);
      }
      for (int i = 0; i < a.length(); i++) {
        setb[i] = b.substring(i, i+1);
      }

      Arrays.sort(seta);
      Arrays.sort(setb);

      return Arrays.equals(seta, setb);
    }
    return false;
  }

  //O(N)
  public static boolean isAnagramN(String a, String b) {
    return false;
  }

}
