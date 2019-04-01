public class lab03 {
  public static void main(String[] args) {
    int[] test = {4, 3, 7, 20, 9, 5, 6, 8, 11, 2, 7, 9, 8, 5, 4};
    System.out.println(isHeapHelper(test, 0));
  }

  private static boolean isHeapHelper(int[] data, int i) {
    int left = (2 * i) + 1;
    int right = left + 1; //alternatively: (2*i) + 2
    if (left >= data.length) {
      return true;
    }
    if (data[i] < data[left]) {
      return false;
    }
    if (right < data.length && data[i] < data[right]) {
      return false;
    }
    return isHeapHelper(data, left) && isHeapHelper(data, right);
  }

  public static void heapify(int[] data, int i) {
    //updated heapify
    heapify(data, i, data.length);
  }

  //updated heapify
  public static void heapify(int[] data, int i, int upper){
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left >= upper) return;
    int maxChildPos = left;
    if (right < upper && data[right] > data[left]) maxChildPos = right;
    if (data[i] < data[maxChildPos]) {
      swap(data, i, maxChildPos);
      heapify(data, maxChildPos, upper);
    }
  }

  public static void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public static void buildHeap(int[] data) {

  }
}
