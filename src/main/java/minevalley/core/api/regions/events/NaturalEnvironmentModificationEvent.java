package minevalley.core.api.regions.events;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class NaturalEnvironmentModificationEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final Block block;
    private final boolean nativelyInterrupted;
    private final Event underlyingEvent;

    @Getter(AccessLevel.NONE)
    private boolean overwrite;

    public NaturalEnvironmentModificationEvent(@Nonnull Block block, boolean nativelyInterrupted, @Nonnull Event underlyingEvent) {
        this.block = block;
        this.nativelyInterrupted = nativelyInterrupted;
        this.underlyingEvent = underlyingEvent;
        this.overwrite = nativelyInterrupted;
    }

    public void allow() {
        overwrite = true;
    }

    public void deny() {
        overwrite = false;
    }

    public boolean isFinallyAllowed() {
        return overwrite;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @Nonnull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

}