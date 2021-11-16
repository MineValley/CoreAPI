package eu.minevalley.core.api.misc;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public interface Hologram {

    void addLine(String message);

    void setLine(int line, String message);

    void display(Player player);

    void displayAnimated(Player player);

    void display(List<Player> players);

    void displayAll();

    void destroy(Player player);

    void destroy(List<Player> players);

    void destroyAll();

    void move(Location location);

    List<Player> getPlayers();

    Location getLocation();
}