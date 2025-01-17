package minevalley.core.api.regions.structures;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import minevalley.core.api.regions.utils.PlayerLocation;
import org.bukkit.Location;

import java.util.List;

@SuppressWarnings("unused")
public interface Street {

    /**
     * Every street will be assigned an ID. It should be used to refer to this street.
     *
     * @return id as integer.
     */
    int getId();

    /**
     * Gets this streets name. Don't use it to refer to the street. Names might change in the future. Use getId instead!
     *
     * @return name as string.
     */
    String getName();

    String getShortName();

    /**
     * Get the description of this street. Not every street does have a description. If the street doesn't have a description, this is null.
     *
     * @return description as string.
     */
    String getDescription();

    void remove();

    @Setter
    class StreetHelper {
        private static IStreetHelper helper;

        public static List<NavigationPoint> getAllNavigationPoints() {
            return helper.getAllNavigationPoints();
        }

        public static List<NavigationPoint> getNavigationPoints(Street street) {
            return helper.getNavigationPoints(street);
        }

        public static void addNavigationPoint(NavigationPoint navigationPoint) {
            helper.addNavigationPoint(navigationPoint);
        }

        public static void removeNavigationPoint(NavigationPoint navigationPoint) {
            helper.removeNavigationPoint(navigationPoint);
        }

        public static NavigationPoint getNearest(Location location) {
            return helper.getNearest(location);
        }
    }

    interface IStreetHelper {

        List<NavigationPoint> getAllNavigationPoints();

        List<NavigationPoint> getNavigationPoints(Street street);

        void addNavigationPoint(NavigationPoint navigationPoint);

        void removeNavigationPoint(NavigationPoint navigationPoint);

        NavigationPoint getNearest(Location location);
    }

    @Getter
    @RequiredArgsConstructor
    class NavigationPoint implements PlayerLocation {
        private final Street street;
        private final Location location;
        private final String name;
        private final List<Connection> connections;

        public double distance(Location location) {
            if (location == null) return -1;
            if (this.location.getWorld() != location.getWorld()) return -1;
            return this.location.distance(location);
        }

        public double distance(NavigationPoint navigationPoint) {
            return distance(navigationPoint.getLocation());
        }

        public void addConnection(Connection connection) {
            connections.add(connection);
        }

        private void removeConnection(Connection connection) {
            connections.remove(connection);
        }
    }

    interface Connection {

        int weight();

        boolean isUsableFromHere(NavigationPoint navigationPoint);

        NavigationHint getNavigationHint(NavigationPoint from);

        void remove();
    }

    enum NavigationHint {
        NONE,
        TURN_RIGHT,
        TURN_LEFT,
        KEEP_TO_THE_RIGHT,
        KEEP_TO_THE_LEFT,
        ROUNDABOUT_FIRST_EXIT,
        ROUNDABOUT_SECOND_EXIT,
        ROUNDABOUT_THIRD_EXIT,
        ROUNDABOUT_FOURTH_EXIT,
        TURN
    }

    @Getter
    @RequiredArgsConstructor
    class OneWayConnection implements Connection {
        private final NavigationPoint from, to;
        private final int speedLimit;
        private final NavigationHint navigationHint;

        @Override
        public int weight() {
            return (int) Math.round(from.distance(to) * speedLimit);
        }

        @Override
        public boolean isUsableFromHere(NavigationPoint navigationPoint) {
            return from == navigationPoint;
        }

        @Override
        public NavigationHint getNavigationHint(NavigationPoint from) {
            if (!isUsableFromHere(from)) return NavigationHint.NONE;
            return navigationHint;
        }

        @Override
        public void remove() {
            from.removeConnection(this);
            to.removeConnection(this);
        }
    }

    @Getter
    @RequiredArgsConstructor
    class TwoWayConnection implements Connection {
        private final NavigationPoint point1, point2;
        private final int speedLimit;
        private final NavigationHint point1To2, point2To1;

        @Override
        public int weight() {
            return (int) Math.round(point1.distance(point2) * speedLimit);
        }

        @Override
        public boolean isUsableFromHere(NavigationPoint navigationPoint) {
            return point1 == navigationPoint || point2 == navigationPoint;
        }

        @Override
        public NavigationHint getNavigationHint(NavigationPoint from) {
            if (!isUsableFromHere(from)) return NavigationHint.NONE;
            return from == this.point1 ? point1To2 : point2To1;
        }

        @Override
        public void remove() {
            point1.removeConnection(this);
            point2.removeConnection(this);
        }
    }
}
