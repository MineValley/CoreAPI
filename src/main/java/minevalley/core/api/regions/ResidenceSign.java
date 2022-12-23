package minevalley.core.api.regions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.block.Block;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public abstract class ResidenceSign {

    private final Block block;
    private final Direction direction;

    public abstract boolean worksAsBell();

    public abstract void setBell(boolean worksAsBell);

    public abstract void place();

    public abstract void remove();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Direction {
        NORTH((byte) 3),
        EAST((byte) 4),
        SOUTH((byte) 2),
        WEST((byte) 5);

        private final byte raw;

        public static Direction get(byte raw) {
            return Arrays.stream(Direction.values()).filter(direction1 -> direction1.getRaw() == raw).findFirst().orElse(null);
        }
    }
}