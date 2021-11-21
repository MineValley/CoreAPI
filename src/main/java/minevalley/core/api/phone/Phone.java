package minevalley.core.api.phone;

import minevalley.core.api.User;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public interface Phone {

    /**
     * This method isn't useable yet.
     */
    void sendNotification();

    /**
     * Calls the given phone.
     * @param phone phone, to start call with
     */
    void call(Phone phone);

    /**
     * Accepts the incoming call.
     */
    void acceptCall();

    /**
     * Activates the player's phone.
     */
    void activate();

    /**
     * Deactivates the player's phone.
     */
    void deactivate();

    /**
     * Gets the target-phone that this phone is calling.
     * @return the target phone
     */
    Phone getOutGoingCallTarget();

    /**
     * Gets the phone that is calling this phone.
     * @return the calling phone
     */
    Phone getIncomingCaller();

    /**
     * Gets the phone's owner.
     * @return the user-object of the phone's owner
     */
    User getOwner();

    /**
     * Gets the current call of the selected phone.
     * Note: Even though the {@link Phone#isInCall()}-method returns true if the phone receives or starts a call, which isn't yet picked up, this object is null as there is no active call in which both phones are involved.
     * @return call-object of current call (null, if there is no call)
     */
    Call getCall();

    /**
     * Gets whether the phone is activated.
     * @return true, if phone is activated
     */
    boolean isActivated();

    /**
     * Gets whether the phone is connected to the network.
     * @return true, if phone is connected to the network
     */
    boolean isConnected();

    /**
     * Gets whether the phone is in a call.
     * @return true, if phone is in a call
     */
    boolean isInCall();

    /**
     * Gets the phone-number of this specific phone.
     * @return phone-number as string
     */
    String getPhoneNumber();
}