package by.teachmeskills.robot.legs;

import by.teachmeskills.robot.parts.ToshibaRobotPart;

public class ToshibaLeg extends ToshibaRobotPart implements ILeg {
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    public ToshibaLeg() {
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
