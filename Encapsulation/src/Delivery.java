public class Delivery {
    private final Dimensions dimensions;
    private final int weight;
    private final String address;
    private boolean turnOver;
    private String regNumber;
    private boolean fragile;

    public Delivery(Dimensions dimensions, int weight, String address, boolean turnOver, String regNumber, boolean fragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.turnOver = turnOver;
        this.regNumber = regNumber;
        this.fragile = fragile;
    }

    public Delivery setDimensions(Dimensions dimensions) {
        Delivery copy = new Delivery(dimensions, weight, address, turnOver, regNumber, fragile);
        return copy;
    }

    public Delivery setWeight(int weight) {
        Delivery copy = new Delivery(dimensions, weight, address, turnOver, regNumber, fragile);
        return copy;
    }

    public Delivery setAddress(String address) {
        Delivery copy = new Delivery(dimensions, weight, address, turnOver, regNumber, fragile);
        return copy;
    }

    public String toString() {
        return "Габариты: " + dimensions + "\n" +
                "Вес: " + weight + "\n" +
                "Адрес доставки: "+ address + "\n" +
                "Не переворачивать: " + (turnOver == true ? "Да" : "Нет") + "\n" +
                "Рег. номер: " + regNumber + "\n" +
                "Хрупкий: " + (fragile == true ? "Да" : "Нет") + "\n";
    }
}
