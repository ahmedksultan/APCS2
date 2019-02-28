//SortStats.java
//Zeynep Bromberg, partner Ahmed Sultan
//keeps track of elapsed time as BubbleSort, BubbleShort, SelectionSort and InsertionSort are run
//use Stopwatch class to measure elapsed time


public class SortStats{
    public static int[] makeData(int lo, int hi, int n){
        int [] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans [i] = (int) (Math.random() * (hi - lo) ) + lo;
        return ans;
    }

    //BubbleSort
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

    //BubbleShort
    public static void bubbleShort(int [] data){
       final int N = data.length;
       // N - 1 passes
       for (int pass = 1; pass < N; pass++){
	   for (int i = 0 ; i < N - pass; i++){
	       if (data[i] > data[i+1]){
	       	  int temp = data[i];
		  data[i] = data[i+1];
		  data[i+1] = temp;
		 
	       }
	   }
       	   
       }
}

    //Selection Sort

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

    //Insertion Sort
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
	   }

       }



}




    public static void main (String [] args){
	Stopwatch timer = new Stopwatch();
	System.out.println("Bubble Sort");
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
	System.out.println("Bubble Short");
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
	System.out.println("Selection Short");
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
	System.out.println("Insertion Short");
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


}



