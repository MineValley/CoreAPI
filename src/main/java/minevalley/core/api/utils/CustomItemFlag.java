package minevalley.core.api.utils;

public enum CustomItemFlag {

    /**
     * Prevents the item from being dropped by the player. This includes dropping the item by pressing the drop key or dragging it out of the inventory.
     */
    PREVENT_DROPPING,

    /**
     * Prevents the item from being dropped by the player, but allows the item to be dropped when dragging it out of the inventory.
     */
    PREVENT_KEY_DROPPING,

    /**
     * Prevents the item from being placed by the player. This includes placing the item as a block or using it on an entity (e.g. armor stands, item frames).
     */
    PREVENT_PLACING,

    /**
     * Prevents the item from being used as a crafting ingredient. This includes using the item in a crafting table (including the industrial one), furnace, brewing stand, etc.
     */
    PREVENT_CRAFTING,

    /**
     * Prevents the item from being consumed by the player. This includes eating the item or using it as a potion ingredient.
     */
    PREVENT_CONSUMING,

    /**
     * Prevents the item from being placed out of the player's inventory. This includes placing the item in a container (e.g. chest, hopper, dispenser).
     * But this does not prevent users from dropping, consuming or using the item. When a player leaves or joins the server, the item will remain in the player's inventory.
     */
    KEEP_IN_INVENTORY,

    /**
     * When a player leaves or joins the server,
     * the item will be removed from the player's inventory.
     */
    TEMPORARY
}
