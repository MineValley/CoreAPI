package minevalley.core.api.users.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.events.ProxyEvent;
import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class ProxyUserEvent extends ProxyEvent {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
}