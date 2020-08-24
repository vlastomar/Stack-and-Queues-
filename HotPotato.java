import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> queue = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int number = Integer.parseInt(scan.nextLine());

        while (!queue.isEmpty()){
            for (int i = 0; i < number - 1 ; i++) {
                queue.offer(queue.peek());
                queue.poll();
            }
            if (queue.size() > 1){
                System.out.println("Removed" + " " + queue.poll());
            }else{
                System.out.println("Last is " + queue.poll());
            }

        }
    }
}
