package minevalley.core.api.regions;

import org.bukkit.Chunk;

public interface Locality {

    /**
     * Gets this localitys id.
     *
     * @return id as integer
     */
    int getId();

    /**
     * Gets the name of this locality.
     *
     * @return name as string
     */
    String getName();

    /**
     * Gets the description of this locality.
     *
     * @return descripton as string
     */
    String getDescription();

    /**
     * Gets the locality connected with the specific chunk.
     *
     * @param chunk chunk to get locality from
     * @return specific chunk's locality
     */
    Locality getLocality(Chunk chunk);
}
