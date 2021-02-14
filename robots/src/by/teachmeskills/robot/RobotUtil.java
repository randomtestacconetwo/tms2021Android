package by.teachmeskills.robot;

public class RobotUtil {

    public static Robot findTheMostExpensive(Robot[] robots) {
        if (robots.length == 0) {
            return null;
        }
        Robot max = robots[0];
        for (Robot r : robots) {
            System.out.println("Price: " + r.getPrice());
            if (r.getPrice() > max.getPrice()) {
                max = r;
            }
        }
        return max;
    }
}
