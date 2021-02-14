package by.teachmeskills.robot;

import by.teachmeskills.robot.brand.*;
import by.teachmeskills.robot.factory.*;
import by.teachmeskills.robot.price.RobotPartPriceGenerator;

import static by.teachmeskills.robot.brand.Brand.*;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
        BrandOverprice[] overPrices = {
                new BrandOverprice(SAMSUNG, 100),
                new BrandOverprice(TOSHIBA, 10),
                new BrandOverprice(SONY, 50)
        };
        RobotPartPriceGenerator generator = new RobotPartPriceGenerator(overPrices);
        System.out.println(generator);

        HeadFactory headFactory = new RandomHeadFactory(generator);
        HandFactory handFactory = new RandomHandFactory(generator);
        LegFactory legFactory = new RandomLegFactory(generator);
        RobotFactory robotFactory = new RobotFactory(headFactory, handFactory, legFactory);

        Robot r1 = robotFactory.createRobot();
        Robot r2 = robotFactory.createRobot();
        Robot r3 = robotFactory.createRobot();
        Robot r4 = robotFactory.createRobot();
        Robot[] robots = {r1,r2,r3,r4};
        for (Robot r : robots) {
            r.action();
        }
        Robot theMostExpensive = RobotUtil.findTheMostExpensive(robots);
        System.out.println(theMostExpensive.getPrice());
    }
}
