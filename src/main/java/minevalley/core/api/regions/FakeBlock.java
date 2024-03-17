package minevalley.core.api.regions;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
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

    /**
     * Shows the block to specific users.
     *
     * @param users Users to whom the block is shown
     */
    void show(OnlineUser... users);

    /**
     * Hides the block from specific users.
     *
     * @param users Users from whom the block is hidden
     */
    void hide(OnlineUser... users);
}