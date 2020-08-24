import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!"Home".equals(input)){
            if ("back".equals(input)){
                if (stack.size() > 1){
                    stack.pop();
                   System.out.println(stack.peek());
                    //System.out.println(stack.pop());
                }else{
                    System.out.println("no previous URLs");
                }
            }else{
                stack.push(input);
                System.out.println(stack.peek());
            }

            input = scan.nextLine();
        }
    }
}
