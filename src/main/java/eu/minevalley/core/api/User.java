package eu.minevalley.core.api;

import eu.minevalley.core.api.enums.Fraction;
import eu.minevalley.core.api.enums.MessageType;
import eu.minevalley.core.api.enums.PlayerRank;
import eu.minevalley.core.api.enums.TeamRank;
import eu.minevalley.core.api.utils.ChatInterface;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface User {

    void refresh();

    void joinTeamService();

    void leaveTeamService();

    void sendMessage(String message);

    void sendMessage(MessageType messageType, String message);

    void sendMessage(BaseComponent baseComponent);

    void sendError();

    void input(String message, Consumer<String> consumer);

    void leaveInterface();

    void updateCash();


    boolean hasPlayerRank(PlayerRank... ranks);

    boolean hasTeamRank(TeamRank... ranks);

    boolean isTeamler();

    boolean payCash(double amount);

    double getCash();

    int getWantedLevel();


    boolean isAllowedToUseGeneralKey();

    boolean isUsingGeneralKey();

    boolean canEnterSupportService();

    boolean isSupportService();

    boolean isKnockedOut();

    ItemStack getPlayerHead();

    String getUniqueId();

    String getId();

    Player getPlayer();

    // Phone getPhone(); ?!

    // BankAccount getBankAccount(); !?

    Fraction getFraction();

    TeamRank getTeamRank();

    PlayerRank getPlayerRank();

    ChatInterface getChatInterface();
}