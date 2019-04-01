public class Sorts {
  public static void main(String[] args) {

  }

  //MERGE SORT
  public static void mergeSort(int[] data) {
    final int N = data.length;
    int[] aux = new int[N];
    msHelper(data, aux, 0, N);
  }
  private static void msHelper(int[] data, int[] aux, int lo, int hi) {
    if (hi - lo <= 1) return;
    int m = lo + (hi - lo) / 2;
    msHelper(data, aux, lo, m);
    msHelper(data, aux, m, hi);
    merge(data, aux, lo, m, hi);
  }
  public static void merge(int[] data, int[] aux, int lo, int m, int hi) {
    //ex. data = [2, 4, 6, 1, 3, 5] ... merge(data, aux, 0, 3, 6)
    //Step 1 -  copy elements within region [lo, hi) from data into aux
    //Step 2 -  merge the copied elements from aux back into data

    aux = data; //copying data into aux
  }

  /* ----------------------------------- */

  //QUICK SORT

  /* After each partition,
        1. The pivot, data[j], is in place
        2. Elements within [lo, j] are less than/equal to the pivot
        3. Elements within [j+1, hi] are greater than/equal to the pivot
  */

  public static void quickSort(int[] data) {
    qsHelper(data, 0, data.length);
  }

  private static void qsHelper(int[] data, int lo, int hi) {
    final int N = hi - lo;
    if (N <= 1) return;
    int p = partition(data, lo, hi); //O(N)
    qsHelper(data, lo, p);
    qsHelper(data, p+1, hi);
  }

  public static int partition(int[] data, int lo, int hi) {
    return 0;
  }
}
