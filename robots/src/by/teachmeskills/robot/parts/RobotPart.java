package by.teachmeskills.robot.parts;

import by.teachmeskills.robot.brand.Brand;

public interface RobotPart {
    Brand getBrand();
    int getPrice();
    void setPrice(int price);
}
