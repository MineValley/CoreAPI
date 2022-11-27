package minevalley.core.api.mail;

public interface Letter extends Parcel {

    /**
     * Gets the content of this letter.
     */
    String[] getPages();

}
