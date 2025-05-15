package minevalley.core.api.regions.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.List;

@SuppressWarnings("unused")
public interface Area {

    Block getMinBlock();

    Block getMaxBlock();

    List<Block> getBlocks();

    boolean contains(Block block);

    default boolean contains(Location location) {
        return contains(location.getBlock());
    }

}
