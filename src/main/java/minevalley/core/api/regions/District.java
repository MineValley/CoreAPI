package minevalley.core.api.regions;

import minevalley.core.api.OnlineUser;
import org.bukkit.Chunk;

import java.util.List;

public interface District extends PlayerLocation {

    int getId();

    Chunk[] getChunks();

    String getDescription();

    List<OnlineUser> getUsersInDistrict();

    void addChunk(Chunk chunk);

    void addChunks(List<Chunk> chunks);

    void removeChunk(Chunk chunk);

    void removeChunks(List<Chunk> chunks);

    void remove();
}
