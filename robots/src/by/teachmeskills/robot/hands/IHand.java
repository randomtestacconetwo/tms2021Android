package by.teachmeskills.robot.hands;

import by.teachmeskills.robot.parts.RobotPart;

public interface IHand extends RobotPart {
    default void upHand() {
        System.out.println("Машет рука " + getBrand());
    }
}
