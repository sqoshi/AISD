package Sorts;

public class InsertionSort extends AbstractSort implements Sortable {
    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        s.sort(new int[]{4, 3, 2, 10, 12, 1, 5, 6}, false);
    }

    @Override
    public void sort(int[] array, boolean desc) {
        int[] a = array.clone();
        print(a, "Before " + this.getClass().getSimpleName(), desc);
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (a[j] <= a[j - 1]) {
                print(a, "Step: " + this.getClass().getSimpleName(), desc);
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                if (j > 1)
                    j -= 1;
            }
        }
        print(a, "After " + this.getClass().getSimpleName(), desc);
    }
}
