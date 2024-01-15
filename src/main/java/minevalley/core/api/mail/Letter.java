package minevalley.core.api.mail;

public interface Letter extends Parcel {

    /**
     * Gets the content of this letter.
     *
     * @return content of each page in this letter.
     */
    String[] getPages();

}
