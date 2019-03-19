public class InsertionSort {
    private int comparisionsCounter = 0;
    private int swapsCounter = 0;

    public InsertionSort(int[] a) {
        double startTime = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }


        double stopTime = System.nanoTime();
        double elapsedTime = (stopTime - startTime) / (10 ^ 9);
    }

}
