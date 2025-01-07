package minevalley.core.api.discord;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Function;

/**
 * This Webhook-builder is meant to help you to create discord-webhooks.
 * You can find helpful information <a href="https://birdie0.github.io/discord-webhooks-guide/discord_webhook.html">here</a>.
 */
@SuppressWarnings("unused")
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
    Webhook setUsername(@Nonnull String username) throws IllegalArgumentException;

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
     * Sends the given messages to the discord-webhook asynchronously.
     * <p>
     * <b>Note:</b> Due to its asynchronous nature, this method may throw a {@link CompletionException} if the sending fails.
     * This exception acts as a wrapper for the underlying exception and can be handled using {@link CompletableFuture#exceptionally(Function)}. To get to the underlying {@link IOException} use {@link CompletionException#getCause()}.
     *
     * @param message The messages to send.
     * @return A future that will be completed when the message was sent.
     * @throws IllegalArgumentException If the message is null, no one is given or the given {@code EmbeddedMessage} is another implementation than our internal.
     */
    @Nonnull
    @Contract(pure = true)
    CompletableFuture<Void> send(@Nonnull EmbeddedMessage... message) throws IllegalArgumentException;
}