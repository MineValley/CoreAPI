package minevalley.core.api.phone;

import minevalley.core.api.Registered;

import java.util.List;

public interface Telephone {


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
     * Gets the list of registered, that are allowed to use this telephone.
     * If this telephone is called, all of them are being informed,
     * as long as their own phone is activated and is connected to the network.
     *
     * @return list of all permissioned registered
     */
    List<Registered> getPermissioned();

    /**
     * Gets this telephones owner
     *
     * @return owner as registered
     */
    Registered getOwner();

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
     * Gets the current call of the this telephone.
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
