public class InsertionSort {
    static int comparisionsCounter = 0;
    static int swapsCounter = 0;
  static  long startTime = System.nanoTime();
    public InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisionsCounter++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            swapsCounter++;
            arr[j + 1] = key;
        }



    }
  static  long stopTime = System.nanoTime();
  static  long elapsedTime = (stopTime - startTime);

  static void MyImplementationOfInsertionSort(int a[])
  {
      for (int i = 1; i < a.length; i++) {
          for (int j = i; j > 0; j--) {
              if (a[j - 1] > a[j]) {
                  int temp = a[j];
                  a[j] = a[j - 1];
                  a[j - 1] = temp;
              }
          }
      }
  }
}
