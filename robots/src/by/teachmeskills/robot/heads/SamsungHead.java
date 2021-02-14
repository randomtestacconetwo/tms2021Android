package by.teachmeskills.robot.heads;


import by.teachmeskills.robot.parts.SamsungRobotPart;

public class SamsungHead extends SamsungRobotPart implements IHead {
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }

    public SamsungHead() {
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
