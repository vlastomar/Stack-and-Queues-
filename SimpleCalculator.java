import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();
        Deque<String> reversedStack = new ArrayDeque<>();

        //Arrays.stream(scan.nextLine().split("\\s+"))
               // .forEach(f -> stack.push(f));
        int sum = 0;
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length ; i++) {
            stack.push(input[i]);
            if (stack.size() == 3){
                int firstNumber = Integer.parseInt(stack.pop());
                //stack.pop();
                String operator = stack.pop();
                //stack.pop();
                int secondNumber = Integer.parseInt(stack.pop());
                //stack.pop();
                switch (operator){
                    case "+":
                        int temp = firstNumber + secondNumber;
                        stack.push(temp + "");
                        break;
                    case "-":
                        temp = secondNumber - firstNumber;
                        stack.push(temp + "");
                        break;
                }
            }
        }
        System.out.println(stack.peek());


    }
}
