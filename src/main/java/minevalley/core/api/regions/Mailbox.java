package minevalley.core.api.regions;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.mail.Parcel;
import org.bukkit.block.Block;

public interface Mailbox {

    /**
     * The mailbox itself consists of a head placed outside the resident.
     * It is clickable and is used to display and empty the received mail just as add new letters.
     */
    Block getBlock();

    /**
     * There may be some blocks around the mailbox, that are directly connected to it. Such as fences that are used as a post.
     * If the mailbox is removed, these blocks will be replaced with air. If the mailbox is then placed again,
     * those blocks will be replaced with their representative area in the shadow world.
     */
    Area getConnectedBlocks();

    /**
     * This gets a copy of the list of all contents, that are already put into the mailbox by mailmen or other players.
     * Users with access-permission can collect those contents.
     * Items in this array haven't been collected so far.
     * Since this is a copy of the original list, changes on the array don't have any influence on ingame actions.
     * use the add(), clear() and remove() methods.
     */
    Parcel[] getContents();

    /**
     * Adds a parcel to this mailbox. It's itemstack will be added to the getContents-array.
     */
    void add(Parcel parcel);

    /**
     * Removes a specific parcel from the mailbox content list.
     */
    void remove(Parcel parcel, OnlineUser user);

    /**
     * This clears the whole contents list. Regardless of the previous content, the mailbox is now empty.
     */
    void clear();

    /**
     * Replaces the mailbox head such as the connected blocks with air.
     */
    void unPlace();

    /**
     * Replaces the mailbox head such as the connected blocks with their representative blocks in the shadow world.
     */
    void place();

    // setup-method
    void changeBlock(Block block);

    // setup-method
    void setConnectedBlocks(Area area);
}
