package minevalley.core.api.utils;

import minevalley.core.api.ChatMenu;
import minevalley.core.api.OnlineUser;
import minevalley.core.api.enums.NPCAnimation;
import net.md_5.bungee.api.chat.BaseComponent;
import org.apache.logging.log4j.util.TriConsumer;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.function.BiConsumer;

public interface NPC {

    String getName();

    String getSkinUniqueId();

    void show(Player player);

    void show(OnlineUser user);

    void hide(Player player);

    void hide(OnlineUser user);

    boolean canSee(Player player);

    boolean canSee(OnlineUser user);

    boolean focusNearPlayers();

    void setFocusNearPlayers(boolean focusNearPlayers);

    void playAnimation(NPCAnimation animation);

    void lookAt(Location location);

    void lookAt(Block block);

    void lookAt(Vector vector);

    void sneak();

    void unSneak();

    boolean isSneaking();

    void setSneaking(boolean sneaking);

    NPC onClick(TriConsumer<OnlineUser, Click, NPC> callback);

    NPC onComingClose(BiConsumer<OnlineUser, NPC> callback);

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

    OnlineUser.Notice getTalkWithMeNotice();

    List<Player> getSeeingPlayers();

    Location getLocation();

    void remove();

    enum Click {
        RIGHT_CLICK,
        LEFT_CLICK
    }
}
