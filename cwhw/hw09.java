import java.util.*;

public class hw09 {
  public static void main (String[] args) {
    int[] t1 = {7, 3, 2, 1, 99};
    int[] t2 = {8, 5, 4, 7, 22};
    System.out.println(Arrays.toString(merge(t1, t2)));
  }
  // pre: a and b are sorted in ascending order
  // post: returns an array that contains every element of a and b
  //       in ascending order. No side effects are produced.
  //       Must be O(N) in both space and time.
  public static int[] merge(int[] a , int[] b){
          final int N1 = a.length;
          final int N2 = b.length;
          final int N = N1 + N2;
          int[] ans = new int[N];   // O(N) additional space
          int i = 0, j = 0, k = 0;
          // O(N)
          while (k < N){
                if (i >= N1 || j >= N2) break;
                // i,j and k are in-bounds
                if (a[i] < b[j]) ans[k++] = a[i++];
                else ans[k++] = b[j++];
          }
          while (i < N1) ans[k++] = a[i++];
          while (j < N2) ans[k++] = b[j++];
          return ans;
  }

  public static int log (int n) {
    if (n == 1) {
      return 0;
    }
    return 1 + log(n / 2);
  }
}
