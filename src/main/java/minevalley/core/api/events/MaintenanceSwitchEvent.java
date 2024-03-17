package minevalley.core.api.events;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

@RequiredArgsConstructor
@SuppressWarnings("unused")
public class MaintenanceSwitchEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();
    private final boolean enabling;
    public final List<Runnable> callbacks = Lists.newArrayList();
    public String interruptMessage;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    /**
     * By calling this method, the maintenance mode switch will be interrupted.
     * Only use this method if there would be some kind of conflict with switching maintenance mode.
     * <b>Note:</b> This method can only be used, when disabling maintenance mode.
     * There is no way to interrupt the activation of maintenance mode.
     *
     * @param message clarifying information on how to avoid the existing conflict to switch maintenance mode successfully.
     *                If there are multiple interruptions, only the first one's message will be displayed.
     */
    public void interrupt(String message) {
        if (interruptMessage == null && !enabling) interruptMessage = message;
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
     */
    public void ifNotInterrupted(Runnable callback) {
        callbacks.add(callback);
    }

    /**
     * Checks whether the maintenance will be enabled or disabled.
     * <p>
     * <b>Note:</b> The maintenance mode transition could still be interrupted!
     * </p>
     *
     * @return true, if the maintenance will be enabled
     */
    public boolean isEnabling() {
        return enabling;
    }
}