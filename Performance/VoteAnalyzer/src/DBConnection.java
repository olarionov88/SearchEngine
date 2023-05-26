import java.sql.*;

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
                        "PRIMARY KEY(id), ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static void setCommitFalse() throws SQLException {
        connection.setAutoCommit(false);
    }

    public static void setCommit(PreparedStatement stmt) throws SQLException {
        connection.commit();
        stmt.clearBatch();
    }

    public static void printVoterCounts() throws SQLException
    {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while(rs.next())
        {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}