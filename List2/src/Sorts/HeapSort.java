package Sorts;

public class HeapSort extends AbstractSort implements Sortable {
    public static void main(String[] args) {
        HeapSort s = new HeapSort();
        s.sort(new int[]{4, 10, 3, 5, 1}, true);
    }

    @Override
    public void sort(int[] array, boolean desc) {
        int[] a = array.clone();
        print(a, "Before " + this.getClass().getSimpleName(), desc);

        print(a, "After " + this.getClass().getSimpleName(), desc);
    }


}
