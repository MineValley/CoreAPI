package eu.minevalley.core.api.user.event;

import eu.minevalley.core.api.event.ProxyEvent;
import eu.minevalley.core.api.user.ProxyUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class ProxyUserEvent extends ProxyEvent {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
}