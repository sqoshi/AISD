package Sorts;

public abstract class AbstractSort {
    static void printDESC(int[] array) {
        System.out.println("\u001b[35m*DESC*\033[0mSorting by the smallest to the biggest key");
        for (int x :
                array) {
            System.out.print(" | \033[31m" + x + "\033[0m");
        }
        System.out.println(" | ");
    }

    static void printASC(int[] array) {
        System.out.println("\\u001b[35m*ASC*\033[0mSorting by the biggest to the smallest key");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(" | \033[31m" + array[i] + "\033[0m");
        }
        System.out.print(" | ");
    }

    static void print(int[] array, String str, boolean desc) {
        if (desc)
            System.out.println("\u001b[35m[" + str + "]\033[0m Desc");
        else System.out.println("\u001b[35m[" + str + "]\033[0m Asc");
        System.out.print("\t");
        for (int x :
                array) {
            System.out.print(" | \033[31m" + x + "\033[0m");
        }
        System.out.println(" | ");
    }
}
