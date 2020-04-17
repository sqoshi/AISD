package Sorts;

public class SelectSort extends AbstractSort implements Sortable {
    public static void main(String[] args) {
        SelectSort s = new SelectSort();
        s.sort(new int[]{64, 25, 12, 22, 11}, false);
    }

    @Override
    public void sort(int[] array, boolean desc) {
        int[] clonedArray = array.clone();
        print(clonedArray, "Before " + this.getClass().getSimpleName(), desc);
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (clonedArray[j] < clonedArray[minIndex])
                    minIndex = j;
            }
            int temp = clonedArray[i];
            clonedArray[i] = clonedArray[minIndex];
            clonedArray[minIndex] = temp;

        }
        print(clonedArray, "After " + this.getClass().getSimpleName(), desc);

    }

}
