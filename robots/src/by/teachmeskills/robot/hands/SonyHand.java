package by.teachmeskills.robot.hands;

import by.teachmeskills.robot.parts.SonyRobotPart;

public class SonyHand extends SonyRobotPart implements IHand {
    private int price;

    public SonyHand(int price) {
        this.price = price;
    }

    public SonyHand() {
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
