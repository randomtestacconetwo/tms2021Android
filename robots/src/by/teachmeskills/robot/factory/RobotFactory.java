package by.teachmeskills.robot.factory;

import by.teachmeskills.robot.Robot;

public class RobotFactory {
    private final HeadFactory headFactory;
    private final HandFactory handFactory;
    private final LegFactory legFactory;

    public RobotFactory(HeadFactory headFactory, HandFactory handFactory, LegFactory legFactory) {
        this.headFactory = headFactory;
        this.handFactory = handFactory;
        this.legFactory = legFactory;
    }

    public Robot createRobot() {
        return new Robot(headFactory.createHead(),
                handFactory.createHand(),
                legFactory.createLeg());
    }
}
