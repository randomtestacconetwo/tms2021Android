package by.teachmeskills.robot.factory;

import by.teachmeskills.robot.parts.RobotPart;
import by.teachmeskills.robot.legs.ILeg;
import by.teachmeskills.robot.legs.SamsungLeg;
import by.teachmeskills.robot.legs.SonyLeg;
import by.teachmeskills.robot.legs.ToshibaLeg;
import by.teachmeskills.robot.price.RobotPartPriceGenerator;

import java.util.Random;

public class RandomLegFactory extends RobotPartFactory implements LegFactory {
    private final Random random = new Random();

    public RandomLegFactory(RobotPartPriceGenerator generator) {
        super(generator);
    }

    /**
     * Создает нооу случайного бренда, опираясь на {@link Random}
     */
    @Override
    protected RobotPart create() {
        int randomNumber = random.nextInt(3);
        RobotPart part = null;
        switch (randomNumber) {
            case 0 -> part = new SamsungLeg();
            case 1 -> part = new SonyLeg();
            case 2 -> part = new ToshibaLeg();
        }
        return part;
    }

    @Override
    public ILeg createLeg() {
        return (ILeg) createPartAndAssignPrice();
    }
}
