package minevalley.core.api.users.events.audio;

import lombok.Getter;
import minevalley.core.api.audio.SoundReceiver;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;
import net.kyori.adventure.sound.Sound;

import javax.annotation.Nonnull;

/**
 * Fired when a sound is about to be played to a user via {@link SoundReceiver#playSound(Sound.Type)}.
 * <p>
 * The event is triggered <em>before</em> the sound is actually played, allowing you to call {@link #muffle()}
 * to add a muffle effect for this user.
 * <p>
 * If the sound targets multiple users (e.g. a team or the whole server), this event is fired separately
 * for each affected user.
 */
@SuppressWarnings("unused")
public class UserPlaySoundEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) String sound;
    private @Getter boolean muffled;

    public UserPlaySoundEvent(@Nonnull ProxyUser user, @Nonnull String sound) {
        super(user);
        this.sound = sound;
    }

    public UserPlaySoundEvent(@Nonnull ProxyUser user, @Nonnull Sound.Type sound) {
        super(user);
        this.sound = sound.key().asString();
    }

    public void muffle() {
        this.muffled = true;
    }
}