package minevalley.core.api.npc;

import minevalley.core.api.messaging.MessageSender;
import minevalley.core.api.modifiers.*;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.utils.Passenger;
import minevalley.core.api.utils.Vehicle;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface NPC extends MessageSender, Passenger, Vehicle, EquipmentModifier<NPC>, InteractionModifier<NPC>, LocationModifier<NPC>,
        PassengerModifier<NPC>, VehicleModifier<NPC>, VisibilityModifier<NPC> {

    /**
     * Gets the name of the NPC.
     *
     * @return the name of the NPC
     */
    @Nonnull
    @Contract(pure = true)
    String name();

    /**
     * Checks if the NPC focuses on nearby players.
     *
     * @return true if the NPC focuses on nearby players, false otherwise
     */
    boolean focusNearPlayers();

    /**
     * Sets whether the NPC should focus on nearby players.
     *
     * @param focusNearPlayers true to focus on nearby players, false otherwise
     */
    void setFocusNearPlayers(boolean focusNearPlayers);

    /**
     * Zooms in the NPC for the given user.
     *
     * @param user               the user to zoom in the NPC for
     * @param allowManualZoomOut whether the user is allowed to manually zoom out
     * @throws IllegalArgumentException if the user is null or not in the same world as the NPC
     */
    void zoomIn(@Nonnull OnlineUser user, boolean allowManualZoomOut) throws IllegalArgumentException;

    /**
     * Zooms in the NPC for the given user with manual zoom out allowed.
     *
     * @param user the user to zoom in the NPC for
     * @throws IllegalArgumentException if the user is null or not in the same world as the NPC
     */
    default void zoomIn(@Nonnull OnlineUser user) throws IllegalArgumentException {
        zoomIn(user, true);
    }

    /**
     * Zooms out the NPC for the given user.
     *
     * @param user the user to zoom out the NPC for
     * @throws IllegalArgumentException if the user is null or not in the same world as the NPC
     */
    void zoomOut(@Nonnull OnlineUser user) throws IllegalArgumentException;

    /**
     * Sets a callback that is called when a user zooms out the NPC.
     *
     * @param callback the callback to set, or null to remove the callback
     */
    void onZoomOut(@Nullable Consumer<OnlineUser> callback);

    /**
     * Checks if the NPC is zoomed in for the given user.
     *
     * @param user the user to check
     * @return true if the NPC is zoomed in for the user, false otherwise
     */
    @Contract(value = "null -> false", pure = true)
    boolean isZoomedIn(@Nullable OnlineUser user);

    /**
     * Gets a list of all users who are zoomed in the NPC.
     *
     * @return a list of all users who are zoomed in the NPC
     */
    @Nonnull
    @Contract(pure = true)
    List<OnlineUser> getZoomedInUsers();

    /**
     * Plays the given animation on the NPC.
     *
     * @param animation the animation to play
     * @throws IllegalArgumentException if the animation is null
     */
    void playAnimation(@Nonnull NPCAnimation animation) throws IllegalArgumentException;

    /**
     * Makes the NPC look at the given location.
     *
     * @param location the location to look at
     * @throws IllegalArgumentException if the location is null or not in the same world as the NPC
     */
    void lookAt(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Makes the NPC look at the given block.
     *
     * @param block the block to look at
     * @throws IllegalArgumentException if the block is null or not in the same world as the NPC
     */
    void lookAt(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Makes the NPC look at the given vector.
     *
     * @param vector the vector to look at
     * @throws IllegalArgumentException if the vector is null
     */
    void lookAt(@Nonnull Vector vector) throws IllegalArgumentException;

    /**
     * Makes the NPC stop looking at anything and return to its original rotation.
     */
    void sneak();

    /**
     * Makes the NPC stop sneaking.
     */
    void unSneak();

    /**
     * Checks if the NPC is sneaking.
     *
     * @return true if the NPC is sneaking, false otherwise
     */
    boolean isSneaking();

    /**
     * Sets the sneaking state of the NPC.
     *
     * @param sneaking true to make the NPC sneak, false to make it stop sneaking
     */
    void setSneaking(boolean sneaking);

    /**
     * Sets a callback that is called when a user comes close to the NPC.
     *
     * @param callback the callback to set, or null to remove the callback
     * @return this NPC instance
     */
    @Nonnull
    @Contract("_ -> this")
    NPC onComingClose(@Nullable Consumer<OnlineUser> callback);

    /**
     * Gets the chat name of the NPC.
     *
     * @return the chat name of the NPC
     */
    @Nonnull
    @Contract(pure = true)
    String getChatName();

    /**
     * Sets the chat name of the NPC.
     *
     * @param chatName the chat name to set
     * @return this NPC instance
     * @throws IllegalArgumentException if the chat name is null or empty
     */
    @Nonnull
    @Contract("_ -> this")
    NPC setChatName(@Nonnull String chatName) throws IllegalArgumentException;

    /**
     * Gets the chat prefix of the NPC.
     *
     * @return the chat prefix of the NPC
     */
    @Nonnull
    @Contract(pure = true)
    String getChatPrefix();

    /**
     * Sets the chat prefix of the NPC.
     *
     * @param prefix the chat prefix to set
     * @return this NPC instance
     * @throws IllegalArgumentException if the prefix is null or empty
     */
    @Nonnull
    @Contract("_ -> this")
    NPC setChatPrefix(@Nonnull String prefix) throws IllegalArgumentException;

    /**
     * Gets a list of all players who can see the NPC.
     *
     * @return a list of all players who can see the NPC
     */
    @Nonnull
    @Contract(pure = true)
    List<Player> getSeeingPlayers();

    /**
     * Checks if the name tag of the NPC is hidden.
     *
     * @return true if the name tag is hidden, false otherwise
     */
    @Contract(pure = true)
    boolean isNameTagHidden();

    /**
     * Hides or shows the name tag of the NPC.
     *
     * @param hidden true to hide the name tag, false to show it
     */
    void hideNameTag(boolean hidden);
}
