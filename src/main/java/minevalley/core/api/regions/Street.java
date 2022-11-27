package minevalley.core.api.regions;

public interface Street {

    /**
     * Every street will be assigned an ID. It should be used to refer to this street.
     */
    int getId();

    /**
     * Gets this streets name. Don't use it to refer to the street. Names might change in the future. Use getId instead!
     */
    String getName();

    /**
     * Get the description of this street. Not every street does have a description. If the street doesn't have a description, this is null.
     */
    String getDescription();
}
