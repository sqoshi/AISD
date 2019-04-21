package priority.queue;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        System.out.println("Input Number of Operations:");
        Scanner scanner = new Scanner(System.in);
        try {
            int m = scanner.nextInt();
            if(m>0){
                System.out.println("Input operation name that u want to use: ");
                String command =  scanner.nextLine();

            }
            else
                System.out.println("Type Positiive Number");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
            ex.getMessage();
            System.out.println("Your input must be positive Integer");
        }
    }
}
