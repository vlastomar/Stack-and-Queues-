import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> left = new ArrayDeque<>();
        Deque<String> right = new ArrayDeque<>();
        String[] input = scan.nextLine().split("");
        for (int i = 0; i < input.length/2; i++) {
            left.push(input[i]);
        }
        for (int i = input.length - 1; i >= input.length/2 ; i--) {
            right.push(input[i]);
        }
        boolean check = false;
        while (!left.isEmpty()){
            String leftSymb = left.peek();
            switch (leftSymb){
                case "(":
                    if (!")".equals(right.peek())){
                        System.out.println("NO");
                        check = true;
                    }
                    break;
                case "[":
                    if (!"]".equals(right.peek())){
                        System.out.println("NO");
                        check = true;
                    }
                    break;
                case "{":
                    if (!"}".equals(right.peek())){
                        System.out.println("NO");
                        check = true;
                    }
                    break;
            }
            if (check){
                break;
            }

            left.pop();
            right.pop();
        }
        if (left.isEmpty()){
            System.out.println("YES");
        }

    }
}
