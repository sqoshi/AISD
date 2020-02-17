package Sorts;

import java.util.Arrays;

public class SelectSort extends AbstractSort implements Alghoritms {
    @Override
    public void sort(int[] array, boolean desc) {
        int[] clonedArray = array.clone();
        print(clonedArray, "Before " + this.getClass().getSimpleName(), desc);
        for (int i = 0; i < clonedArray.length; i++) {
            int min = clonedArray[i];
            int minIndex = i;
            for (int j = i + 1; j < clonedArray.length; j++) {
                if (!desc) {
                    if (min >= clonedArray[j]) {
                        minIndex = j;
                        min = clonedArray[j];
                    }
                } else {
                    if (min <= clonedArray[j]) {
                        minIndex = j;
                        min = clonedArray[j];
                    }
                }
            }
            int tmp = clonedArray[i];
            clonedArray[i] = min;
            clonedArray[minIndex] = tmp;

        }
        print(clonedArray, "After " + this.getClass().getSimpleName(), desc);

    }

}
