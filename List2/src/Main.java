import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("\u001B[33mWelcome!\033[0m");
        if (args[0].equals("--type")) {

            System.out.println("Sorting program v1.0");
            Scanner sc = new Scanner(System.in);
            System.out.print("How many integers u wanna sort? :");
            int n = sc.nextInt();

            System.out.println("Input your keys: ");
            int[] arrayToSort = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Key[" + i + "]: ");
                arrayToSort[i] = sc.nextInt();
            }


            if (args[1].equals("select")) {
                new SelectSort(arrayToSort);
                System.out.println("Using SelectSort");
            }
            if (args[1].equals("quick")) {
                System.out.println("Using QuickSort");
            }

            if (args[1].equals("insert")) {
                System.out.println("Using InsertionSort");
            }
            if (args[1].equals("heap")) {
                System.out.println("Using HeapSort");
            }
            if (!args[1].equals("select") && !args[1].equals("heap") && !args[1].equals("insert") && !args[1].equals("quick")) {
                System.out.print("\033[31mERROR  \033[0m");
                System.out.println(
                        "There was not implemented Sort like: "
                                + args[1]);
            }
            if (args[2].equals("--desc")) {
                System.out.println("Sorting by the smallest to the biggest key");
                for (int x :
                        arrayToSort) {
                    System.out.print(" | \033[31m" + x + "\033[0m");
                }
                System.out.println(" | ");
            }
            if (args[2].equals("--asc")) {
                System.out.println("Sorting by the biggest ty the smallest key");
                for (int i = arrayToSort.length - 1; i >= 0; i--) {
                    System.out.print(" | \033[31m" + arrayToSort[i] + "\033[0m");
                }
                System.out.print(" | ");
            }

        }


    }
}

