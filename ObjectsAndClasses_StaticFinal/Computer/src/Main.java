public class Main {
    public static void main(String[] args) {
        CPU cpuIntel = new CPU(1800,2,"Intel",5.4);
        CPU cpuAMD = new CPU(1200,4,"AMD",6.3);
        RAM ramDDR3 = new RAM(RAMType.DDR3,2048,8.1);
        RAM ramDDR4 = new RAM(RAMType.DDR4,4096,7.2);
        Winchester hdd = new Winchester(WinchesterType.HDD,250,71.5);
        Winchester ssd = new Winchester(WinchesterType.SSD,120,30.2);
        Monitor ips = new Monitor(22,MonitorType.IPS,242.3);
        Monitor tn = new Monitor(27,MonitorType.TN,276.6);
        Keyboard genius = new Keyboard(KeyboardType.MEMBRANE,false,22.6);
        Keyboard logitech = new Keyboard(KeyboardType.MECHANIC,true,25.3);

        Computer office = new Computer("Office", "Asus",cpuIntel, ramDDR3, ssd, ips, genius);
        Computer home = new Computer("Home", "HP", cpuAMD, ramDDR4, hdd, tn, logitech);

        System.out.println("Вес компьютера Home: " + home.totalWeight());
        System.out.println("Вес компьютера Office: " + office.totalWeight());
        System.out.println("");
        System.out.println(office);
        System.out.println(home);

        home.setMonitor(new Monitor(24, MonitorType.VA, 256.8));
        System.out.println("Вес компьютера Home: " + home.totalWeight());
        System.out.println(home);


    }
}