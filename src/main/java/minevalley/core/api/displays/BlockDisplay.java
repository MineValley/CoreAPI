package minevalley.core.api.displays;

import org.bukkit.Material;

import javax.annotation.Nonnull;

public interface BlockDisplay extends Display {

    /**
     * Set the material of the display
     *
     * @param material the material
     * @return the current instance
     */
    BlockDisplay setMaterial(@Nonnull Material material);

    /**
     * Update the block state of the display.
     */
    void updateBlockState();
}