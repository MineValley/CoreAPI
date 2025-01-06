package minevalley.core.api.discord;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.awt.*;

@SuppressWarnings("unused")
public interface EmbeddedMessage {

    /**
     * Sets the title of the embedded message.
     *
     * @param title The title of the embedded message.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the title is null.
     */
    @Nonnull
    @Contract("_ -> this")
    EmbeddedMessage setTitle(@Nonnull String title) throws IllegalArgumentException;

    /**
     * Sets the description of the embedded message.
     *
     * @param description The description of the embedded message.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the description is null.
     */
    @Nonnull
    @Contract("_ -> this")
    EmbeddedMessage setDescription(@Nonnull String description) throws IllegalArgumentException;

    /**
     * Sets the author of the embedded message.
     *
     * @param name    The name of the author.
     * @param url     The URL of the author.
     * @param iconUrl The URL of the author's icon.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the name, URL or icon URL is null.
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    EmbeddedMessage setAuthor(@Nonnull String name, @Nonnull String url, @Nonnull String iconUrl) throws IllegalArgumentException;

    /**
     * Sets the thumbnail of the embedded message.
     *
     * @param url The URL of the thumbnail.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the URL is null.
     */
    @Nonnull
    @Contract("_ -> this")
    EmbeddedMessage setThumbnail(@Nonnull String url) throws IllegalArgumentException;

    /**
     * Sets the color of the embedded message.
     *
     * @param color The color of the embedded message.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the color is null.
     */
    @Nonnull
    @Contract("_ -> this")
    EmbeddedMessage setColor(@Nonnull Color color) throws IllegalArgumentException;

    /**
     * Adds a field to the embedded message.
     *
     * @param title  The title of the field.
     * @param text   The text of the field.
     * @param inline Whether the field should be inline or not.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the title or text is null.
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    EmbeddedMessage addField(@Nonnull String title, @Nonnull String text, boolean inline) throws IllegalArgumentException;

    /**
     * Sets the image of the embedded message.
     *
     * @param url The URL of the image.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the URL is null.
     */
    @Nonnull
    @Contract("_ -> this")
    EmbeddedMessage setImage(@Nonnull String url) throws IllegalArgumentException;

    /**
     * Sets the footer of the embedded message.
     *
     * @param footer  The footer of the embedded message.
     * @param iconUrl The URL of the footer's icon.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the footer is null.
     */
    @Nonnull
    @Contract("_, _ -> this")
    EmbeddedMessage setFooter(@Nonnull String footer, @Nonnull String iconUrl) throws IllegalArgumentException;

    /**
     * Sets the footer of the embedded message.
     *
     * @param footer The footer of the embedded message.
     * @return The current instance of the embedded message.
     * @throws IllegalArgumentException If the footer is null.
     */
    @Nonnull
    @Contract("_ -> this")
    default EmbeddedMessage setFooter(@Nonnull String footer) throws IllegalArgumentException {
        return setFooter(footer, "");
    }
}