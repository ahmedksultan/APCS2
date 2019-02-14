//APCS January 30 2019

import java.io.*;
import java.util.*;

public class january30  {

  public static void main (String[] args) {

    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = i;
    }
    System.out.println(Arrays.toString(test));
    System.out.println(isSorted(test));
    test[4] = 99;
    System.out.println(isSorted(test));

  }

  //EXERCISE - write method isSorted(int[] data)

  /*
  preconditions   - data != null
  postconditions  - returns true if data is increasing (not strictly) from left to right
  */

  public static boolean isSorted (int[] data) {
    for (int i = 1; i < data.length; i++) {
      if (data[i] < data[i-1]) {
        return false;
      }
    }
    return true;
  }

  //function to estimate amount of work completed by function (Worst Case Scenario)
  //F(N) = a(N+1) + b(2N + 1)
  //c(3N + 2)
}
