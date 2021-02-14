package by.teachmeskills.robot.legs;

import by.teachmeskills.robot.parts.SamsungRobotPart;

public class SonyLeg extends SamsungRobotPart implements ILeg {
    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    public SonyLeg() {
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
