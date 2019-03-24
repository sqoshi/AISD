public class InsertionSort {
    private int comparisionsCounter = 0;
    private int swapsCounter = 0;

    public InsertionSort(int[] arr) {
        double startTime = System.nanoTime();
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];K
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }


        System.out.println("\u001b[34mComparisions:\033[0m " + comparisionsCounter);
        System.out.println("\u001b[34mSwaps:\033[0m " + swapsCounter);
        double stopTime = System.nanoTime();
        double elapsedTime = (stopTime - startTime)/(10^9)/(10^6);
        System.out.println("\u001b[1mInsertion Sort Execution time: " + elapsedTime+"s\033[0m");
    }

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
