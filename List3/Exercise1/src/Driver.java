import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        PrioQue que = new PrioQue();
        System.out.print("Hi! Type command and enter to continue: ");
        while (true) {
            String fun = new Scanner(System.in).nextLine();
            switch (fun.split(" ")[0]) {
                case "insert": {
                    try {
                        que.insert(Integer.parseInt(fun.split(" ")[1]), Integer.parseInt(fun.split(" ")[2]));
                        System.out.print("Great! type next command or exit to exit");
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("[WARNING]You have forgotten about value or priority press enter to type next command");
                        break;
                    }
                    break;
                }
                case "priority": {
                    try {
                        que.Priority(Integer.parseInt(fun.split(" ")[1]), Integer.parseInt(fun.split(" ")[2]));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("[WARNING]You have forgotten about value && priority");
                        break;
                    }
                    break;
                }
                case "empty": {
                    que.Empty();
                    break;
                }
                case "top": {
                    que.Top();
                    break;
                }
                case "pop": {
                    que.Pop();
                    break;
                }
                case "print": {
                    que.print();
                    break;
                }
                case "exit":{
                    System.exit(0);
                }
                default: {
                    System.out.print("Input next command or type exit to exit");
                }
            }


        }
    }

}
