public class Alghoritms {

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

}
