import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RouteCalculatorTest extends TestCase {
    List<Station> routeOnTheLine;
    List<Station> routeWithOneConnection;
    List<Station> routeWithTwoConnections;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;
    Station first;
    Station second;
    Station third;
    Station fourth;
    Station fifth;
    Station sixth;
    Station seventh;
    Station eighth;
    Station ninth;

    protected void setUp() {

        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Первая линия");
        Line line2 = new Line(2, "Вторая линия");
        Line line3 = new Line(3, "Третья линия");

        first = new Station("Первая", line1);
        second = new Station("Вторая", line1);
        third = new Station("Третья", line1);
        fourth = new Station("Четвертая", line2);
        fifth = new Station("Пятая", line2);
        sixth = new Station("Шестая", line2);
        seventh = new Station("Седьмая", line3);
        eighth = new Station("Шестая", line3);
        ninth = new Station("Седьмая", line3);

        Stream.of(line1, line2, line3).forEach(stationIndex::addLine);
        Stream.of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)
                .peek(s -> s.getLine().addStation(s)).forEach(stationIndex::addStation);
        stationIndex.addConnection(Stream.of(second, fifth).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(sixth, ninth).collect(Collectors.toList()));
        stationIndex.getConnectedStations(second);
        stationIndex.getConnectedStations(sixth);

        routeCalculator = new RouteCalculator(stationIndex);

        routeOnTheLine = Stream.of(fourth, fifth, sixth).collect(Collectors.toList());
        routeWithOneConnection = Stream.of(first, second, fifth, sixth).collect(Collectors.toList());
        routeWithTwoConnections = Stream.of(first, second, fifth, sixth, ninth).collect(Collectors.toList());
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(routeCalculator
                .getShortestRoute(stationIndex.getStation("Первая"),
                        stationIndex.getStation("Шестая")));
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actualRouteOnTheLine = routeCalculator.getShortestRoute(fourth, sixth);
        List<Station> expectedRouteOnTheLine = routeOnTheLine;
        assertEquals(expectedRouteOnTheLine, actualRouteOnTheLine);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actualRouteWithOneConnection = routeCalculator.getShortestRoute(first, sixth);
        List<Station> expectedRouteWithOneConnection = routeWithOneConnection;
        assertEquals(expectedRouteWithOneConnection, actualRouteWithOneConnection);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actualRouteWithTwoConnections = routeCalculator.getShortestRoute(first, ninth);
        List<Station> expectedRouteWithTwoConnections = routeWithTwoConnections;
        assertEquals(expectedRouteWithTwoConnections, actualRouteWithTwoConnections);
    }
}