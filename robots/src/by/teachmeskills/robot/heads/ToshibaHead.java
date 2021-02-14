package by.teachmeskills.robot.heads;

import by.teachmeskills.robot.parts.ToshibaRobotPart;

public class ToshibaHead extends ToshibaRobotPart implements IHead {
    private int price;

    public ToshibaHead(int price) {
        this.price = price;
    }

    public ToshibaHead() {
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
