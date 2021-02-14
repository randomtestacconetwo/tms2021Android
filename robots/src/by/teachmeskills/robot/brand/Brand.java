package by.teachmeskills.robot.brand;

public enum Brand {
    SAMSUNG("Samsung"), TOSHIBA("Toshiba"), SONY("Sony");
    private final String brand;

    Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
