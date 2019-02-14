// Sequential (Linear) Search
// useful for unsorted lists
// brute force search

public class Searches{
    // returns a array with the sequence [0, n).
    public static int[] makeData(int n){
	     int[] ans = new int[n];
	      for (int i = 0; i < n; i++){
	         ans[i] = i;
	        }
	     return ans;
    }

    public static void shuffle(int [] data){
	    for (int i = 0; i < data.length; i++){
	    int r = (int) (Math.random() * (data.length  - i));
	    int temp = data[r];
	    data[r] = data[i];
	    data[i] = temp;
	}
    }

    public static void print(int[] data){
	for (int x : data)
	    System.out.print(x + " ");
	System.out.println();

    }
    // O(n)
    public static int sequentialSearch(int [] data, int key){
	for (int i = 0; i < data.length; i++){
	    if (data[i] == key) return i;
	}
	return -1;
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

    //BINARY Search
    public static int binarySearch(int[] data, int key, int lo, int hi) {
      if (lo >= hi) return -1;
      int m = lo + (hi - lo) / 2;
        // why not int m = (hi+lo) /2 ? INTEGER OVERFLOW
      if (data[m] == key) return m;
      //[lo, m)
      if (key < data[m]) return binarySearch(data, key, lo, m);
      //[m+1, hi)
      return binarySearch(data, key, m+1,hi);
    }

    public static int binarySearchModified(int[] data, int key, int lo, int hi) {
      if (lo >= hi) return -1;
      int m = lo + (hi - lo) / 2;
      if (data[m] == key) {
        int m2 = binarySearch(data, key, lo, m);
        if (Math.min(m, m2) == -1) {
          return m;
        }
        return m2;
      }
      if (key < data[m]) return binarySearchModified(data, key, lo, m);
      return binarySearchModified(data, key, m+1, hi);
    }


    public static void main(String [] args){
	       final int N = 10;
	       int [] data = makeData(N);
	       print(data);
         shuffle(data);
	       print(data);
	       for (int x : data){
	          System.out.println("found " + x + " at index " + sequentialSearch(data,x));
	       }
    }
}
