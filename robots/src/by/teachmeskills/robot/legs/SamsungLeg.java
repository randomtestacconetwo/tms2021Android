package by.teachmeskills.robot.legs;


import by.teachmeskills.robot.parts.SamsungRobotPart;

public class SamsungLeg extends SamsungRobotPart implements ILeg {
    private int price;

    public SamsungLeg(int price) {
        this.price = price;
    }

    public SamsungLeg() {
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
