package minevalley.core.api.regions;

import org.bukkit.Chunk;

public interface District {

    int getId();

    Chunk[] getChunks();

    String getName();

    String getDescription();
}
