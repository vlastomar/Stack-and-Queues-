import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();
        Deque<String> stackFrw = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!"Home".equals(input)){
            if ("back".equals(input)){
                if (stack.size() > 1){
                    stackFrw.push(stack.pop());
                    //stack.pop();
                    System.out.println(stack.peek());
                }else{
                    System.out.println("no previous URLs");
                }
            }else if ("forward".equals(input)){
                if (stackFrw.isEmpty()){
                    System.out.println("no next URLs");
                }else{
                    System.out.println(stackFrw.peek());
                    stack.push(stackFrw.pop());
                }
            }else {
                stack.push(input);
                System.out.println(stack.peek());
            }

            input = scan.nextLine();
        }
    }
}
