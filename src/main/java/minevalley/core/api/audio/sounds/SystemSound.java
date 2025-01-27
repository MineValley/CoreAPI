package minevalley.core.api.audio.sounds;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SystemSound implements Sound.Type {

    /**
     * Used to get the user's attention.
     */
    NOTIFICATION_INFO("notification_info"),

    /**
     * Used to signal the success of a relevant process.
     */
    NOTIFICATION_SUCCESS("notification_success"),

    /**
     * Used to signal the failure of a process the user tried to perform.
     */
    NOTIFICATION_ERROR("notification_error");

    private final String key;

    @Override
    public @Nonnull Key key() {
        return new NamespacedKey("minevalley", key);
    }
}