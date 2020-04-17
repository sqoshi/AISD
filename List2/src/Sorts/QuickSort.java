package Sorts;

public class QuickSort extends AbstractSort implements Sortable {
    @Override
    public void sort(int[] array, boolean desc) {
        int[] clonedArray = array.clone();
        print(clonedArray, "Before " + this.getClass().getSimpleName(), desc);
        divider(clonedArray, 0, clonedArray.length - 1, desc);
        print(clonedArray, "After " + this.getClass().getSimpleName(), desc);
    }

    static void divider(int[] a, int left, int right, boolean desc) {
        if (left < right) {
            int p = partition(a, left, right, desc);

            divider(a, left, p - 1, desc);
            divider(a, p + 1, right, desc);
        }

    }

    public static int partition(int a[], int left, int right, boolean desc) {
        int pivot = a[right];
        int border = left - 1;
        for (int i = left; i < right; i++) {
            if (desc) {
                if (a[i] >= pivot) {
                    border++;
                    int swap = a[border];
                    a[border] = a[i];
                    a[i] = swap;
                }
            } else {
                if (a[i] <= pivot) {
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


}
