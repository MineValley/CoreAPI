package minevalley.core.api.npc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.armorstand.FakeArmorStand;
import minevalley.core.api.messaging.MessageSender;
import minevalley.core.api.messaging.instruction.Instruction;
import minevalley.core.api.modifiers.EquipmentModifier;
import minevalley.core.api.modifiers.InteractionModifier;
import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.VisibilityModifier;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface NPC extends MessageSender, EquipmentModifier, InteractionModifier, LocationModifier, VisibilityModifier {

    String getName();

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

    void exitVehicle();

    FakeArmorStand getRiddenFakeArmorStand();

    boolean isRiding();

    NPC onComingClose(Consumer<OnlineUser> callback);

    String getChatName();

    NPC setChatName(String chatName);

    String getChatPrefix();

    NPC setChatPrefix(String prefix);

    Instruction getTalkWithMeInstruction();

    List<Player> getSeeingPlayers();

    Location getLocation();

    boolean isNameTagHidden();

    void hideNameTag(boolean hidden);

    @Getter
    @AllArgsConstructor
    @RequiredArgsConstructor
    class RandomText {

        private float factor = 1;
        private final String text;
    }
}
