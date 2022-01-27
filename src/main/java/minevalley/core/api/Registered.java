package minevalley.core.api;

public interface Registered {

    /**
     * Gets the registerNumber of this registered.
     * <p>
     * <b>User:</b> user's unique id
     * <p>
     * <b>Company:</b> company's id
     * <p>
     * <b>Organization:</b> organization's id
     * <p>
     * <b>Department (of company/organization):</b> department's id
     */
    String getRegisterNumber();

    /**
     * Gets the name to display on signs etc.
     * <p>
     * <b>User:</b> user's name
     * <p>
     * <b>Company:</b> company's name
     * <p>
     * <b>Organization:</b> organizsation's name
     * <p>
     * <b>Department (of company/organization):</b> name of department - name of company/organisation
     * <p>
     * <p>
     * <b>Note:</b> department names may be longer than 16 characters and can therefore not been put onto signs!
     */
    String getDisplayName();
}
