import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Deque<Integer> quaue = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(f -> Integer.parseInt(f)).collect();
        Deque<String> stackOperaions = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> stackInput = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 1; i <= 3 ; i++) {
            if (i == 1){
                int numbersForPush = Integer.parseInt(stackOperaions.pop());
                for (int j = 0; j < numbersForPush ; j++) {
                    stack.push(stackInput.pop());
                }
            }else if (i == 2){
                int numberForPop = Integer.parseInt(stackOperaions.pop());
                for (int j = 0; j < numberForPop ; j++) {
                    stack.pop();
                }
            }else if (i == 3){
                String checkAvailability = stackOperaions.peek();
                boolean checkAvail = stack.contains(checkAvailability);
                if (checkAvail){
                    System.out.println(checkAvail);
                }else {

                    if (stack.isEmpty()){
                        System.out.println(0);
                    }else {
                        OptionalInt minNumber =  stack.stream().mapToInt(Integer::parseInt).min();
                        System.out.println(minNumber.getAsInt());
                        /*int minNumb = Integer.MAX_VALUE;
                    for (int j = 0; j < stack.size() ; j++) {
                        minNumb = Math.min(minNumb, Integer.parseInt(stack.pop()));
                    }*/
                        //System.out.println(minNumb);
                    }

                }

            }
        }

    }
}
