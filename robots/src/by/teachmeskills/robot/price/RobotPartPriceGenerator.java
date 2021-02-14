package by.teachmeskills.robot.price;

import by.teachmeskills.robot.brand.Brand;
import by.teachmeskills.robot.parts.RobotPart;
import by.teachmeskills.robot.brand.BrandOverprice;
import by.teachmeskills.robot.exceptions.UnknownRobotPartException;
import by.teachmeskills.robot.hands.IHand;
import by.teachmeskills.robot.heads.IHead;
import by.teachmeskills.robot.legs.ILeg;

import java.util.Random;

public class RobotPartPriceGenerator {
    private final int headMinPrice;
    private final int handMinPrice;
    private final int legMinPrice;
    private final BrandOverprice[] overPrices;

    /**
     * Вычисляет цены на запчасти без наценок и сохроаняет overPrices
     *
     * @param overPrices - список наценок на товар в зависимости от бренда
     */
    public RobotPartPriceGenerator(BrandOverprice[] overPrices) {
        this.overPrices = overPrices;
        Random random = new Random();
        headMinPrice = random.nextInt(50);
        handMinPrice = random.nextInt(40);
        legMinPrice = random.nextInt(30);
    }

    /**
     * Сначала вычисляет наценку исходя из бренда запчасти, потом добавляет к ней минимальную цену за запчасть
     *
     * @param part - запчасть, цену которой (с учетом наценки нужно определить)
     * @throws UnknownRobotPartException если прислали неизвестную запчасть
     */
    public int getRobotPartPrice(RobotPart part) throws UnknownRobotPartException {
        int overPrice = getOverPrice(part.getBrand());
        if (part instanceof IHand) {
            return handMinPrice + overPrice;
        } else if (part instanceof IHead) {
            return headMinPrice + overPrice;
        } else if (part instanceof ILeg) {
            return legMinPrice + overPrice;
        } else {
            throw new UnknownRobotPartException();
        }
    }

    /**
     *
     * @return наценку на запчасть исходя из бренда
     */
    private int getOverPrice(Brand brand) {
        for (BrandOverprice overPrice : overPrices) {
            if (brand.equals(overPrice.getBrand())) {
                return overPrice.getOverprice();
            }
        }
        // на неизвестные бренды наценка минимальная
        return 1;
    }

    @Override
    public String toString() {
        return "RobotPartPriceGenerator{" +
                "headMinPrice=" + headMinPrice +
                ", handMinPrice=" + handMinPrice +
                ", legMinPrice=" + legMinPrice +
                '}';
    }
}
