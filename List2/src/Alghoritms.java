import java.util.Arrays;

class Alghoritms {
    static int QcomparisionsCounter = 0;
    static int HcomparisionsCounter = 0;
    static int ScomparisionsCounter = 0;
    static int IcomparisionsCounter = 0;
    static int MQcomparisionsCounter = 0;
    static int QswapsCounter = 0;
    static int HswapsCounter = 0;
    static int SswapsCounter = 0;
    static int IswapsCounter = 0;
    static int MQswapsCounter = 0;


    static void printDESC(int[] array) {
        System.out.println("\u001b[35m*DESC*\033[0mSorting by the smallest to the biggest key");
        for (int x :
                array) {
            System.out.print(" | \033[31m" + x + "\033[0m");
        }
        System.out.println(" | ");
    }

    static void printASC(int[] array) {
        System.out.println("\\u001b[35m*ASC*\033[0mSorting by the biggest ty the smallest key");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(" | \033[31m" + array[i] + "\033[0m");
        }
        System.out.print(" | ");

    }

    public static int partition(int a[], int left, int right) {
        int pivot = a[right];
        int border = left - 1;
        for (int i = left; i < right; i++) {
            QcomparisionsCounter++;
            if (a[i] <= pivot) {
                border++;
                int swap = a[border];
                QswapsCounter++;
                a[border] = a[i];
                a[i] = swap;
            }
        }
        int swap = a[border + 1];
        a[border + 1] = a[right];
        QswapsCounter++;
        a[right] = swap;

        return border + 1;
    }

    static void QuickSort(int a[], int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);

            QuickSort(a, left, p - 1);
            QuickSort(a, p + 1, right);
        }

    }

    static void HeapSort(int a[]) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int swap = a[0];
            HswapsCounter++;
            a[0] = a[i];
            a[i] = swap;

            heapify(a, i, 0);
        }


    }


    static void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);

        if (left < n && a[left] > a[largest]) {
            HcomparisionsCounter += 2;
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            HcomparisionsCounter += 2;
            largest = right;
        }
        if (largest != i) {
            HcomparisionsCounter++;
            HswapsCounter++;
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, n, largest);
        }
    }

    static void SelectSort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            int min = arrayToSort[i];
            int minIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (min >= arrayToSort[j]) {
                    minIndex = j;
                    min = arrayToSort[j];
                }
                ScomparisionsCounter++;
            }
            int tmp = arrayToSort[i];
            arrayToSort[i] = min;
            arrayToSort[minIndex] = tmp;
            SswapsCounter++;

        }
        SswapsCounter--;
    }

    static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                IcomparisionsCounter++;
                arr[j + 1] = arr[j];
                IswapsCounter++;
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

    static void OtherImplementationOfInsertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    private static int med(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        MQcomparisionsCounter += 2;
        Arrays.sort(arr);
        return arr[1];
    }


    private static int partition1(int a[], int left, int right) {
        int mid = a[a.length / 2];
        int pivot = med(left, mid, right);
        int border = left - 1;
        for (int i = left; i < right; i++) {
            MQcomparisionsCounter++;
            if (a[i] <= pivot) {
                border++;
                int swap = a[border];
                MQswapsCounter++;
                a[border] = a[i];
                a[i] = swap;
            }
        }
        int swap = a[border + 1];
        a[border + 1] = a[right];
        MQswapsCounter++;
        a[right] = swap;

        return border + 1;
    }


    static void ModyfiedQuickSort(int a[], int left, int right) {
        if (left < right) {
            int p = partition1(a, left, right);
            if (right - left <= 16) InsertionSort(a);
            else {
                Alghoritms.ModyfiedQuickSort(a, left, p - 1);
                Alghoritms.ModyfiedQuickSort(a, p + 1, right);
            }
        }

    }

}
