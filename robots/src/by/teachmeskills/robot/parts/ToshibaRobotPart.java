package by.teachmeskills.robot.parts;

import by.teachmeskills.robot.brand.Brand;

public abstract class ToshibaRobotPart implements RobotPart {
    private final Brand brand = Brand.TOSHIBA;

    @Override
    public Brand getBrand() {
        return brand;
    }
}
