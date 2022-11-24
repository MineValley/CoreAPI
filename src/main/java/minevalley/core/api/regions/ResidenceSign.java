package minevalley.core.api.regions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.block.Block;

@Getter
@RequiredArgsConstructor
public abstract class ResidenceSign {

    private final Block block;
    private final Direction direction;

    public abstract void place();

    public abstract void remove();

    public enum Direction {
        FLOOR,
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
}