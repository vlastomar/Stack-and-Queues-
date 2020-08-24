import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        while (number != 0){
            stack.push(number % 2);
            number = number / 2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
