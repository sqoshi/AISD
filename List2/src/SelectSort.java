public class SelectSort {
    static int comparisionsCounter = 0;
    static int swapsCounter = 0;


    static long startTime = System.nanoTime();

    SelectSort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            int min = arrayToSort[i];
            int minIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (min >= arrayToSort[j]) {
                    minIndex = j;
                    min = arrayToSort[j];
                }
                comparisionsCounter++;
            }
            int tmp = arrayToSort[i];
            arrayToSort[i] = min;
            arrayToSort[minIndex] = tmp;
            swapsCounter++;

        }
    comparisionsCounter--;
    }
    static long stopTime = System.nanoTime();
    static long elapsedTime = (stopTime - startTime);
}
