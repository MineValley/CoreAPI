package minevalley.core.api.discord;

import java.io.IOException;

/**
 * This Webhook-builder is meant to help you to create discord-webhooks.
 * You can find helpful information here: <a href="https://birdie0.github.io/discord-webhooks-guide/discord_webhook.html">...</a>
 */
public interface Webhook {

    Webhook setUsername(String username);

    Webhook setAvatar(String url);

    void send(EmbeddedMessage... message) throws IOException;
}