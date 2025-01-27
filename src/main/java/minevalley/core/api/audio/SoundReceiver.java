package minevalley.core.api.audio;

import net.kyori.adventure.sound.Sound;
import org.bukkit.Location;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface SoundReceiver {

    /**
     * Plays a specific sound.
     *
     * @param sound sound to be played
     * @throws IllegalArgumentException if sound is null or an empty string
     */
    void playSound(@Nonnull Sound.Type sound) throws IllegalArgumentException;

    /**
     * Plays a specific sound.
     *
     * @param sound    sound to be played
     * @param location location where the sound will be played
     * @param spatial  defines whether the sound should be spatial
     * @throws IllegalArgumentException if sound or location is null, or the location is not in the same world as the user
     */
    void playSound(@Nonnull Sound.Type sound, @Nonnull Location location, boolean spatial) throws IllegalArgumentException;
}
