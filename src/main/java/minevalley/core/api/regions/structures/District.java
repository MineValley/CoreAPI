package minevalley.core.api.regions.structures;

import minevalley.core.api.regions.utils.PlayerLocation;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;

import java.util.List;

@SuppressWarnings("unused")
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
