package by.teachmeskills.robot.parts;

import by.teachmeskills.robot.brand.Brand;

public abstract class SamsungRobotPart implements RobotPart {
    private final Brand brand = Brand.SAMSUNG;

    @Override
    public Brand getBrand() {
        return brand;
    }
}
