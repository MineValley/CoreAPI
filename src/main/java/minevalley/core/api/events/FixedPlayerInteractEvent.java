package minevalley.core.api.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This event equals the PlayerInteractEvent. It is called when a player interacts with an object or air.
 * <p>
 * Things we changed:
 * <br>
 * - Event is only called when a player also has the permission to interact (knocked out; frozen by team)
 * <br>
 * - Event is only called once, even though the player uses two hands as in the PlayerInteractEvent
 * <p>
 * <i>Credits: This class consists largely of Spigot's PlayerInteractEvent class.</i>
 */
@Getter
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted"})
public class FixedPlayerInteractEvent extends PlayerEvent implements Cancellable {

    protected ItemStack item;
    protected Action action;
    protected Block blockClicked;
    protected BlockFace blockFace;
    private Result useClickedBlock;
    @Setter
    private Result useItemInHand;
    private final EquipmentSlot hand;

    private final static @Getter(onMethod_ = @Nonnull) HandlerList handlerList = new HandlerList();

    @Override
    public @Nonnull HandlerList getHandlers() {
        return handlerList;
    }

    public FixedPlayerInteractEvent(PlayerInteractEvent e) {
        super(e.getPlayer());
        this.action = e.getAction();
        this.item = e.getItem();
        this.blockClicked = e.getClickedBlock();
        this.blockFace = e.getBlockFace();
        this.hand = e.getHand();

        useItemInHand = Result.DEFAULT;
        useClickedBlock = e.getClickedBlock() == null ? Result.DENY : Result.ALLOW;
    }

    /**
     * Gets the cancellation state of this event. Set to true if you want to
     * prevent buckets from placing water and so forth
     *
     * @return boolean cancellation state
     */
    public boolean isCancelled() {
        return useInteractedBlock() == Result.DENY;
    }

    /**
     * Sets the cancellation state of this event. A canceled event will not be
     * executed in the server, but will still pass to other plugins
     * <p>
     * Canceling this event will prevent use of food (player won't lose the
     * food item), prevent bows/snowballs/eggs from firing, etc. (player won't
     * lose the ammo)
     *
     * @param cancel true if you wish to cancel this event
     */
    public void setCancelled(boolean cancel) {
        setUseInteractedBlock(cancel ? Result.DENY : useInteractedBlock() == Result.DENY ? Result.DEFAULT : useInteractedBlock());
        setUseItemInHand(cancel ? Result.DENY : useItemInHand() == Result.DENY ? Result.DEFAULT : useItemInHand());
    }

    /**
     * Convenience method. Returns the material of the item represented by
     * this event
     *
     * @return Material the material of the item used
     */
    public Material getMaterial() {
        if (!hasItem()) {
            return Material.AIR;
        }

        return item.getType();
    }

    /**
     * Check if this event involved a block
     *
     * @return boolean true if it did
     */
    public boolean hasBlock() {
        return this.blockClicked != null;
    }

    /**
     * Check if this event involved an item
     *
     * @return boolean true if it did
     */
    public boolean hasItem() {
        return this.item != null;
    }

    /**
     * Convenience method to inform the user whether this was a block
     * placement event.
     *
     * @return boolean true if the item in hand was a block
     */
    public boolean isBlockInHand() {
        if (!hasItem()) return false;
        return item.getType().isBlock();
    }

    /**
     * Returns the clicked block
     *
     * @return Block returns the block clicked with this item.
     */
    public Block getClickedBlock() {
        return blockClicked;
    }

    /**
     * This controls the action to take with the block (if any) that was
     * clicked on. This event gets processed for all blocks, but most don't
     * have a default action
     *
     * @return the action to take with the interacted block
     */
    public Result useInteractedBlock() {
        return useClickedBlock;
    }

    /**
     * @param useInteractedBlock the action to take with the interacted block
     */
    public void setUseInteractedBlock(Result useInteractedBlock) {
        this.useClickedBlock = useInteractedBlock;
    }

    /**
     * This controls the action to take with the item the player is holding.
     * This includes both blocks and items (such as flint and steel or
     * records). When this is set to default, it will be allowed if no action
     * is taken on the interacted block.
     *
     * @return the action to take with the item in hand
     */
    public Result useItemInHand() {
        return useItemInHand;
    }
}

