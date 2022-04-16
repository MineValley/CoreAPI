package minevalley.core.api.utils;

import minevalley.core.api.ChatMenu;
import minevalley.core.api.User;
import minevalley.core.api.enums.NPCAnimation;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Consumer;
import org.bukkit.util.Vector;

import java.util.List;

public interface NPC {

    String getName();

    String getSkinUniqueId();

    void show(Player player);

    void show(User user);

    void hide(Player player);

    void hide(User user);

    boolean canSee(Player player);

    boolean canSee(User user);

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

    NPC onClick(Consumer<PlayerInteractEvent> callback);

    NPC onComingClose(Consumer<User> callback);

    NPC setChatName();

    String getChatName();

    NPC setChatPrefix();

    String getChatPrefix();

    void say(User user, String text);

    void say(User user, BaseComponent[] baseComponent);

    void say(User user, String text, ChatMenu chatMenu);

    void say(User user, BaseComponent[] baseComponent, ChatMenu chatMenu);

    void say(User user, String text, User.Notice notice);

    void say(User user, BaseComponent[] baseComponent, User.Notice notice);

    void say(User user, String text, ChatMenu chatMenu, User.Notice notice);

    void say(User user, BaseComponent[] baseComponent, ChatMenu chatMenu, User.Notice notice);

    User.Notice getTalkWithMeNotice();

    List<Player> getSeeingPlayers();

    Location getLocation();

    void remove();
}
