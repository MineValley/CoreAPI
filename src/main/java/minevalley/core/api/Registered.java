package minevalley.core.api;

public interface Registered {

    /**
     * Gets the registerNumber of this registered.
     * <p>
     * <b>User:</b> user's unique id
     * <p>
     * <b>Company:</b> company's id
     * <p>
     * <b>Organization:</b> organisation's id
     * <p>
     * <b>Department (of company/organization):</b> department's id
     */
    String getRegisterNumber();
}
