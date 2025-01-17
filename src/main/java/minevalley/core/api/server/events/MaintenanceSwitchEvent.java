package minevalley.core.api.server.events;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@RequiredArgsConstructor
@SuppressWarnings("unused")
public class MaintenanceSwitchEvent extends Event {

    /**
     * Checks whether the maintenance will be enabled or disabled.
     * <p>
     * <b>Note:</b> The maintenance mode transition could still be interrupted!
     */
    private final @Getter boolean enabling;
    private final @Getter(onMethod_ = @Nonnull) List<Runnable> callbacks = Lists.newArrayList();
    public @Getter(onMethod_ = @Nullable) String interruptMessage;

    private static final @Getter(onMethod_ = @Nonnull) HandlerList handlerList = new HandlerList();

    @Override
    public @Nonnull HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * By calling this method, the maintenance mode switch will be interrupted.
     * Only use this method if there would be some kind of conflict with switching maintenance mode.
     * <p>
     * <b>Note:</b> This method can only be used, when disabling maintenance mode.
     * There is no way to interrupt the activation of maintenance mode.
     *
     * @param message clarifying information on how to avoid the existing conflict to switch maintenance mode successfully.
     *                If there are multiple interruptions, only the first one's message will be displayed.
     */
    public void interrupt(@Nonnull String message) throws IllegalArgumentException, IllegalStateException {
        if (message == null) throw new IllegalArgumentException("The message cannot be null!");
        if (enabling) throw new IllegalStateException("Tried to interrupt enabling maintenance mode!");
        interruptMessage = message;
    }

    /**
     * Use this method to add a runnable which will be called, if the maintenance switch was performed without any interruptions.
     * Keep in mind, that this event is called whenever the maintenance is enabled or disabled.
     * Use isEnabling() to check whether is enabled or disabled.
     * <p>
     * <b>Note:</b> in most cases, it's not helpful to add any kind of logic directly in your onMaintenanceSwitch()-method.
     * Add your logic into this callback, otherwise - if the maintenance switch was interrupted by any other module -
     * your code will be called without the maintenance mode switching.
     *
     * @param callback logic that will be called when the maintenance switch was successful
     * @throws IllegalArgumentException if the callback is null
     */
    public void ifNotInterrupted(@Nonnull Runnable callback) throws IllegalArgumentException {
        if (callback == null) throw new IllegalArgumentException("The callback cannot be null!");
        callbacks.add(callback);
    }
}