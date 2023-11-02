package zoo.enclosures;
public abstract class Enclosure {
    private int enclosureNumber;
    private double sizeInSquareMeters;
    private int temperature;

    public Enclosure(int gehegeNumber, double sizeInSquareMeters, int temperature) {
        this.enclosureNumber = gehegeNumber;
        this.sizeInSquareMeters = sizeInSquareMeters;
        this.temperature = temperature;
    }
}
