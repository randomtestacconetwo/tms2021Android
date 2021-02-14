package by.teachmeskills.robot.hands;

import by.teachmeskills.robot.parts.ToshibaRobotPart;

public class ToshibaHand extends ToshibaRobotPart implements IHand {
    private int price;

    public ToshibaHand(int price) {
        this.price = price;
    }

    public ToshibaHand() {
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
