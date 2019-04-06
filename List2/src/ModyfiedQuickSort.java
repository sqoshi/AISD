import java.util.Arrays;

public class ModyfiedQuickSort {
/*
    private int med(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        comparisionsCounter = comparisionsCounter + 3;
        Arrays.sort(arr);
        return arr[1];
    }

    static int comparisionsCounter = 0;
    static int swapsCounter = 0;


    private int partition(int a[], int left, int right) {
        int mid = a[a.length / 2];
        int pivot = med(left, mid, right);
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

    static double startTime = System.nanoTime();

    public ModyfiedQuickSort(int a[], int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);
            if (right - left <= 16) new InsertionSort(a);
            Alghoritms.QuickSort(a, left, p - 1);
            Alghoritms.QuickSort(a, p + 1, right);
        }

    }

    static double stopTime = System.nanoTime();
    static double elapsedTime = (stopTime - startTime);*/


}
