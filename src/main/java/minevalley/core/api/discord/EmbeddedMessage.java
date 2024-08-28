package minevalley.core.api.discord;

import java.awt.*;

public interface EmbeddedMessage {

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