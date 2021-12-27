package minevalley.core.api.regions;


import minevalley.core.api.CoreServer;
import org.bukkit.Chunk;
import org.bukkit.Location;

public final class RegionManager {

    public static CoreServer server;

    public RegionManager(CoreServer coreServer) {
        server = coreServer;
    }

    /**
     * Gets the region in which this location lies in.
     * @param location location to get region
     * @return region in which this location lies in
     */
    public static Region getRegion(Location location) {
        return server.getRegion(location);
    }

    /**
     * Gets the cuboid in which this location lies in.
     * @param location location to get cuboid
     * @return cuboid in which this location lies in
     */
    public static Cuboid getCuboid(Location location) {
        return server.getCuboid(location.getChunk());
    }

    /**
     * Gets the cuboid that is defined with the specific chunk.
     * @param chunk chunk to get cuboid from
     * @return cuboid of the specific chunk
     */
    public static Cuboid getCuboid(Chunk chunk) {
        return server.getCuboid(chunk);
    }

    /**
     * Gets an area object with the given locations.
     * @param loc1 first location
     * @param loc2 second location
     * @return area with the given locations
     */
    public static Area getArea(Location loc1, Location loc2) {
        return server.getArea(loc1, loc2);
    }
}