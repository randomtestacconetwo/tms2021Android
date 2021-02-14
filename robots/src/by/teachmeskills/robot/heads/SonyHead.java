package by.teachmeskills.robot.heads;

import by.teachmeskills.robot.parts.SamsungRobotPart;

public class SonyHead extends SamsungRobotPart implements IHead {
    private int price;

    public SonyHead(int price) {
        this.price = price;
    }

    public SonyHead() {
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
