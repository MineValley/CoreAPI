package minevalley.core.api.regions;


import minevalley.core.api.CoreServer;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class RegionManager {

    public static CoreServer server;

    public RegionManager(CoreServer coreServer) {
        server = coreServer;
    }

    /**
     * Gets the region with the specific id.
     *
     * @param id regions id
     * @return region with specific id
     */
    public static Region getRegion(int id) {
        return server.getRegion(id);
    }

    /**
     * Gets the region in which this location lies in.
     *
     * @param location location to get region
     * @return region in which this location lies in
     */
    public static Region getRegion(Location location) {
        return server.getRegion(location);
    }

    /**
     * Gets an area object with the given locations.
     *
     * @param loc1 first location as block
     * @param loc2 second location as block
     * @return area with the given locations
     */
    public static Area getArea(Block loc1, Block loc2) {
        return server.getArea(loc1, loc2);
    }

    /**
     * Gets the locality connected with the specific chunk.
     *
     * @param chunk chunk to get locality from
     * @return specific chunk's locality
     */
    public static Locality getLocality(Chunk chunk) {
        return server.getLocality(chunk);
    }
}