import redis.clients.jedis.Jedis;
public class Main {
    public static void main(String[] args) {

        Jedis client = new Jedis("localhost", 6379);
        //Задание №1
        Cites cites = new Cites(client);
        cites.start();

        //Задание №2
        Meeting log = new Meeting(client);
        log.start();
    }
}
