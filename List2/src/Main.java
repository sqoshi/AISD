import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\u001B[33mWelcome!\033[0m");
        for (int j = 0; j < args.length; j++) {
            if (args[j] == ("--stat")) {

                if (args[j].equals("--type")) {
                    System.out.println("Sorting program v1.8");
                    Scanner sc = new Scanner(System.in);
                    System.out.print("How many integers u wanna sort? :");
                    int n = sc.nextInt();

                    System.out.println("Input your keys: ");
                    int[] arrayToSort = new int[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("Key[" + i + "]: ");
                        try {
                            arrayToSort[i] = sc.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Bad argument type one more:");
                            arrayToSort[i + 1] = sc.nextInt();
                        }
                    }


                    if (args[j + 1].equals("select")) {
                        System.out.println("Using SelectSort");

                        new SelectSort(arrayToSort);
                        System.out.println("\u001b[34mComparisions:\033[0m " + SelectSort.comparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + SelectSort.swapsCounter);

                        System.out.println("\u001b[1mSelection Sort Execution time: " + SelectSort.elapsedTime + "ns\033[0m");
                    }
                    if (args[j + 1].equals("quick")) {
                        System.out.println("Using QuickSort");
                        new QuickSort(arrayToSort, 0, arrayToSort.length - 1);
                        System.out.println("\u001b[34mComparisions:\033[0m " + QuickSort.comparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + QuickSort.swapsCounter);

                        System.out.println("\u001b[1mQuick Sort Execution time: " + QuickSort.elapsedTime + "ns\033[0m");

                    }
                    if (args[j + 1].equals("mquick")) {
                        System.out.println("Using ModyfiedQuickSort");
                        new ModyfiedQuickSort(arrayToSort, 0, arrayToSort.length - 1);
                        System.out.println("\u001b[34mComparisions:\033[0m " + ModyfiedQuickSort.comparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + ModyfiedQuickSort.swapsCounter);
                        System.out.println("\u001b[1mModyfied Quick Sort Execution time: " + ModyfiedQuickSort.elapsedTime + "ns\033[0m");
                    }

                    if (args[j + 1].equals("insert")) {
                        System.out.println("Using InsertionSort");
                        new InsertionSort(arrayToSort);
                        System.out.println("\u001b[34mComparisions:\033[0m " + InsertionSort.comparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + InsertionSort.swapsCounter);
                        System.out.println("\u001b[1mInsertion Sort Execution time: " + InsertionSort.elapsedTime + "ns\033[0m");

                    }
                    if (args[j + 1].equals("heap")) {
                        System.out.println("Using HeapSort");
                        new HeapSort(arrayToSort);
                        System.out.println("\u001b[34mComparisions:\033[0m " + HeapSort.comparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + HeapSort.swapsCounter);
                        System.out.println("\u001b[1mHeap Sort Execution time: " + HeapSort.elapsedTime + "ns\033[0m");
                    }
                    if (!args[j + 1].equals("select") && !args[j + 1].equals("heap") && !args[j + 1].equals("insert")
                            && !args[j + 1].equals("quick")) {
                        System.out.print("\033[31mERROR  \033[0m");
                        System.out.println(
                                "There was not implemented Sort like: "
                                        + args[j + 1]);
                    }

                    for (int i = 0; i < args.length; i++) {
                        if (args[i].equals("--desc")) {
                            Alghoritms.printDESC(arrayToSort);
                        }
                        if (args[i].equals("--asc")) {
                            Alghoritms.printASC(arrayToSort);
                        }
                    }
                }
            }
        }
        for (int j = 0; j < args.length; j++) {
            if (args[j].equals("--stat")) {
                try {
                    int k = Integer.parseInt(args[j + 2]);
                    int n = 100;
                    try {
                        FileWriter fs = new FileWriter(args[j + 1]);
                        BufferedWriter out = new BufferedWriter(fs);
                        String formatStr = "%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n";

                        String s = "";
                        out.write(String.format(formatStr, "E", "IC", "SC", "QC", "HC", "IS", "SS", "QS", "HS", "IT"/*, "IT", "ST", "QT", "HT"*/));
                        while (k > 0) {
                            while (n < 10001) {
                                int[][] a = new int[100][n];
                                int[] b = new int[n];

                                for (int i = 0; i < 100; i++) {
                                    for (int m = 0; m < n; m++) {
                                        Random r = new Random();
                                        a[i][m] = r.nextInt();
                                        b[m] = a[i][m];
                                    }
                                }
                                new InsertionSort(b);
                                new SelectSort(b);
                                new QuickSort(b, 0, b.length - 1);
                                new HeapSort(b);
                                out.write(String.format(formatStr, n,

                                        InsertionSort.comparisionsCounter
                                        , SelectSort.comparisionsCounter
                                        , QuickSort.comparisionsCounter,
                                        HeapSort.comparisionsCounter,

                                        InsertionSort.swapsCounter,
                                        SelectSort.swapsCounter,
                                        QuickSort.swapsCounter,
                                        HeapSort.swapsCounter,
                                        Long.toString(InsertionSort.elapsedTime)

                                /*      , Long.valueOf((int) InsertionSort.elapsedTime),
                                        Long.valueOf(SelectSort.elapsedTime),
                                        Long.valueOf(QuickSort.elapsedTime),
                                        Long.valueOf(HeapSort.elapsedTime)*/

                                ));
                                n += 100;

                            }
                            k--;
                            out.close();
                        }
                    } catch (Exception e) {
                        System.err.println("Error" + e.getMessage());
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("k need to be an integer");
                }
            }
        }


    }
}

