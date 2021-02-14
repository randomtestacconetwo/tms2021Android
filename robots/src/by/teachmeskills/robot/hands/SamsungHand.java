package by.teachmeskills.robot.hands;


import by.teachmeskills.robot.parts.SamsungRobotPart;

public class SamsungHand extends SamsungRobotPart implements IHand {
    private int price;

    public SamsungHand(int price) {
        this.price = price;
    }

    public SamsungHand() {
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
