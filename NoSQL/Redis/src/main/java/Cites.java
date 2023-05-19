import java.util.Set;
import redis.clients.jedis.Jedis;

public class Cites {

    private Jedis client;

    public Cites(Jedis client) {
        this.client = client;
    }

    public void start(){
        init();
        showCheapest();
        showExpensive();
        removeKey();
    }

    private void init (){
        client.zadd("City",5000, "Moskow");
        client.zadd("City",8000, "Novosibirsk");
        client.zadd("City",1000, "Ekaterinburg");
        client.zadd("City",12000, "Pyatigorsk");
        client.zadd("City",30000, "Kaliningrad");
        client.zadd("City",1500, "Ufa");
        client.zadd("City",3500, "Kazan");
        client.zadd("City",7000, "Grozny");
        client.zadd("City",35000, "Vladivostik");
    }

    private void showCheapest(){
        Set<String> city = client.zrange("City", 0, 2);
        System.out.println("Топ-3 самые дешевые: " + city);
    }

    private void showExpensive(){
        Set<String> city = client.zrevrange("City", 0, 2);
        System.out.println("Топ-3 самые дорогие: " + city);
        System.out.println();
    }

    private void removeKey() {
        client.del("City");
    }
}