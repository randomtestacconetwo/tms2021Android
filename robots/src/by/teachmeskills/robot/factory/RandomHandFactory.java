package by.teachmeskills.robot.factory;

import by.teachmeskills.robot.parts.RobotPart;
import by.teachmeskills.robot.hands.IHand;
import by.teachmeskills.robot.hands.SamsungHand;
import by.teachmeskills.robot.hands.SonyHand;
import by.teachmeskills.robot.hands.ToshibaHand;
import by.teachmeskills.robot.price.RobotPartPriceGenerator;

import java.util.Random;

public class RandomHandFactory extends RobotPartFactory implements HandFactory {
    private final Random random = new Random();

    public RandomHandFactory(RobotPartPriceGenerator generator) {
        super(generator);
    }

    /**
     * Создает руку случайного бренда, опираясь на {@link Random}
     */
    @Override
    protected RobotPart create() {
        int randomNumber = random.nextInt(3);
        RobotPart part = null;
        switch (randomNumber) {
            case 0 -> part = new SamsungHand();
            case 1 -> part = new SonyHand();
            case 2 -> part = new ToshibaHand();
        }
        return part;
    }

    @Override
    public IHand createHand() {
        return (IHand) createPartAndAssignPrice();
    }
}
