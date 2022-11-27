package minevalley.core.api.regions;

import minevalley.core.api.CoreServer;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class RegionManager {

    private static CoreServer server;

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

    public static Region getRegion(Block block) {
        return server.getRegion(block.getLocation());
    }

    public static Residence getResidence(int id) {
        return server.getResidence(id);
    }

    public static Residence getResidence(Region region) {
        return server.getResidence(region);
    }

    public static Residence getResidence(Location location) {
        return server.getResidence(getRegion(location));
    }

    public static Residence getResidence(Block block) {
        return server.getResidence(getRegion(block));
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
     * Gets an area object with only one block.
     */
    public static Area getAreaOfBlock(Block block) {
        return server.getArea(block, block);
    }

    /**
     * Gets the area that is represented by a specific string.
     *
     * @param rawArea area as string
     * @return area that is represented by the specific string
     */
    public static Area getAreaFromString(String rawArea) {
        return server.getAreaFromString(rawArea);
    }
}