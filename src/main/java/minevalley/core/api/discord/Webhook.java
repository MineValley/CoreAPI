package minevalley.core.api.discord;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * This Webhook-builder is meant to help you to create discord-webhooks.
 * You can find helpful information <a href="https://birdie0.github.io/discord-webhooks-guide/discord_webhook.html">here</a>.
 */
public interface Webhook {

    /**
     * Sets the username of the webhook.
     *
     * @param username The username of the webhook.
     * @return The current instance of the webhook.
     * @throws IllegalArgumentException If the username is null.
     */
    @Nonnull
    @Contract("_ -> this")
    Webhook setUsername(@Nonnull String username);

    /**
     * Sets the avatar of the webhook.
     *
     * @param url The URL of the avatar.
     * @return The current instance of the webhook.
     * @throws IllegalArgumentException If the URL is null.
     */
    @Nonnull
    @Contract("_ -> this")
    Webhook setAvatar(@Nonnull String url) throws IllegalArgumentException;

    /**
     * Sends the given messages to the discord-webhook.
     *
     * @param message The messages to send.
     * @throws IOException              If an I/O error occurs.
     * @throws IllegalArgumentException If the message is null, or the given {@code EmbeddedMessage} is another implementation than our internal.
     */
    @Contract(pure = true)
    void send(@Nonnull EmbeddedMessage... message) throws IOException, IllegalArgumentException;
}