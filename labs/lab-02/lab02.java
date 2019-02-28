import java.util.*;

public class lab02 {

  //main
  public static void main(String[] args) {
    sortStats();
    searchStats();
  }

  public static int[] makeData(int lo, int hi, int n){
        int [] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans [i] = (int) (Math.random() * (hi - lo) ) + lo;
        return ans;
  }

  /* ------------------- */

  //bubblesort
  public static void bubbleSort(int [] data){
     final int N = data.length;
     // N - 1 passes
     for (int pass = 1; pass < N; pass++){
         boolean exit = true;
   for (int i = 0 ; i < N - pass; i++){
       if (data[i] > data[i+1]){
          int temp = data[i];
    data[i] = data[i+1];
    data[i+1] = temp;
    exit = false;
       }
   }
   if (exit) return;
         }}

  //bubbleshort
  public static void bubbleShort(int [] data){
     final int N = data.length;
     // N - 1 passes
     for (int pass = 1; pass < N; pass++){
        for (int i = 0 ; i < N - pass; i++){
            if (data[i] > data[i+1]) {
            int temp = data[i];
            data[i] = data[i+1];
            data[i+1] = temp;
            }
        }
     }
   }

  //selectionsort
  public static void selectionSort(int [] data){
     final int N = data.length;
     // N - 1 passes
     for (int pass = 0 ; pass < N-1; pass++){
         int minPos = pass;
   // O(N) a sequential search
   for (int i = pass + 1; i < N; i++){
       if (data[i] < data[minPos])
          minPos = i;
   }
   // exactly 1 data exchange on each pass
   int temp = data[pass];
   data[pass] = data[minPos];
   data[minPos] = temp;
     }
}

  //insertionsort
  public static void insertionSort(int [] data){
     final int N = data.length;
     // N - 1 passes
     for (int pass = 1; pass < N-1; pass++){
         int i = pass;
     while (i > 0 && data[i] < data[i-1]){
       int temp = data[i];
     data[i] = data[i+1];
     data[i+1] = temp;
     i--;
      }}
  }

  /* ------------------- */

  //01 - sortStats
  public static void sortStats() {

    Stopwatch timer = new Stopwatch();
  	System.out.println("bubbleSort\n");
  	System.out.printf("   %-11s|%15s%n" , "N" , "    Time (in seconds)");
  	System.out.println("------------------------------------");
  	for (int i = 10; i < 1000000; i = i*10){
  	    int[] data = makeData(0,100,i);
  	    timer.start();
  	    bubbleSort(data);
  	    timer.stop();
  	    double time = (double) timer.elapsedTime() / 1000;
  	    System.out.printf("%10d    |%15.8f%n", i, time);
  	}
  	Stopwatch timer2 = new Stopwatch();
  	System.out.println("bubbleShort\n");
  	System.out.printf("   %-11s|%15s%n" , "N" , "    Time (in seconds)");
  	System.out.println("------------------------------------");
  	for (int i = 10; i < 1000000; i = i*10){
  	    int[] data = makeData(0,100,i);
  	    timer2.start();
  	    bubbleShort(data);
  	    timer2.stop();
  	    double time = (double) timer2.elapsedTime() / 1000;
  	    System.out.printf("%10d    |%15.8f%n", i, time);
  	}
  	Stopwatch timer3 = new Stopwatch();
  	System.out.println("selectionSort \n");
  	System.out.printf("   %-11s|%15s%n" , "N" , "    Time (in seconds)");
  	System.out.println("------------------------------------");
  	for (int i = 10; i < 1000000; i = i*10){
  	    int[] data = makeData(0,100,i);
  	    timer3.start();
  	    selectionSort(data);
  	    timer3.stop();
  	    double time = (double) timer3.elapsedTime() / 1000;
  	    System.out.printf("%10d    |%15.8f%n", i, time);
  	}
  	Stopwatch timer4 = new Stopwatch();
  	System.out.println("insertionSort \n");
  	System.out.printf("   %-11s|%15s%n" , "N" , "    Time (in seconds)");
  	System.out.println("------------------------------------");
  	for (int i = 10; i < 1000000; i = i*10){
  	    int[] data = makeData(0,100,i);
  	    timer4.start();
  	    insertionSort(data);
  	    timer4.stop();
  	    double time = (double) timer4.elapsedTime() / 1000;
  	    System.out.printf("%10d    |%15.8f%n", i, time);
  	}

  }

  //02 - searchStats
  public static void searchStats() {
    for (int i = 10; i < 10000000; i = i*10) {
      int N = i;
      int[] data = makeData(0, 100, N);

      //linear stopwatch
      Stopwatch timerL = new Stopwatch();
      //binary stopwatch
      Stopwatch timerB = new Stopwatch();

      timerL.start();
      linearSearch(data, 3);
      timerL.stop();

      //binarysearch requires a SORTED data set
      insertionSort(data);
      timerB.start();
      binarySearch(data, 3, 0, N);
      timerB.stop();

      //we used nanoTime in our Stopwatch class, as the current version gives 0.0
      //regardless, this functions the same way
      double timeL = (double) timerL.elapsedTime() / 1000000000;
      double timeB = (double) timerB.elapsedTime() / 1000000000;

      System.out.println("\nN: " + N + "\nLINEAR: " + timeL + "\nBINARY: " + timeB);
    }
  }

  //binarySearch
  public static int binarySearch(int[] data, int key, int lo, int hi) {
      if (lo >= hi) return -1;
      int m = lo + (hi - lo) / 2;
      if (data[m] == key) return m;
      if (key < data[m])  // [lo,m)
          return binarySearch(data,key,lo,m);
      //  [m+1,hi)
          return binarySearch(data,key,m+1,hi);
  }

  //linearSearch
  public static int linearSearch(int[] data, int key) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == key) {
        return i;
      }
    }
    return -1;
  }

}
