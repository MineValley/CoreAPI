package minevalley.core.api.gui;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

public record FillItem(@Nonnull ItemStack itemStack, @Nullable Consumer<GuiItemClick> callback) {

    public FillItem {
        if (itemStack == null) throw new IllegalArgumentException("ItemStack cannot be null");
    }
}
