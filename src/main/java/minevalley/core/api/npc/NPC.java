package minevalley.core.api.npc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.ChatMenu;
import minevalley.core.api.armorstand.FakeArmorStand;
import minevalley.core.api.users.OnlineUser;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public interface NPC {

    String getName();

    /**
     * Defines which users can see the npc
     * <br>
     * <b>Default:</b> Everyone can see the npc
     *
     * @param function defines whether a specific user can see the npc
     */
    void setVisibility(Function<OnlineUser, Boolean> function);

    /**
     * Updates the visibility of the npc
     * <br>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for every user that the npc is or could be visible to
     */
    void updateVisibility();

    /**
     * Updates the visibility of the npc for a specific user
     * <br>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for this user
     *
     * @param user to update the visibility for
     */
    void updateVisibility(OnlineUser user);

    /**
     * Sets & updates the equipment of the npc for everyone
     */
    void updateEquipment();

    boolean focusNearPlayers();

    void setFocusNearPlayers(boolean focusNearPlayers);

    void zoomIn(OnlineUser user, boolean allowManualZoomOut);

    default void zoomIn(OnlineUser user) {
        zoomIn(user, true);
    }

    void zoomOut(OnlineUser user);

    void onZoomOut(Consumer<OnlineUser> callback);

    boolean isZoomedIn(OnlineUser user);

    List<OnlineUser> getZoomedInUsers();

    void playAnimation(NPCAnimation animation);

    void lookAt(Location location);

    void lookAt(Block block);

    void lookAt(Vector vector);

    void sneak();

    void unSneak();

    boolean isSneaking();

    void setSneaking(boolean sneaking);

    void ride(FakeArmorStand fakeArmorStand);

    ItemStack getLeftHand();

    NPC setLeftHand(ItemStack itemStack);

    ItemStack getRightHand();

    NPC setRightHand(ItemStack itemStack);

    ItemStack getHelmet();

    NPC setHelmet(ItemStack helmet);

    ItemStack getChestplate();

    NPC setChestplate(ItemStack chestplate);

    ItemStack getLeggings();

    NPC setLeggings(ItemStack leggings);

    ItemStack getBoots();

    NPC setBoots(ItemStack boots);

    NPC onClick(BiConsumer<OnlineUser, Click> callback);

    NPC onComingClose(Consumer<OnlineUser> callback);

    String getChatName();

    NPC setChatName(String chatName);

    String getChatPrefix();

    NPC setChatPrefix(String prefix);

    void say(OnlineUser user, String text);

    void say(OnlineUser user, BaseComponent[] baseComponent);

    void say(OnlineUser user, String text, ChatMenu chatMenu);

    void say(OnlineUser user, BaseComponent[] baseComponent, ChatMenu chatMenu);

    void say(OnlineUser user, String text, OnlineUser.Notice notice);

    void say(OnlineUser user, BaseComponent[] baseComponent, OnlineUser.Notice notice);

    void say(OnlineUser user, String text, ChatMenu chatMenu, OnlineUser.Notice notice);

    void say(OnlineUser user, BaseComponent[] baseComponent, ChatMenu chatMenu, OnlineUser.Notice notice);

    void say(OnlineUser user, RandomText... text);

    void say(OnlineUser user, ChatMenu chatMenu, RandomText... text);

    void say(OnlineUser user, OnlineUser.Notice notice, RandomText... text);

    void say(OnlineUser user, ChatMenu chatMenu, OnlineUser.Notice notice, RandomText... text);

    OnlineUser.Notice getTalkWithMeNotice();

    List<Player> getSeeingPlayers();

    Location getLocation();

    void remove();

    boolean isNameTagHidden();

    void hideNameTag(boolean hidden);

    enum Click {
        RIGHT_CLICK,
        LEFT_CLICK
    }

    @Getter
    @AllArgsConstructor
    @RequiredArgsConstructor
    class RandomText {

        private float factor = 1;
        private final String text;
    }
}
