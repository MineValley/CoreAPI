package minevalley.core.api.regions;

import org.bukkit.entity.Player;

public interface FakeBlock {

    /**
     * Shows the block to specific players.
     *
     * @param players Players to whom the block is shown
     */
    void show(Player... players);

    /**
     * Hides the block from specific players.
     *
     * @param players Players from whom the block is hidden
     */
    void hide(Player... players);
}