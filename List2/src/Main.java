import java.io.BufferedWriter;
import java.io.FileWriter;
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
                        long startTime = System.nanoTime();
                        Alghoritms.SelectSort(arrayToSort);
                        long stopTime = System.nanoTime();
                        long elapsedTime=stopTime-startTime;
                        System.out.println("\u001b[34mComparisions:\033[0m " + Alghoritms.ScomparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + Alghoritms.SswapsCounter);

                        System.out.println("\u001b[1mSelection Sort Execution time: " + elapsedTime + "ns\033[0m");
                    }
                    if (args[j + 1].equals("quick")) {
                        System.out.println("Using QuickSort");
                        long startTime = System.nanoTime();
                         Alghoritms.QuickSort(arrayToSort, 0, arrayToSort.length - 1);
                        long stopTime = System.nanoTime();
                        long elapsedTime=stopTime-startTime;
                        System.out.println("\u001b[34mComparisions:\033[0m " + Alghoritms.QcomparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + Alghoritms.QswapsCounter);

                        System.out.println("\u001b[1mQuick Sort Execution time: " + "ns\033[0m");

                    }
                    if (args[j + 1].equals("mquick")) {
                        System.out.println("Using ModyfiedQuickSort");
                        long startTime = System.nanoTime();
                        Alghoritms.ModyfiedQuickSort(arrayToSort, 0, arrayToSort.length - 1);
                        long stopTime = System.nanoTime();
                        long elapsedTime=stopTime-startTime;
                        System.out.println("\u001b[34mComparisions:\033[0m " + Alghoritms.MQcomparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + Alghoritms.MQswapsCounter);
                        System.out.println("\u001b[1mModyfied Quick Sort Execution time: " + elapsedTime + "ns\033[0m");
                    }

                    if (args[j + 1].equals("insert")) {
                        System.out.println("Using InsertionSort");
                        long startTime = System.nanoTime();
                        Alghoritms.InsertionSort(arrayToSort);
                        long stopTime = System.nanoTime();
                        long elapsedTime=stopTime-startTime;
                        System.out.println("\u001b[34mComparisions:\033[0m " + Alghoritms.IcomparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + Alghoritms.IswapsCounter);
                        System.out.println("\u001b[1mInsertion Sort Execution time: " + elapsedTime + "ns\033[0m");

                    }
                    if (args[j + 1].equals("heap")) {
                        System.out.println("Using HeapSort");
                        long startTime = System.nanoTime();
                        Alghoritms.HeapSort(arrayToSort);
                        long stopTime = System.nanoTime();
                        long elapsedTime=stopTime-startTime;
                        System.out.println("\u001b[34mComparisions:\033[0m " + Alghoritms.HcomparisionsCounter);
                        System.out.println("\u001b[34mSwaps:\033[0m " + Alghoritms.HswapsCounter);
                        System.out.println("\u001b[1mHeap Sort Execution time: " + elapsedTime + "ns\033[0m");
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
                    try {
                        FileWriter fs = new FileWriter(args[j + 1]);
                        BufferedWriter out = new BufferedWriter(fs);
                        String formatStr = "%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n";


                        out.write(String.format(formatStr,
                                "N:", "IC", "SC", "QC", "HC", "IS", "SS", "QS", "HS", "IT", "ST", "QT", "HT"));
                        while (k > 0) {
                            int n = 100;

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

                        Alghoritms.QcomparisionsCounter=0;
                        Alghoritms.IcomparisionsCounter=0;
                        Alghoritms.ScomparisionsCounter=0;
                        Alghoritms.HcomparisionsCounter=0;
                        Alghoritms.QswapsCounter=0;
                        Alghoritms.IswapsCounter=0;
                        Alghoritms.SswapsCounter=0;
                        Alghoritms.HswapsCounter=0;

                                Long ip = System.nanoTime();
                                Alghoritms.InsertionSort(b);
                                Long ik = System.nanoTime();

                                Long sp = System.nanoTime();
                                Alghoritms.SelectSort(b);
                                Long sk = System.nanoTime();

                                Long qp = System.nanoTime();
                                Alghoritms.QuickSort(b, 0, b.length - 1);
                                Long qk = System.nanoTime();

                                Long hp = System.nanoTime();
                                Alghoritms.HeapSort(b);
                                Long hk = System.nanoTime();


                                out.write(String.format(formatStr, n,
                                        Alghoritms.IcomparisionsCounter
                                        , Alghoritms.ScomparisionsCounter
                                        , Alghoritms.QcomparisionsCounter,
                                        Alghoritms.HcomparisionsCounter,

                                        Alghoritms.IswapsCounter,
                                        Alghoritms.SswapsCounter,
                                        Alghoritms.QswapsCounter,
                                        Alghoritms.HswapsCounter,

                                        ik-ip    //exetimes
                                        , sk-sp    //exetimes
                                        , qk - qp,    //exetimes
                                        hk - hp    //exetimes
                                ));
                                n += 100;
                            }
                            k--;
                        }
                        out.close();
                        System.out.println("Data saved in: \u001b[34m" + args[j + 1] + "\033[0m");
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

