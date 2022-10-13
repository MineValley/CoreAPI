package minevalley.core.api.utils;

import minevalley.core.api.OnlineUser;
import minevalley.core.api.User;
import org.bukkit.Location;

import java.util.List;

public interface Hologram {

    void changeLine(int line, String text);

    void removeLine(int line);

    void addLine(String text);

    void addLineAfter(int line, String text);

    String getLine(int line);

    String[] getLines();

    List<User> getViewingUsers();

    List<OnlineUser> getNearbyViewingUsers();

    void show(User user);

    void hide(User user);

    void hideFromEveryone();

    boolean isVisibleToEveryone();

    void setVisibleToEveryone(boolean visibleToEveryone);

    boolean canSee(User user);

    Location getLocation();

    void move(Location location);

    void delete();
}