package eu.minevalley.core.api.phone;

public interface Call {

    /**
     * Ends the current call
     */
    void end();

    /**
     * Gets the phone, that started the call
     * @return phone-object of caller
     */
    Phone getCaller();

    /**
     * Gets the phone, that got called
     * @return phone-object of called player
     */
    Phone getPartner();
}