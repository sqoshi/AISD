import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\u001B[33mWelcome!\033[0m");
        if (args[0].equals("--type")) {

            System.out.println("Sorting program v1.8");
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
                System.out.println("Using SelectSort");
                new SelectSort(arrayToSort);
            }
            if (args[1].equals("quick")) {
                System.out.println("Using QuickSort");
            }

            if (args[1].equals("insert")) {
                System.out.println("Using InsertionSort");
                 new  InsertionSort(arrayToSort);

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
                Alghoritms.printDESC(arrayToSort);
            }
            if (args[2].equals("--asc")) {
                Alghoritms.printASC(arrayToSort);
            }

        }

    }
}

