import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            int choise = Integer.parseInt(input[0]);
            switch (choise){
                case 1:
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case 2:
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case  3:
                    if (!stack.isEmpty()){
                        int maxNumb = stack.stream().max(Integer::compareTo).get();
                        System.out.println(maxNumb);

                    }else   {
                        System.out.println(0);
                    }
                    break;
            }

        }
    }
}
