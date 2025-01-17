package minevalley.core.api.phone;

import minevalley.core.api.Registrant;

import java.util.List;

@SuppressWarnings("unused")
public interface Telephone {

    /**
     * Activates this telephone.
     */
    void activate();

    /**
     * Deactivates this telephone.
     */
    void deactivate();

    /**
     * Gets whether this telephone is activated.
     *
     * @return true, if telephone is activated
     */
    boolean isActivated();

    /**
     * Gets whether the telephone is connected to the network.
     *
     * @return true, if telephone is connected to the network
     */
    boolean isConnected();

    /**
     * Gets the target-telephone that this telephone is calling.
     *
     * @return the target telephone
     */
    Telephone getOutGoingCallTarget();

    /**
     * Gets the phone that is calling this telephone.
     *
     * @return the calling telephone
     */
    Telephone getIncomingCaller();

    /**
     * Gets the list of registrant, that are allowed to use this telephone.
     * If this telephone is called, all of them are being informed,
     * as long as their own phone is activated and is connected to the network.
     *
     * @return list of all permissioned registrant
     */
    List<Registrant> getPermissioned();

    /**
     * Gets this telephones owner
     *
     * @return owner as registrant
     */
    Registrant getOwner();

    /**
     * Accepts the incoming call.
     */
    void acceptCall();

    /**
     * Gets whether this telephone is in a call.
     *
     * @return true, if telephone is in a call
     */
    boolean isInCall();

    /**
     * Gets the current call of this telephone.
     * Note: Even though the {@link Telephone#isInCall()}-method returns true if the telephone receives or starts a call, which isn't yet picked up, this object is null as there is no active call in which both phones are involved.
     *
     * @return call-object of current call (null, if there is no call)
     */
    Call getCall();

    /**
     * Gets the telephone number of this specific telephone.
     *
     * @return telephone number as string
     */
    String getTelephoneNumber();

    /**
     * Calls the given telephone.
     *
     * @param telephone telephone, to start call with
     */
    void call(Telephone telephone);
}
