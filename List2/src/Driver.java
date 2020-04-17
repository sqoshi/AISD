import Sorts.*;

public class Driver {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        int[] array = {1, 5, 4, 32, 15, 9, 12, 321, 6456, 345345, 2342342, 3423423, 42344,
                333, 23234223, 6788, 99897, 5556, 99877, 434434, 56, 576, 53, 334, 675, 554, 456, 567, 678, 789, 890, 234, 11, 111, 112};
        System.out.println(array.length);
        new SelectSort().sort(array, true);
        new SelectSort().sort(array, false);
        System.out.println();
        new InsertionSort().sort(array, true);
        new InsertionSort().sort(array, false);
        System.out.println();
        new HeapSort().sort(array, true);
        new HeapSort().sort(array, false);
        System.out.println();
        new QuickSort().sort(array, true);
        new QuickSort().sort(array, false);
        System.out.println();
        new ModyfiedQuickSort().sort(array, true);
        new ModyfiedQuickSort().sort(array, false);
    }
}
