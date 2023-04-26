public class Station {
    private String name;
    private String line;
    private Boolean hasConnection;

    public Station(String name, String line, Boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.hasConnection = hasConnection;
    }

    public String getLine() {
        return line;
    }

    public String getName() {
        return name;
    }
    public Boolean getHasConnection() {
        return hasConnection;
    }

    @Override
    public String toString() {
        return "Station{" + "name='" + name + '\'' + ", line='" + line + '\'' + '}';
    }
}