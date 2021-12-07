package minevalley.core.api.economy;

public interface Holder {

    /**
     * Gets the registerNumber of this holder.
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
