import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] robots = scan.nextLine().split("\\;");
        String[] timeHhMmSs = scan.nextLine().split("\\:");

        long sec = Integer.parseInt(timeHhMmSs[2]) + Integer.parseInt(timeHhMmSs[1]) * 60
                + Integer.parseInt(timeHhMmSs[0]) * 60 * 60;

        sec++;

        Deque<String> queueProducts = new ArrayDeque<>();
        //Deque<Integer> processTimesRobots = new ArrayDeque<>();
        int[] processTimeRobotts = new int[robots.length];

        for (int i = 0; i < robots.length; i++) {
            String[] input = robots[i].split("-");
            processTimeRobotts[i] = Integer.parseInt(input[1]);
            robots[i] =input[0] + " " + sec;
        }

        String input = scan.nextLine();
        while (!"End".equals(input)){
            queueProducts.offer(input);
            input = scan.nextLine();
        }


        boolean productPassed = true;

        while (!queueProducts.isEmpty()){

            for (int i = 0; i < robots.length ; i++) {
                String[] currentRobot = robots[i].split(" ");
                String nameRobot = currentRobot[0];
                long  availRobot  = (long) Integer.parseInt(currentRobot[1]);
                if (availRobot <= sec){
                   long secCorrected = sec % 60;
                   long min = sec / 60;
                   long minCorr = min % 60;
                   long hour = min / 60;
                   hour = hour % 24;
                    System.out.println(String.format("%s - %s [%02d:%02d:%02d]",nameRobot, queueProducts.poll(), hour, minCorr, secCorrected ));
                    availRobot = sec + (long) processTimeRobotts[i];
                    robots[i] = nameRobot + " " + availRobot;

                    productPassed = false;

                    break;
                }
            }
            if (productPassed){
                queueProducts.offer(queueProducts.poll());
            }
            productPassed = true;


            sec++;

        }
    }
}
