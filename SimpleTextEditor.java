import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Deque<String> editor = new ArrayDeque<>();
        Deque<String> garbage = new ArrayDeque<>();
        int number = Integer.parseInt(scan.nextLine());
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            int choise = Integer.parseInt(input[0]);
            switch (choise){
                case 1:
                    String stringInput = input[1];
                    word.append(stringInput);
                    int index1 = word.indexOf(stringInput);
                    int index2 = index1 + word.length() - 1;
                    garbage.push("add" + " " + index1 + " " + index2);
                    break;
                case 2:
                    int count = Integer.parseInt(input[1]);
                    index1 = word.length() - count;
                    index2 = word.length();
                    if (index1 >= 0){
                        String cuttedWord = word.substring(index1,index2 );
                        word.delete(index1, index2);
                        garbage.push("remove" + " " + cuttedWord);
                    }

                    break;
                case 3:
                    int returns = Integer.parseInt(input[1]) -1;
                    if (returns >= 0 && returns < word.length()){
                        System.out.println(word.charAt(returns));
                    }

                    break;
                case 4:
                    if (!garbage.isEmpty()){
                        String[] undo = garbage.pop().split(" ");
                        String command = undo[0];
                        switch (command){
                            case "add":
                                index1 = Integer.parseInt(undo[1]);
                                index2 = Integer.parseInt(undo[2]) + 1;
                                word.delete(index1, index2);
                                break;
                            case "remove":
                                String add = undo[1];
                                word.append(add);
                                break;
                        }
                    }

                    break;
            }

        }
    }
}
