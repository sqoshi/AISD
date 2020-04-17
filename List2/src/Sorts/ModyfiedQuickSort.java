package Sorts;


import java.util.Arrays;

public class ModyfiedQuickSort extends QuickSort {

    @Override
    public void sort(int[] array, boolean desc) {
        int[] clonedArray = array.clone();
        print(clonedArray, "Before " + this.getClass().getSimpleName(), desc);
        divider(clonedArray, 0, clonedArray.length - 1, desc);
        print(clonedArray, "After " + this.getClass().getSimpleName(), desc);
    }

    private static int med(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        return arr[1];
    }


    private static int partition(boolean desc, int a[], int left, int right) {
        int mid = a[a.length / 2];
        int pivot = med(left, mid, right);
        int border = left - 1;
        for (int i = left; i < right; i++) {
            if (!desc) {
                if (a[i] <= pivot) {
                    border++;
                    int swap = a[border];
                    a[border] = a[i];
                    a[i] = swap;
                }
            } else {
                if (a[i] >= pivot) {
                    border++;
                    int swap = a[border];
                    a[border] = a[i];
                    a[i] = swap;
                }
            }
        }
        int swap = a[border + 1];
        a[border + 1] = a[right];
        a[right] = swap;

        return border + 1;
    }


    static void divider(int[] a, int left, int right, boolean desc) {

        if (left < right) {
            print(a, left + " " + right, desc);
            int p = partition(desc, a, left, right);
            if (right - left <= 16) insertionSort(a, desc);
            else {
                divider(a, left, p - 1, desc);
                divider(a, p + 1, right, desc);
            }
        }

    }

    public static void insertionSort(int[] clonedArray, boolean desc) {
        for (int i = 1; i < clonedArray.length; ++i) {
            int key = clonedArray[i];
            int j = i - 1;
            if (!desc)
                while (j >= 0 && clonedArray[j] > key) {
                    clonedArray[j + 1] = clonedArray[j];
                    j = j - 1;
                }
            else
                while (j >= 0 && clonedArray[j] < key) {
                    clonedArray[j + 1] = clonedArray[j];
                    j = j - 1;
                }
            clonedArray[j + 1] = key;
        }
    }
}
