package minevalley.core.api.registrant.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.event.ProxyEvent;
import minevalley.core.api.registrant.ProxyUser;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class ProxyUserEvent extends ProxyEvent {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
}