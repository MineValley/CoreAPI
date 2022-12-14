package minevalley.core.api.regions;

import minevalley.core.api.OnlineUser;
import org.bukkit.Chunk;

import java.util.List;

public interface District {

    int getId();

    Chunk[] getChunks();

    String getName();

    String getDescription();

    List<OnlineUser> getUsersInDistrict();

    void addChunk(Chunk chunk);

    void removeChunk(Chunk chunk);
}
