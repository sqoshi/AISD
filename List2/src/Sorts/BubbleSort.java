package Sorts;

public class BubbleSort extends AbstractSort implements Sortable {
    public static void main(String[] args) {
        Sorts.SelectSort s = new Sorts.SelectSort();
        s.sort(new int[]{5, 1, 4, 2, 8, 4}, false);
    }

    @Override
    public void sort(int[] array, boolean desc) {
        int[] clonedArray = array.clone();
        print(clonedArray, "Before " + this.getClass().getSimpleName(), desc);
        for (int i = 0; i < clonedArray.length - 1; i++) {
            for (int j = i; j < clonedArray.length - 1; j++) {
                if (clonedArray[j] >= clonedArray[j + 1]) {
                    int temp = clonedArray[j];
                    clonedArray[j] = clonedArray[j + 1];
                    clonedArray[j + 1] = temp;
                }
            }
        }
        print(clonedArray, "After " + this.getClass().getSimpleName(), desc);

    }
}
