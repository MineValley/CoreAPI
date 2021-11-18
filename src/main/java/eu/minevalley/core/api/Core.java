package eu.minevalley.core.api;

import eu.minevalley.core.api.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.UUID;

public final class Core {

    private static CoreServer server;

    public Core(CoreServer server) {
        Core.server = server;
    }

    public static ItemBuilder createItem(Material material) {
        return server.createItem(material);
    }

    public static ItemBuilder createItem(Material material, short data) {
        return server.createItem(material, data);
    }

    public static ItemBuilder createItem(Player player) {
        return server.createItem(player);
    }

    public static ItemBuilder createItem(UUID uniqueId) {
        return server.createItem(uniqueId);
    }

    public static ItemBuilder createItem(String url) {
        return server.createItem(url);
    }
}