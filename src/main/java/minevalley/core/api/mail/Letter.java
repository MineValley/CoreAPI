package minevalley.core.api.mail;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Letter extends Parcel {

    /**
     * Gets the content of this letter.
     *
     * @return content of each page in this letter.
     */
    @Nonnull
    @Contract(pure = true)
    String[] getPages();

}
