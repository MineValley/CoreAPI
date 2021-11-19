package eu.minevalley.core.api.phone;

import eu.minevalley.core.api.User;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;

public interface Phone {

    /**
     * This method isn't useable yet
     */
    void sendNotification();

    /**
     * Defines the call, this phone is in
     * @param call new call for this phone
     */
    void setCall(Call call);

    /**
     * Calls the given phone
     * @param phone phone, to start call with
     */
    void call(Phone phone);

    /**
     * Activates the player's phone
     */
    void activate();

    /**
     * Deactivates the player's phone
     */
    void deactivate();

    /**
     * Defines the target-phone that this phone is calling
     * @param phone new target phone
     */
    void setOutGoingCallTarget(Phone phone);

    /**
     * Defines the phone that is calling this phone
     * @param phone the calling phone
     */
    void setInComingCaller(Phone phone);

    /**
     * Gets the target-phone that this phone is calling
     * @return the target phone
     */
    Phone getOutGoingCallTarget();

    /**
     * Gets the phone that is calling this phone
     * @return the calling phone
     */
    Phone getInComingCaller();

    /**
     * Gets the phone's owner
     * @return the user-object of the phone's owner
     */
    User getOwner();

    /**
     * Gets the current call of the selected phone
     * @return call-object of current call (null, if there is no call)
     */
    Call getCall();

    /**
     * Gets whether the phone is activated
     * @return true, if phone is activated
     */
    boolean isActivated();

    /**
     * Gets whether the phone is connected to the network
     * @return true, if phone is connected to the network
     */
    boolean isConnected();

    /**
     * Gets whether the phone is in a call
     * @return true, if phone is in a call
     */
    boolean isInCall();
}