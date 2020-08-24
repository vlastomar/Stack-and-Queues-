import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!"print".equals(input)){
            if ("cancel".equals(input)){
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled" + " " + queue.poll());
                }
            }else{
                queue.offer(input);
            }
            input = scan.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
