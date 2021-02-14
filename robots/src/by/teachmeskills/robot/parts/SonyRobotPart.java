package by.teachmeskills.robot.parts;

import by.teachmeskills.robot.brand.Brand;

public abstract class SonyRobotPart implements RobotPart {
    private final Brand brand = Brand.SONY;

    @Override
    public Brand getBrand() {
        return brand;
    }
}
