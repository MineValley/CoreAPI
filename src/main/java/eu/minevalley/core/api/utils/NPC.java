package eu.minevalley.core.api.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public interface NPC {


    String getName();

    String getDisplayName();

    void setMetadata(String metadata);

    String getMetadata();

    List<Player> getPlayers();

    Location getLocation();
}
