package eu.minevalley.core.api.virtual;

import eu.minevalley.core.api.virtual.modifier.VisibilityModifier;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface FakeBlock extends VisibilityModifier<FakeBlock> {

    /**
     * Get the block this fake block is placed on
     *
     * @return the block this fake block is placed on
     */
    @Nonnull
    @Contract(pure = true)
    Block getBlock();

    /**
     * Get the material of this fake block
     *
     * @return the material of this fake block
     */
    @Nonnull
    @Contract(pure = true)
    Material getMaterial();
}