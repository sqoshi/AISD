public class QuickSort {
    static int comparisionsCounter = 0;
    static int swapsCounter = 0;

    public int partition(int a[], int left, int right) {
        int pivot = a[right];
        int border = left - 1;
        for (int i = left; i < right; i++) {
            comparisionsCounter++;
            if (a[i] <= pivot) {
                border++;
                int swap = a[border];
                swapsCounter++;
                a[border] = a[i];
                a[i] = swap;
            }
        }
        int swap = a[border + 1];
        a[border + 1] = a[right];
        swapsCounter++;
        a[right] = swap;

        return border + 1;
    }

    public QuickSort(int a[], int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);

            new QuickSort(a, left, p - 1);
            new QuickSort(a, p + 1, right);
        }

    }


}
