//APCS January 29 2019

import java.io.*;
import java.util.*;

public class january29 {

  public static void main(String[] args) {

  }

  //Jan29 - EXERCISE  - implement a SEQUENTIAL SEARCH on a list of unordered integers
  public static boolean contains (int[] data, int x, int from, int to) {

    /*
    preconditions   - data is a sequence of integers (unordered)
                    - from >=, from <= to, to <= data.length
    postconditions  - returns true if x is found within the region [from, to) of data
    */

    //PART A - implement contains

    for (int i = from; i < to; i++) {
      if (data[i] == x) {
        return true;
      }
    }
    return false;

    //PART B - if data.length = N, what is the least number of comparisons that may occur?
    //ANS B - 1, occurs when to == from
    //i.e. contains([1,2,3], 2, 1, 1)

    //PART C -  if data.length = N, what is the highest number of comparisons that may occur?
    //ANS C - (N+1 + N), or 2N+1, from == 0 && to != from
  }

  /* --------------------------- */

  //Jan30 - EXERCISE - write method isSorted(int[] data)

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
