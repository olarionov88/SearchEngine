public class Winchester {
    private final WinchesterType type;
    private final int volume;
    private final double weight;

    public Winchester(WinchesterType type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Накопитель (" +
                "Тип: " + type +
                ", Объем:" + volume +
                ", Вес:" + weight +
                ')';
    }
}
