package minevalley.core.api.displays;

import org.bukkit.Material;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface BlockDisplay extends Display<BlockDisplay> {

    /**
     * Set the material of the display
     *
     * @param material the material
     * @return this
     * @throws IllegalArgumentException if the material is null, or not a block
     */
    @Nonnull
    @Contract("_ -> this")
    BlockDisplay setMaterial(@Nonnull Material material) throws IllegalArgumentException;

    /**
     * Update the block state of the display.
     */
    void updateBlockState();
}