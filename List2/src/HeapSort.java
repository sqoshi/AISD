public class HeapSort {
    private int comparisionsCounter = 0;
    private int swapsCounter = 0;

    public HeapSort(int a[]) {
        double startTime = System.nanoTime();
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int swap = a[0];
            swapsCounter++;
            a[0] = a[i];
            a[i] = swap;

            heapify(a, i, 0);
        }
        System.out.println("\u001b[34mComparisions:\033[0m " + comparisionsCounter);
        System.out.println("\u001b[34mSwaps:\033[0m " + swapsCounter);
        double stopTime = System.nanoTime();
        double elapsedTime = (stopTime - startTime) / (10 ^ 9);
        System.out.println("\u001b[1mHeap Sort Execution time: " + elapsedTime + "s\033[0m");

    }

    void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);

        if (left < n && a[left] > a[largest]) {
            comparisionsCounter++;
            comparisionsCounter++;
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            comparisionsCounter++;
            comparisionsCounter++;
            largest = right;
        }
        if (largest != i) {
            comparisionsCounter++;
            swapsCounter++;
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, n, largest);
        }
    }
}
