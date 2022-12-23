public class Monitor {
    private final int diagonal;
    private final MonitorType type;
    private final double weight;

    public Monitor(int diagonal, MonitorType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Монитор (" +
                "Диагональ: " + diagonal +
                ", Тип: " + type +
                ", Вес: " + weight +
                ')';
    }
}
