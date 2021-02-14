package by.teachmeskills.robot.heads;

import by.teachmeskills.robot.parts.RobotPart;

public interface IHead extends RobotPart {
    default void speak() {
        System.out.println("Говорит голова " + getBrand());
    }
}
