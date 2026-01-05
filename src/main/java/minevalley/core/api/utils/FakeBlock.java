package minevalley.core.api.utils;

import minevalley.core.api.modifiers.VisibilityModifier;
import org.bukkit.Material;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface FakeBlock extends VisibilityModifier<FakeBlock> {

    /**
     * Get the block this fake block is placed on
     *
     * @return the block this fake block is placed on
     */
    @Nonnull
    Block getBlock();

    /**
     * Get the material of this fake block
     *
     * @return the material of this fake block
     */
    @Nonnull
    Material getMaterial();
}