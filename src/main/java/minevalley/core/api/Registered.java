package minevalley.core.api;

public interface Registered {

    /**
     * Gets the registerNumber of this registered.
     * <p>
     * <b>User:</b> users unique id
     * <p>
     * <b>Company:</b> companies id
     * <p>
     * <b>Organization:</b> organisations id
     * <p>
     * <b>Department (of company/organization):</b> id of company/organisation : id of department
     */
    String getRegisterNumber();
}
