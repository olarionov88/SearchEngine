import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLHandlerDB extends DefaultHandler {

    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private final Connection connection = DBConnection.getConnection();
    private Voter voter;
    private StringBuilder insertQuery = new StringBuilder();
    private List<StringBuilder> queries = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter") && voter == null) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {

                String date = birthDayFormat.format(voter.getBirthDay());
                insertToStringBuilder(insertQuery, date);
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void executeInsert() throws SQLException {

        queries.add(insertQuery); //
        insertQuery = null;


        for (StringBuilder query : queries) {
            String sql = "INSERT INTO voter_count(name, birthDate, count)" +
                    "VALUES" + query.toString() +
                    "ON DUPLICATE KEY UPDATE count = count + 1";
            connection.createStatement().execute(sql);
        }
    }

    private void insertToStringBuilder(StringBuilder builder, String date) {
        builder.append(builder.length() == 0 ? "" : ",")
                .append("('")
                .append(voter.getName())
                .append("', '")
                .append(date)
                .append("', 1)");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {

            if (insertQuery.length() > 250000) {
                queries.add(insertQuery);
                insertQuery = new StringBuilder();
            }

            voter = null;
        }
    }
}