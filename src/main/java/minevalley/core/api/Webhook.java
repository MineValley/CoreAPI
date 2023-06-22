package minevalley.core.api;

import java.awt.*;
import java.io.IOException;

/**
 * This Webhook-builder is meant to help you to create discord-webhooks.
 * You can find helpful information here: <a href="https://birdie0.github.io/discord-webhooks-guide/discord_webhook.html">...</a>
 */
public interface Webhook {

    Webhook setUsername(String username);

    Webhook setAvatar(String url);

    void send(EmbeddedMessage... message) throws IOException;

    interface EmbeddedMessage {

        EmbeddedMessage setTitle(String title);

        EmbeddedMessage setDescription(String description);

        EmbeddedMessage setAuthor(String name, String url, String iconUrl);

        EmbeddedMessage setThumbnail(String url);

        EmbeddedMessage setColor(Color color);

        EmbeddedMessage addField(String title, String text, boolean inline);

        EmbeddedMessage setImage(String url);

        EmbeddedMessage setFooter(String footer, String iconUrl);

        EmbeddedMessage setFooter(String footer);
    }
}