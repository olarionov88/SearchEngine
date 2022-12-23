public class RAM {
    private final RAMType type;
    private final int volume;
    private final double weight;

    public RAM(RAMType type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "ОЗУ (" +
                "Тип: " + type +
                ", Объем: " + volume +
                ", Вес: " + weight +
                ')';
    }
}
