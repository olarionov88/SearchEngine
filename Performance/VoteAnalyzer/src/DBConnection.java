import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/voters?" +
            "useUnicode=true&serverTimezone=Europe/Moscow" +
            "&characterEncoding=UTF-8" +
            "&rewriteBatchedStatements=true";
    private static final String dbUser = "root";
    private static final String dbPass = "skillbox";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id))");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        String sql = "SELECT id FROM voter_count WHERE birthDate='" + birthDay + "' AND name='" + name + "'";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        if (!rs.next()) {
            DBConnection.getConnection().createStatement()
                    .execute("INSERT INTO voter_count(name, birthDate, `count`) VALUES('" +
                            name + "', '" + birthDay + "', 1), " +
                            "ON DUPLICATE KEY UPDATE `count` = `count` + 1");
        } else {
            int id = rs.getInt("id");
            DBConnection.getConnection().createStatement()
                    .execute("UPDATE voter_count SET `count`=`count`+1 WHERE id=" + id);
        }
        rs.close();
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }

    public static void printVoterCountsForSAXParser() {

        String createTable = "Create table double_voters (name Tinytext, count INT)";
        String insert = "INSERT INTO double_voters (name, count) " +
                "SELECT name, count(*) from learn.voter_count group by name having count(*) > 1 order by count(*) desc";

        String select = "SELECT name, count FROM double_voters";

        try {
            connection.createStatement().execute("DROP TABLE IF EXISTS double_voters");
            connection.createStatement().execute(createTable);
            connection.createStatement().execute(insert);

            ResultSet rs = connection.createStatement().executeQuery(select);

            while (rs.next()) {
                System.out.println("\t" + rs.getString("name") + " " + rs.getInt("count"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}