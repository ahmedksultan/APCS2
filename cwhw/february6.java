//APCS February 6 2019

import java.io.*;
import java.util.*;

public class february6 {

  public static void main(String[] args) {
    int[] test = new int[20];
    for (int i = 0; i < test.length; i++) {
      test[i] = i;
    }
    System.out.println(Arrays.toString(test));
    System.out.println(sequentialSearchR(test, 7));
    test[4] = 66;
    System.out.println(sequentialSearchR(test, 66));
    System.out.println(sequentialSearchR(test, 989));

  }

  //RECURSIVE SEQUENTIAL SEARCH
  public static int sequentialSearchR(int[] data, int x) {
    return sHelper(data,x,0);
  }

  //SEARCH HELPER FUNCTION... DONE RECURSIVELY
  private static int sHelper(int[] data, int key, int pos){
    if (pos >= data.length) {
      return (-1);
    }
    if (data[pos] == key) {
      return pos;
    }
    return sHelper(data, key, pos + 1);
  }
 }
