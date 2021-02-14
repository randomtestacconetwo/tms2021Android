package by.teachmeskills.robot.brand;

public class BrandOverprice {
    private final Brand brand;
    private final int overprice;

    public BrandOverprice(Brand brand, int overprice) {
        this.brand = brand;
        this.overprice = overprice;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getOverprice() {
        return overprice;
    }
}
