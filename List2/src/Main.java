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
                double startTime = System.nanoTime();
                new QuickSort(arrayToSort,0,arrayToSort.length-1);
                System.out.println("\u001b[34mComparisions:\033[0m " + QuickSort.comparisionsCounter);
                System.out.println("\u001b[34mSwaps:\033[0m " + QuickSort.swapsCounter);
                double stopTime = System.nanoTime();
                double elapsedTime = (stopTime - startTime)/(10^9);
                System.out.println("\u001b[1mSelection Sort Execution time: " + elapsedTime+"s\033[0m");

            }
            if (args[1].equals("mquick")) {
                System.out.println("Using ModyfiedQuickSort");
            }

            if (args[1].equals("insert")) {
                System.out.println("Using InsertionSort");
                 new  InsertionSort(arrayToSort);

            }
            if (args[1].equals("heap")) {
                System.out.println("Using HeapSort");
                new HeapSort(arrayToSort);
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

