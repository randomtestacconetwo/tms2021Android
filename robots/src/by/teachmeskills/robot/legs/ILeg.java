package by.teachmeskills.robot.legs;

import by.teachmeskills.robot.parts.RobotPart;

public interface ILeg extends RobotPart {
    default void step() {
        System.out.println("Шагает нога " + getBrand());
    }
}
