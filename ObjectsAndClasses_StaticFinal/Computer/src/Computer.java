public class Computer {
    private final String name;
    private final String vendor;
    private CPU cpu;
    private RAM ram;
    private Winchester winchester;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer(String name, String vendor, CPU cpu, RAM ram,
                    Winchester winchester, Monitor monitor, Keyboard keyboard) {
        this.name = name;
        this.vendor = vendor;
        this.cpu = cpu;
        this.ram = ram;
        this.winchester = winchester;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public double totalWeight() {
        return cpu.getWeight() + ram.getWeight() + winchester.getWeight() +
                monitor.getWeight() + keyboard.getWeight();
    }

    public CPU getCpu() {
        return cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public Winchester getWinchester() {
        return winchester;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setWinchester(Winchester winchester) {
        this.winchester = winchester;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String toString() {
        return "комплектация" + "\n" +
                "Название: " + name + "\n" +
                "Производитель:" + vendor + "\n" +
                cpu + "\n" +
                ram + "\n" +
                winchester + "\n" +
                monitor + "\n" +
                keyboard + "\n";
    }
}
