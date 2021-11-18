package eu.minevalley.core.api.phone;

import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;

public interface Phone {

    void sendNotification(String prefix, ComponentBuilder builder);

    void setCall(Call call);

    void call(Phone phone);

    void activate();

    void deactivate();

    void setOutGoingCallTarget(Phone phone);

    void setInComingCaller(Phone phone);

    Phone getOutGoingCallTarget();

    Phone getInComingCaller();

    Player getOwner();

    Call getCall();

    boolean isActivated();

    boolean isConnected();

    boolean isInCall();
}