package minevalley.core.api.displays;

import org.bukkit.block.BlockState;

import javax.annotation.Nonnull;

public interface BlockDisplay extends Display {

    /**
     * Set the block state of the display
     *
     * @param blockState the block state
     * @return the current instance
     */
    BlockDisplay setBlockState(@Nonnull BlockState blockState);

    /**
     * Update the block state of the display.
     */
    void updateBlockState();
}