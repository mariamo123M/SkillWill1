public class Vehicle {
    private String brand;
    private String modelName;
    private int releaseYear;

    public Vehicle(String brand, String modelName, int releaseYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.releaseYear = releaseYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Vehicle { Brand: " + brand + ", Model: " + modelName + ", Year: " + releaseYear + " }";
    }
}