package Sorts;

public class InsertionSort extends AbstractSort implements Alghoritms {
    @Override
    public void sort(int[] array, boolean desc) {
        int[] clonedArray = array.clone();
        print(clonedArray, "Before " + this.getClass().getSimpleName(), desc);
        for (int i = 1; i < clonedArray.length; ++i) {
            int key = clonedArray[i];
            int j = i - 1;
            while (j >= 0 && clonedArray[j] > key) {
                clonedArray[j + 1] = clonedArray[j];
                j = j - 1;
            }
            clonedArray[j + 1] = key;
        }
        print(clonedArray, "After " + this.getClass().getSimpleName(), desc);
    }
}
