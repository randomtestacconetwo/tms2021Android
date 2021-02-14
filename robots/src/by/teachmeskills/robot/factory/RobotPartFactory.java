package by.teachmeskills.robot.factory;

import by.teachmeskills.robot.parts.RobotPart;
import by.teachmeskills.robot.exceptions.UnknownRobotPartException;
import by.teachmeskills.robot.price.RobotPartPriceGenerator;

public abstract class RobotPartFactory {
    private final RobotPartPriceGenerator generator;

    public RobotPartFactory(RobotPartPriceGenerator generator) {
        this.generator = generator;
    }

    protected int getPrice(RobotPart part) {
        try {
            return generator.getRobotPartPrice(part);
        } catch (UnknownRobotPartException e) {
            System.out.println("Unknown part, will come for min price");
            return 1;
        }
    }

    abstract protected RobotPart create();

    /**
     * Создает запчасть при помощи {@link #create}, затем вычисляет и назначает цену запчасти
     */
    public RobotPart createPartAndAssignPrice() {
        RobotPart part = create();
        part.setPrice(getPrice(part));
        return part;
    }
}
