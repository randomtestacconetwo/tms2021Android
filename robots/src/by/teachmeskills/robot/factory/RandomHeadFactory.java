package by.teachmeskills.robot.factory;

import by.teachmeskills.robot.parts.RobotPart;
import by.teachmeskills.robot.heads.IHead;
import by.teachmeskills.robot.heads.SamsungHead;
import by.teachmeskills.robot.heads.SonyHead;
import by.teachmeskills.robot.heads.ToshibaHead;
import by.teachmeskills.robot.price.RobotPartPriceGenerator;

import java.util.Random;

public class RandomHeadFactory extends RobotPartFactory implements HeadFactory {
    private final Random random = new Random();

    public RandomHeadFactory(RobotPartPriceGenerator generator) {
        super(generator);
    }

    /**
     * Создает голову случайного бренда, опираясь на {@link Random}
     */
    @Override
    protected RobotPart create() {
        int randomNumber = random.nextInt(3);
        RobotPart part = null;
        switch (randomNumber) {
            case 0 -> part = new SamsungHead();
            case 1 -> part = new SonyHead();
            case 2 -> part = new ToshibaHead();
        }
        return part;
    }

    @Override
    public IHead createHead() {
        return (IHead) createPartAndAssignPrice();
    }
}
