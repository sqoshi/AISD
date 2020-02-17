import Sorts.Alghoritms;
import Sorts.InsertionSort;
import Sorts.SelectSort;

public class Driver {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        int[] array = {1, 5, 4, 32, 15, 9};
        new SelectSort().sort(array, true);
        new SelectSort().sort(array, false);
        new InsertionSort().sort(array, true);
        new InsertionSort().sort(array, false);
    }
}
