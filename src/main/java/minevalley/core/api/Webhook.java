package minevalley.core.api;

import java.awt.*;

/**
 * This Webhook-builder is ment to help you creating discord-webhooks.
 * You can find helpful information here: https://birdie0.github.io/discord-webhooks-guide/discord_webhook.html
 */
public interface Webhook {

    Webhook setUsername(String username);

    Webhook setAvatar(String url);

    void send(EmbeddedMessage... message);

    interface EmbeddedMessage {

        EmbeddedMessage setTitle(String title);

        EmbeddedMessage setDescription(String description);

        EmbeddedMessage setAuthor(String name, String url, String iconUrl);

        EmbeddedMessage setThumbnail(String url);

        EmbeddedMessage setColor(Color color);

        EmbeddedMessage addField(String title, String text, boolean inline);

        EmbeddedMessage setImage(String url);

        EmbeddedMessage setFooter(String footer, String iconUrl);
    }
}