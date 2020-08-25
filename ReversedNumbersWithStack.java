import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReversedNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(f -> stack.push(Integer.parseInt(f)));

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
